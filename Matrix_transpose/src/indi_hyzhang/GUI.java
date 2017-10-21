package indi_hyzhang;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class GUI
{

	private JFrame frame;
	private JButton clr_button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("矩阵转置");
		frame.setBounds(100, 100, 650, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("需转置矩阵");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(24, 28, 188, 18);
		frame.getContentPane().add(label);

		JLabel lblAfterTrans = new JLabel("After transposition");
		lblAfterTrans.setFont(new Font("宋体", Font.PLAIN, 17));
		lblAfterTrans.setBounds(328, 28, 176, 18);
		frame.getContentPane().add(lblAfterTrans);
		lblAfterTrans.setVisible(false);

		JTextArea inputArea = new JTextArea();
		inputArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		inputArea.setText("0 0 8 0 0 0\r\n0 0 0 0 0 0\r\n5 0 0 0 16 0\r\n0 0 18 0 0 0\r\n0 0 0 9 0 0");
		inputArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 2, false));
		inputArea.setLineWrap(true);
		inputArea.setBounds(24, 53, 278, 396);
		frame.getContentPane().add(inputArea);

		JTextArea outputArea = new JTextArea();
		outputArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		outputArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 2, false));
		outputArea.setLineWrap(true);
		outputArea.setBounds(326, 53, 278, 396);
		frame.getContentPane().add(outputArea);

		JButton trans_button = new JButton("Transpose");
		trans_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// File f = new File("temp.txt");
				// PrintStream ps = null;
				// try
				// {
				// ps = new PrintStream(f);
				// } catch (FileNotFoundException e)
				// {
				// e.printStackTrace();
				// }
				// ps.print(inputArea.getText());
				// try
				// {
				// Scanner sc = new Scanner(f);
				// while (sc.hasNextInt())
				// {
				// System.out.println(sc.nextInt());
				// }
				// } catch (FileNotFoundException e)
				// {
				// e.printStackTrace();
				// }

				String strtemp = inputArea.getText();
				// System.out.println(strtemp);
				// String[] sa;
				// sa = strtemp.split("\r\n");
				// for (int i = 0; i < sa.length; i++)
				// System.out.println(sa[i]);
				// System.out.println(sa.length);

				Resolver res = new Resolver();
				int m[][] = res.resolve(strtemp);
				SparseMatrix sm = new SparseMatrix(m);
				String str1 = sm.printMatrix();
				// SparseMatrix tm = sm.fasttranspose();
				// String str2 = tm.printMatrix();

				int[][] temp = sm.transpose(m);
				SparseMatrix tpm = new SparseMatrix(temp);
				String str3 = tpm.printMatrix();

				label.setText("Before transposition");
				lblAfterTrans.setVisible(true);
				inputArea.setText(str1);
				outputArea.setText(str3);

			}
		});
		trans_button.setBounds(24, 451, 278, 75);
		frame.getContentPane().add(trans_button);

		clr_button = new JButton("Restore Default");
		clr_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				outputArea.setText("");
				inputArea.setText("0 0 8 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "5 0 0 0 16 0\r\n" + "0 0 18 0 0 0\r\n"
						+ "0 0 0 9 0 0");
				label.setText("需转置矩阵");
				lblAfterTrans.setVisible(false);
			}
		});
		clr_button.setBounds(326, 451, 278, 75);
		frame.getContentPane().add(clr_button);

	}
}
