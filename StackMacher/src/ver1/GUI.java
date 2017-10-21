package ver1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI
{

	private JFrame frmJava;
	public static JTextField textField;

	// public static TextField
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
					window.frmJava.setVisible(true);
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
		frmJava = new JFrame();
		frmJava.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		frmJava.setTitle("JAVA\u5206\u9694\u7B26\u5339\u914D");
		frmJava.setBounds(100, 100, 665, 354);
		frmJava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJava.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setText("a=(b+c)*(d+e)");
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField.setBounds(70, 100, 454, 40);
		frmJava.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Please input a JAVA expression:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel.setBounds(70, 70, 300, 18);
		frmJava.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Verify");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Matcher_fixed e = new Matcher_fixed();
				try
				{
					if (e.isLegal(textField.getText()))
						// System.out.println("Invalid JAVA expression!");
						textField.setText("Valid JAVA expression!");
					else
						// System.out.println("Invalid JAVA expression!");
						textField.setText("Invalid JAVA expression!");
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(255, 153, 126, 49);
		frmJava.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("C");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				textField.setText("");
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(519, 100, 43, 40);
		frmJava.getContentPane().add(btnNewButton_1);
	}
}
