package homer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UI extends JFrame
{

	private JPanel contentPane;
	private JTextField powerField;
	private JTextField paraField;
	private JTextField varblField;
	private JTextField resultField;

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
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public UI()
	{
		setResizable(false);
		setTitle("\u4E00\u5143\u591A\u9879\u5F0F\u6C42\u548C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 指数标签
		JLabel lblPower = new JLabel("\u6B21\u6570n");
		lblPower.setFont(new Font("宋体", Font.PLAIN, 17));
		lblPower.setBounds(114, 75, 72, 18);
		contentPane.add(lblPower);

		// 变量标签
		JLabel lblx = new JLabel("\u53D8\u91CFx0");
		lblx.setFont(new Font("宋体", Font.PLAIN, 17));
		lblx.setBounds(114, 186, 72, 18);
		contentPane.add(lblx);

		// 参数标签
		JLabel lblai = new JLabel("\u7CFB\u6570ai");
		lblai.setFont(new Font("宋体", Font.PLAIN, 17));
		lblai.setBounds(114, 130, 72, 18);
		contentPane.add(lblai);

		// 指数输入域
		powerField = new JTextField();
		powerField.setText("5");
		powerField.setBounds(224, 73, 155, 24);
		contentPane.add(powerField);
		powerField.setColumns(10);

		// 参数输入域
		paraField = new JTextField();
		paraField.setText("1,2,3,4,5,6");
		paraField.setColumns(10);
		paraField.setBounds(224, 128, 155, 24);
		contentPane.add(paraField);

		// 变量输入域
		varblField = new JTextField();
		varblField.setText("5");
		varblField.setColumns(10);
		varblField.setBounds(224, 184, 155, 24);
		contentPane.add(varblField);

		// 计算按钮及事件处理
		JButton sumButton = new JButton("\u6C42\u548C");
		sumButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// 从输入域获取指数
				int power = Integer.parseInt(powerField.getText());

				// 从输入域获取以","分隔的参数数组
				String[] str = paraField.getText().split("\\,");
				double array[] = new double[str.length];
				for (int i = 0; i < str.length; i++)
				{
					array[i] = Double.parseDouble(str[i]);
				}

				// 从输入域获取变量
				double x0 = Double.parseDouble(varblField.getText());

				// 调用算法，输出结果
				double result = 0;
				result = Algs.compute(power, array, x0);
				resultField.setText(Double.toString(result));
			}
		});
		sumButton.setBounds(108, 235, 63, 40);
		contentPane.add(sumButton);

		resultField = new JTextField();
		resultField.setColumns(10);
		resultField.setBounds(224, 243, 155, 24);
		contentPane.add(resultField);

		JTextArea txtrai = new JTextArea();
		txtrai.setText(
				"\u8BF4\u660E\uFF1A\u8F93\u5165\u5404\u9879\u53C2\u6570\u540E\u70B9\u51FB\u6C42\u548C\u5373\u53EF\u8BA1\u7B97\u4E00\u6B21\u591A\u9879\u5F0F\u7684\u548C\r\n\u6CE8\u610F\uFF1A1.\u7CFB\u6570ai\u7684\u5404\u4E2A\u503C\u9700\u8981\u7528\u82F1\u6587\u9017\u53F7\",\"\u9694\u5F00\r\n      2.\u6CA1\u6709\u52A0\u5165\u5F02\u5E38\u5904\u7406\uFF0C\u6570\u636E\u8F93\u5165\u65F6\u8BF7\u81EA\u884C\u68C0\u67E5");
		txtrai.setEditable(false);
		txtrai.setBounds(78, 305, 361, 71);
		contentPane.add(txtrai);
	}
}
