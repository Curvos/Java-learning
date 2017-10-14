package imp1;

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
import javax.swing.SwingConstants;

public class GUI
{

	private JFrame frame;
	private JTextField creField;
	private JTextField insIndex;
	private JTextField insElem;
	private JTextField dropElem;
	private JTextField indexElem;
	private SeqList list;
	private JTextField getFiled;

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
	private void initialize() throws Exception
	{
		frame = new JFrame();
		frame.setTitle("\u987A\u5E8F\u8868\u57FA\u672C\u64CD\u4F5C");
		frame.setBounds(100, 100, 750, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(457, 13, 261, 375);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(14, 195, 411, 225);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JTextArea displayArea = new JTextArea();
		displayArea.setBounds(14, 13, 227, 200);
		panel_1.add(displayArea);
		displayArea.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		displayArea.setWrapStyleWord(true);
		displayArea.setLineWrap(true);

		JLabel creList = new JLabel("\u521B\u5EFA\u7EBF\u6027\u8868");
		creList.setFont(new Font("宋体", Font.PLAIN, 17));
		creList.setBounds(40, 28, 105, 38);
		frame.getContentPane().add(creList);

		creField = new JTextField();
		creField.setText("\u7EBF\u6027\u8868\u5927\u5C0F");
		creField.setBounds(159, 35, 98, 24);
		frame.getContentPane().add(creField);
		creField.setColumns(10);

		JLabel label = new JLabel("\u5C06");
		label.setBounds(14, 13, 26, 38);
		panel.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 17));

		insElem = new JTextField();
		insElem.setBounds(67, 17, 65, 32);
		panel.add(insElem);
		insElem.setHorizontalAlignment(SwingConstants.CENTER);
		insElem.setText("\u5143\u7D20");
		insElem.setColumns(10);

		JLabel label_3 = new JLabel("\u63D2\u5165");
		label_3.setBounds(142, 13, 46, 38);
		panel.add(label_3);
		label_3.setFont(new Font("宋体", Font.PLAIN, 17));

		insIndex = new JTextField();
		insIndex.setBounds(184, 17, 71, 32);
		panel.add(insIndex);
		insIndex.setHorizontalAlignment(SwingConstants.CENTER);
		insIndex.setText("\u4F4D\u7F6E");
		insIndex.setColumns(10);

