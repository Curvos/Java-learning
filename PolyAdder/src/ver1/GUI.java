package ver1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI
{

	private JFrame frame;
	private JTextField areaA;
	private JTextField areaB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception
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

		// Resolver reso = new Resolver("1,2 3,4 5,6");
	}

	/**
	 * Create the application.
	 */
	public GUI() throws Exception
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception
	{
		frame = new JFrame();
		frame.setTitle("\u4E00\u5143\u591A\u9879\u5F0F\u52A0\u6CD5");
		frame.setBounds(100, 100, 600, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(31, 31, 518, 113);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u8BF7\u8F93\u5165\u591A\u9879\u5F0FA\u5404\u9879\u7CFB\u6570\u548C\u6307\u6570");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(132, 68, 227, 43);
		panel_1.add(lblNewLabel);

		areaA = new JTextField();
		areaA.setText("1.0,2 4.0,5 7.0,6");
		areaA.setFont(new Font("宋体", Font.PLAIN, 16));
		areaA.setBounds(14, 13, 490, 43);
		panel_1.add(areaA);
		areaA.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(308, 301, 241, 189);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 13, 213, 163);
		panel_2.add(textArea);

		JButton btnNewButton = new JButton("\u6C42\u548C");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String strA = areaA.getText();
				String strB = areaB.getText();
				Resolver reA = new Resolver(strA);
				Resolver reB = new Resolver(strB);
				double[] coefA = reA.getCoefs();
				int[] expnA = reA.getExpns();
				double[] coefB = reB.getCoefs();
				int[] expnB = reB.getExpns();

				PolynList LA = new PolynList(reA.num(), coefA, expnA);
				PolynList LB = new PolynList(reB.num(), coefB, expnB);

				LA = LA.addPolyn(LA, LB);
				LA.display();
				textArea.setText(PolynList.result);
			}
		});
		btnNewButton.setBounds(31, 301, 241, 54);
		frame.getContentPane().add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(31, 157, 518, 113);
		frame.getContentPane().add(panel);

		JLabel lblb = new JLabel("\u8BF7\u8F93\u5165\u591A\u9879\u5F0FB\u5404\u9879\u7CFB\u6570\u548C\u6307\u6570");
		lblb.setFont(new Font("宋体", Font.PLAIN, 16));
		lblb.setBounds(132, 68, 227, 43);
		panel.add(lblb);

		areaB = new JTextField();
		areaB.setText("2.0,3 9.0,4");
		areaB.setFont(new Font("宋体", Font.PLAIN, 16));
		areaB.setColumns(10);
		areaB.setBounds(14, 13, 490, 43);
		panel.add(areaB);

		JLabel label = new JLabel(
				"\u8F93\u5165\u683C\u5F0F\uFF1A\u7CFB\u65701,\u6307\u65701 \u7CFB\u65702,\u6307\u65702");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(14, 381, 280, 84);
		frame.getContentPane().add(label);
	}
}
