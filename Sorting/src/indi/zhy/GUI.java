package indi.zhy;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI
{
	public final static int INFINITY = Integer.MAX_VALUE;
	private JFrame frame;
	public static StringBuffer sb;
	public static JTextField input;

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
	 * 
	 * @throws Exception
	 */
	public GUI() throws Exception
	{
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		sb = new StringBuffer("");

		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("查找");
		frame.setBounds(100, 100, 582, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea promt = new JTextArea();
		promt.setFont(new Font("Monospaced", Font.PLAIN, 15));
		promt.setLineWrap(true);
		promt.setBounds(164, 97, 383, 105);
		frame.getContentPane().add(promt);

		JLabel label_1 = new JLabel("输入序列");
		label_1.setBounds(59, 32, 72, 18);
		frame.getContentPane().add(label_1);

		input = new JTextField();
		input.setText("52,39,67,95,70,8,25,52");
		input.setColumns(10);
		input.setBounds(164, 23, 383, 41);
		frame.getContentPane().add(input);

		JLabel lblNewLabel_2 = new JLabel("提示框");
		lblNewLabel_2.setBounds(62, 108, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(7, 77, 564, 7);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(7, 215, 564, 7);
		frame.getContentPane().add(separator_1);

		JLabel label_3 = new JLabel("功能域");
		label_3.setBounds(72, 235, 72, 18);
		frame.getContentPane().add(label_3);

		JButton btnNewButton = new JButton("希尔排序");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sb.append("希尔排序后:").append("\r\n");

				String str = input.getText();
				String strs[] = str.split(",");

				int array[] = new int[strs.length];
				for (int i = 0; i < strs.length; i++)
				{
					array[i] = Integer.parseInt(String.valueOf(strs[i]));
				}
				int[] d = array;

				int[] dlta = { 5, 3, 1 };

				int maxSize = 20;
				SeqList L = new SeqList(maxSize);

				for (int i = 0; i < d.length; i++)
				{
					RecordNode r = new RecordNode(d[i]);
					try
					{
						L.insert(L.length(), r);
					} catch (Exception e2)
					{

						e2.printStackTrace();
					}
				}

				L.shellSort(dlta);

				promt.setText(sb.toString());
				sb.setLength(0);
			}
		});
		btnNewButton.setBounds(177, 224, 122, 41);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("快速排序");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sb.append("快速排序后:").append("\r\n");

				String str = input.getText();
				String strs[] = str.split(",");

				int array[] = new int[strs.length];
				for (int i = 0; i < strs.length; i++)
				{
					array[i] = Integer.parseInt(String.valueOf(strs[i]));
				}
				int[] d = array;

				int maxSize = 20;
				SeqList L = new SeqList(maxSize);

				for (int i = 0; i < d.length; i++)
				{
					RecordNode r = new RecordNode(d[i]);
					try
					{
						L.insert(L.length(), r);
					} catch (Exception e2)
					{

						e2.printStackTrace();
					}
				}
				L.quickSort();

				L.display();
				promt.setText(sb.toString());
				sb.setLength(0);
			}
		});
		button.setBounds(313, 224, 122, 41);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("归并排序");
		button_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sb.append("归并排序后:").append("\r\n");

				String str = input.getText();
				String strs[] = str.split(",");

				int array[] = new int[strs.length];
				for (int i = 0; i < strs.length; i++)
				{
					array[i] = Integer.parseInt(String.valueOf(strs[i]));
				}
				int[] d = array;

				int maxSize = 20;
				SeqList L = new SeqList(maxSize);

				for (int i = 0; i < d.length; i++)
				{
					RecordNode r = new RecordNode(d[i]);
					try
					{
						L.insert(L.length(), r);
					} catch (Exception e2)
					{

						e2.printStackTrace();
					}
				}
				L.mergeSort();

				L.display();
				promt.setText(sb.toString());
				sb.setLength(0);
			}
		});
		button_1.setBounds(449, 224, 122, 41);
		frame.getContentPane().add(button_1);

	}
}