		JButton button_4 = new JButton("\u63D2\u5165");
		button_4.setEnabled(false);
		button_4.setBounds(281, 14, 115, 36);
		panel.add(button_4);
		button_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int index = Integer.parseInt(insIndex.getText());
				Object elem = insElem.getText();
				try
				{
					list.insert(index, elem);
				} catch (Exception e1)
				{
					e1.printStackTrace();
				} finally
				{
					displayArea.setText("已将元素 " + elem + " 插入位置 " + index + ".");
				}
			}
		});
		button_4.setFont(new Font("宋体", Font.PLAIN, 17));

		JButton button_5 = new JButton("\u5220\u9664");
		button_5.setEnabled(false);
		button_5.setBounds(281, 77, 115, 36);
		panel.add(button_5);
		button_5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int remIndex = Integer.parseInt(dropElem.getText());
				try
				{
					list.remove(remIndex);
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally
				{
					displayArea.setText("已删除位置为 " + remIndex + " 的元素.");
				}
			}
		});
		button_5.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel label_4 = new JLabel("\u7684\u5143\u7D20\u5220\u9664");
		label_4.setBounds(163, 76, 105, 38);
		panel.add(label_4);
		label_4.setFont(new Font("宋体", Font.PLAIN, 17));

		dropElem = new JTextField();
		dropElem.setBounds(96, 78, 53, 32);
		panel.add(dropElem);
		dropElem.setHorizontalAlignment(SwingConstants.CENTER);
		dropElem.setText("\u4F4D\u7F6E");
		dropElem.setColumns(10);

		JLabel label_1 = new JLabel("\u5C06\u4F4D\u7F6E\u4E3A");
		label_1.setBounds(14, 76, 105, 38);
		panel.add(label_1);
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel label_2 = new JLabel("\u67E5\u8BE2");
		label_2.setBounds(14, 132, 53, 38);
		panel.add(label_2);
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));

		indexElem = new JTextField();
		indexElem.setBounds(53, 136, 66, 32);
		panel.add(indexElem);
		indexElem.setHorizontalAlignment(SwingConstants.CENTER);
		indexElem.setText("\u5143\u7D20");
		indexElem.setColumns(10);

		JLabel label_5 = new JLabel("\u7B2C\u4E00\u6B21\u51FA\u73B0\u7684\u4F4D\u7F6E");
		label_5.setBounds(122, 132, 147, 38);
		panel.add(label_5);
		label_5.setFont(new Font("宋体", Font.PLAIN, 17));

		JButton button_6 = new JButton("\u67E5\u8BE2");
		button_6.setEnabled(false);
		button_6.setBounds(281, 133, 115, 36);
		panel.add(button_6);
		button_6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Object elem = indexElem.getText();
				int index = list.indexOf(elem);
				displayArea.setText("元素 " + elem + " 第一次出现的位置为 " + index + ".");
			}
		});
		button_6.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel label_6 = new JLabel("\u53D6\u51FA\u4F4D\u7F6E\u4E3A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 17));
		label_6.setBounds(14, 183, 105, 38);
		panel.add(label_6);

		getFiled = new JTextField();
		getFiled.setText("\u4F4D\u7F6E");
		getFiled.setHorizontalAlignment(SwingConstants.CENTER);
		getFiled.setColumns(10);
		getFiled.setBounds(107, 181, 53, 32);
		panel.add(getFiled);

		JLabel label_7 = new JLabel("\u7684\u5143\u7D20");
		label_7.setFont(new Font("宋体", Font.PLAIN, 17));
		label_7.setBounds(163, 183, 105, 38);
		panel.add(label_7);

		JButton button_7 = new JButton("\u53D6\u51FA");
		button_7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int index = Integer.parseInt(getFiled.getText());
				Object ob = list.get(index);
				displayArea.setText("取出元素 " + String.valueOf(ob));
			}
		});
		button_7.setFont(new Font("宋体", Font.PLAIN, 17));
		button_7.setEnabled(false);
		button_7.setBounds(281, 182, 115, 36);
		panel.add(button_7);

		JButton butDisplay = new JButton("\u8F93\u51FA");
		butDisplay.setEnabled(false);
		butDisplay.setBounds(143, 226, 105, 133);
		panel_1.add(butDisplay);
		butDisplay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String str = list.display();
				displayArea.setText("当前顺序表: " + str);
			}
		});
		butDisplay.setFont(new Font("宋体", Font.PLAIN, 17));

		JButton button_1 = new JButton("\u7F6E\u7A7A");
		button_1.setEnabled(false);
		button_1.setBounds(14, 226, 115, 36);
		panel_1.add(button_1);
		button_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				list.clear();
				displayArea.setText("已将当前顺序表清空.");
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 17));

		JButton button_2 = new JButton("\u5224\u7A7A");
		button_2.setEnabled(false);
		button_2.setBounds(14, 275, 115, 36);
		panel_1.add(button_2);
		button_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean flag = list.isEmpty();
				if (flag == true)
					displayArea.setText("当前顺序表为空.");
				else
					displayArea.setText("当前顺序表非空.");
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 17));

		JButton button_3 = new JButton("\u957F\u5EA6");
		button_3.setEnabled(false);
		button_3.setBounds(14, 323, 115, 36);
		panel_1.add(button_3);
		button_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String length = Integer.toString(list.length());
				displayArea.setText("当前顺序表的长度为 " + length + ".");
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 17));

		JButton button = new JButton("\u521B\u5EFA");
		button.setFont(new Font("宋体", Font.PLAIN, 17));
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int maxSize = Integer.parseInt(creField.getText());
				if (maxSize < 0)
					displayArea.setText("顺序表大小必须大于0！");
				else
				{
					list = new SeqList(maxSize);
					displayArea.setText("已创建大小为 " + maxSize + " 的顺序表.");
					button_1.setEnabled(true);
					button_2.setEnabled(true);
					button_3.setEnabled(true);
					button_4.setEnabled(true);
					button_5.setEnabled(true);
					button_6.setEnabled(true);
					button_7.setEnabled(true);
					butDisplay.setEnabled(true);
				}
			}
		});
		button.setBounds(298, 29, 115, 36);
		frame.getContentPane().add(button);
	}
}
