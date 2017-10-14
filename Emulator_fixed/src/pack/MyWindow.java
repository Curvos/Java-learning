package pack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MyWindow
{

	private JFrame frmFrame;
	// private Point A = new Point();
	// private Point S = new Point();
	// private Point D = new Point();
	public static JTextField hourText;
	public static JTextField minuteText;
	public static JTextField secondText;
	public static JLabel textCustom = new JLabel("x1,y1");
	public static JLabel textRaise = new JLabel("x2,y2");
	public static JLabel textConfirm = new JLabel("x3,y3");

	private boolean location_flag = false;
	// public static Submit sub = new Submit();
	private Timer.TimeThread myThread;
	// 此处若仅写为“public static JLabel textConfirm”会出现空指针错误，why？？？
	private Timer timer = new Timer();
	public static JTextField nameField;
	private JPasswordField passwordField;
	private Connection conn;
	private Object[][] objs = null;
	private JTable table = null;
	private DefaultTableModel tableModel = new DefaultTableModel();
	public static JTextPane queryPane;
	// private boolean DatabaseStatus = false;
	private JButton run;
	private JLabel lblsql;
	private JButton reset;
	private JButton select;
	private JCheckBox chckbx_table;
	private JCheckBox check_import;
	private JCheckBox checkBox_export;
	private Coordinate coor = new Coordinate();

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
					MyWindow window = new MyWindow();
					window.frmFrame.setVisible(true);
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
	public MyWindow()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{

		// myThread.start();
		// myThread.interrupt();

		frmFrame = new JFrame();
		frmFrame.setAlwaysOnTop(true);
		frmFrame.setResizable(false);
		frmFrame.setTitle("\u8F85\u52A9\u8F6F\u4EF6");
		frmFrame.setBounds(100, 100, 860, 540);
		frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		tabbedPane.setBounds(0, 0, 854, 483);
		frmFrame.getContentPane().add(tabbedPane);

		JPanel basicTab = new JPanel();
		tabbedPane.addTab("\u4F7F\u7528\u8BF4\u660E", null, basicTab, null);
		basicTab.setLayout(null);

		JTextArea txtrhttpmonihupaiorg = new JTextArea();
		txtrhttpmonihupaiorg.setEditable(false);
		txtrhttpmonihupaiorg.setText(
				"\u529F\u80FD\u4E00\uFF1A\u62CD\u724C\u81EA\u52A8\u51FA\u4EF7\u3001\u63D0\u4EA4\r\n\t1.\u9002\u7528\u7F51\u7AD9\uFF1Ahttp://moni.51hupai.org/\u3002\r\n\t2.\u6253\u5F00\u5E76\u52A0\u8F7D\u7F51\u7AD9\u5B8C\u5B8C\u6BD5\u540E\uFF0C\u5728\u201C\u5750\u6807\u5B9A\u4F4D\u201D\u9009\u9879\u5361\u4E0B\u70B9\u51FB\u201C\u5F00\u59CB\u5B9A\u4F4D\u201D\uFF0C\r\n\t\u4E4B\u540E\u5C06\u9F20\u6807\u79FB\u52A8\u81F3\u76F8\u5E94\u4F4D\u7F6E\u65F6\u5206\u522B\u6309\u4E0B\u952E\u76D8\"A\"\"S\"\"D\"\u952E\u8FDB\u884C\u5BF9\u5E94\u5B9A\u4F4D\u3002\r\n\t3.\u70B9\u51FB\u8BE5\u8F6F\u4EF6\u201C\u65F6\u95F4\u8BBE\u7F6E\u201D\u9009\u9879\u5361\u4E0B\u7684\u201C\u5F00\u59CB\u8BA1\u65F6\u201D\u6309\u94AE\uFF0C\u4E4B\u540E\u624B\u52A8\u5BF9\u9F50\u7F51\r\n\t\u9875\u65F6\u95F4\uFF0C\u6B64\u540E\u8BF7\u4FDD\u6301\u7F51\u9875\u65E0\u906E\u6321\uFF0C\u4E0D\u5BF9\u7535\u8111\u8FDB\u884C\u64CD\u4F5C\u3002\r\n\t4.\u572811:29:48\u65F6\u8F6F\u4EF6\u81EA\u52A8\u5B8C\u6210\u201C\u52A0\u4EF7700\u201D\u7684\u64CD\u4F5C\uFF0C\u572811:29:55\u65F6\u81EA\u52A8\u51FA\u4EF7\u3002\r\n\r\n\u529F\u80FD\u4E8C\uFF1A\u6570\u636E\u5E93\u67E5\u8BE2\u53CA\u66F4\u65B0\u64CD\u4F5C\r\n\t\u91CD\u8981\uFF01\u9ED8\u8BA4\u94FE\u63A5mysql\u7684\u8D26\u6237\u53CA\u5BC6\u7801\u5747\u4E3A\u201Croot\u201D\uFF0C\u82E5\u672C\u5730\u914D\u7F6E\u4E0D\u540C\u53EF\u4E8EDataBase\r\n\t\u7C7B\u4E0B\u4FEE\u6539\uFF1B\u9ED8\u8BA4\u94FE\u63A5\u6570\u636E\u5E93\u201Cbio2015\u201D\uFF0C\u82E5\u672C\u5730\u65E0\u8BE5\u540D\u79F0\u6570\u636E\u5E93\u8BF7\u63D0\u524D\u521B\u5EFA\u3002\r\n\t1.\u5728\u201C\u6570\u636E\u67E5\u8BE2\u201D\u9009\u9879\u5361\u4E0B\u767B\u9646\u6570\u636E\u5E93\uFF0C\u7528\u6237\u540D\u548C\u5BC6\u7801\u5747\u4E3Aroot(\u56E0\u672C\u5730\u914D\u7F6E\u4E0D\u540C\r\n\t\u53EF\u80FD\u4F1A\u6709\u5DEE\u5F02)\u3002\r\n\t2.\u767B\u9646\u540E\u5206\u522B\u70B9\u51FB\u201C\u5BFC\u5165\u8868\u7ED3\u6784\u201C\u4EE5\u53CA\u201D\u4ECE\u6587\u672C\u5BFC\u5165\u8868\u201C\u6309\u94AE\uFF0C\u5373\u53EF\u5BFC\u5165\u9884\u521B\u5EFA\u597D\u7684\uFF0C\t   \t\u542B5\u6761\u8BB0\u5F55\u3002\u70B9\u51FB\u201C\u67E5\u8BE2\u6240\u6709\u6570\u636E\u201D\u6309\u94AE\u540E\u5373\u53EF\u8F93\u51FA\u8868\u4E0B\u7684\u6240\u6709\u8BB0\u5F55\u3002\r\n\t3.\u5728\u201C\u6570\u636E\u7BA1\u7406\u201D\u9009\u9879\u5361\u4E0B\u53EF\u6267\u884CSQL\u8BED\u53E5\u5BF9\u6570\u636E\u5E93\u8FDB\u884C\u64CD\u4F5C\uFF0C\u201C\u6267\u884C\u67E5\u8BE2\u201D\r\n\t\u548C\u201C\u6267\u884C\u7EF4\u62A4\u201D\u5206\u522B\u652F\u6301SQL\u7684SELECT\u8BED\u6CD5\u548CUPDATE\u8BED\u6CD5\uFF08\u6267\u884C\u540E\u8BF7\u5207\r\n\t\u6362\u81F3\u201C\u6570\u636E\u67E5\u8BE2\u201D\u9009\u9879\u5361\u8FDB\u884C\u786E\u8BA4\uFF09\u3002\r\n\t4.\u201C\u6D4B\u8BD5\u8BED\u53E5\u201D\u9009\u9879\u5361\u4E0B\u63D0\u4F9B\u4E86\u76F8\u5173SQL\u8BED\u53E5\u4EE5\u4F9B\u529F\u80FD\u6D4B\u8BD5\u3002\r\n\r\n\t\t\t            \u59D3\u540D\uFF1A\u7AE0\u7693\u5B87    \u5B66\u53F7\uFF1A1530416012\t");
		txtrhttpmonihupaiorg.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		txtrhttpmonihupaiorg.setBounds(113, 17, 674, 418);
		basicTab.add(txtrhttpmonihupaiorg);

		JPanel corTab = new JPanel();
		tabbedPane.addTab("\u5750\u6807\u5B9A\u4F4D", null, corTab, null);
		corTab.setLayout(null);

		JLabel label = new JLabel("<\u81EA\u5B9A\u4E49\u52A0\u4EF7\u5E45\u5EA6>\u6587\u672C\u6846\u5B9A\u4F4D");
		label.setFont(new Font("宋体", Font.PLAIN, 28));
		label.setBounds(65, 118, 376, 29);
		corTab.add(label);

		JLabel lblNewLabel = new JLabel("<\u52A0\u4EF7>\u6309\u94AE\u5B9A\u4F4D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		lblNewLabel.setBounds(65, 168, 201, 29);
		corTab.add(lblNewLabel);

		// JLabel textCustom = new JLabel("x1,y1");
		textCustom.setHorizontalAlignment(SwingConstants.CENTER);
		textCustom.setFont(new Font("黑体", Font.ITALIC, 21));
		textCustom.setBounds(503, 120, 151, 29);
		corTab.add(textCustom);

		// JLabel textRaise = new JLabel("x2,y2");
		textRaise.setHorizontalAlignment(SwingConstants.CENTER);
		textRaise.setFont(new Font("黑体", Font.ITALIC, 21));
		textRaise.setBounds(491, 168, 163, 29);
		corTab.add(textRaise);

		// JLabel textConfirm = new JLabel("x3,y3");
		textConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		textConfirm.setFont(new Font("黑体", Font.ITALIC, 21));
		textConfirm.setBounds(491, 215, 163, 38);
		corTab.add(textConfirm);

		JLabel label_1 = new JLabel("<\u51FA\u4EF7>\u6309\u94AE\u5B9A\u4F4D");
		label_1.setFont(new Font("宋体", Font.PLAIN, 28));
		label_1.setBounds(65, 218, 201, 29);
		corTab.add(label_1);

		JButton Location = new JButton("\u5F00\u59CB\u5B9A\u4F4D");
		Location.setFont(new Font("幼圆", Font.BOLD, 16));
		Location.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == Location)
				{

					if (location_flag == false)
					{
						Location.setText("结束定位");
						location_flag = true;
						textCustom.setEnabled(true);
						textRaise.setEnabled(true);
						textConfirm.setEnabled(true);

						// 此处的键盘监听适配器语法需要再加以理解
						Location.addKeyListener(new KeyAdapter()
						{
							public void keyPressed(KeyEvent e)
							{
								if (location_flag == true)
									coor.setLocation(e.getKeyChar());
								// switch (e.getKeyChar())
								// {
								// case 'A':
								// A = MouseInfo.getPointerInfo().getLocation();
								// textCustom.setText(String.valueOf(A.getX()) +
								// "," +
								// String.valueOf(A.getY()));
								// break;
								// case 'a':
								// A = MouseInfo.getPointerInfo().getLocation();
								// textCustom.setText(String.valueOf(A.getX()) +
								// "," +
								// String.valueOf(A.getY()));
								// break;
								// case 'S':
								// S = MouseInfo.getPointerInfo().getLocation();
								// textRaise.setText(String.valueOf(S.getX()) +
								// "," +
								// String.valueOf(S.getY()));
								// break;
								// case 's':
								// S = MouseInfo.getPointerInfo().getLocation();
								// textRaise.setText(String.valueOf(S.getX()) +
								// "," +
								// String.valueOf(S.getY()));
								// break;
								// case 'D':
								// D = MouseInfo.getPointerInfo().getLocation();
								// textConfirm.setText(String.valueOf(D.getX())
								// + "," +
								// String.valueOf(D.getY()));
								// break;
								// case 'd':
								// D = MouseInfo.getPointerInfo().getLocation();
								// textConfirm.setText(String.valueOf(D.getX())
								// + "," +
								// String.valueOf(D.getY()));
								// break;
								// }
							}
						});
					} /*
						 * else// 无效，监视器未停止，待优化 { Location.setText("开始定位");
						 * textCustom.setEnabled(false);
						 * textRaise.setEnabled(false);
						 * textConfirm.setEnabled(false); }
						 */
					else if (location_flag == true)
					{
						Location.setText("开始定位");
						location_flag = false;
						textCustom.setEnabled(false);
						textRaise.setEnabled(false);
						textConfirm.setEnabled(false);
					}

				}

			}
		});
		Location.setBounds(503, 265, 153, 37);
		corTab.add(Location);

		JLabel lbla = new JLabel("\u5FEB\u6377\u952E:A");
		lbla.setFont(new Font("微软雅黑", Font.ITALIC, 24));
		lbla.setBounds(653, 118, 122, 29);
		corTab.add(lbla);

		JLabel lbls = new JLabel("\u5FEB\u6377\u952E:S");
		lbls.setFont(new Font("微软雅黑", Font.ITALIC, 24));
		lbls.setBounds(650, 168, 122, 29);
		corTab.add(lbls);

		JLabel lbld = new JLabel("\u5FEB\u6377\u952E:D");
		lbld.setFont(new Font("微软雅黑", Font.ITALIC, 24));
		lbld.setBounds(650, 216, 122, 29);
		corTab.add(lbld);

		JPanel timeTab = new JPanel();
		tabbedPane.addTab("\u65F6\u95F4\u8BBE\u7F6E", null, timeTab, null);
		timeTab.setLayout(null);

		JLabel label_2 = new JLabel("\u5BF9\u9F50\u7F51\u9875\u65F6\u95F4\uFF1A");
		label_2.setBounds(93, 70, 196, 32);
		label_2.setFont(new Font("宋体", Font.PLAIN, 28));
		timeTab.add(label_2);

		JLabel label_3 = new JLabel("\u5206");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(249, 133, 28, 27);
		timeTab.add(label_3);

		JLabel label_4 = new JLabel("\u65F6");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(156, 131, 28, 31);
		timeTab.add(label_4);

		JLabel label_5 = new JLabel("\u79D2");
		label_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		label_5.setBounds(343, 136, 55, 18);
		timeTab.add(label_5);

		JButton H_up = new JButton("+");
		H_up.setForeground(Color.BLUE);
		H_up.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == H_up)
				{
					timer.Hour_increase();
					// hourText.setText(timer.getHour());
				}
			}
		});
		H_up.setFont(new Font("黑体", Font.PLAIN, 22));
		H_up.setBounds(93, 170, 62, 32);
		timeTab.add(H_up);

		JButton H_down = new JButton("-");
		H_down.setForeground(Color.RED);
		H_down.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == H_down)
				{
					timer.Hour_decrease();
					// hourText.setText(timer.getHour());
				}
			}
		});
		H_down.setFont(new Font("黑体", Font.PLAIN, 22));
		H_down.setBounds(93, 200, 62, 32);
		timeTab.add(H_down);

		JButton M_up = new JButton("+");
		M_up.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == M_up)
				{
					timer.Minute_increase();
					// minuteText.setText(timer.getMinute());
				}
			}
		});
		M_up.setForeground(Color.BLUE);
		M_up.setFont(new Font("黑体", Font.PLAIN, 22));
		M_up.setBounds(186, 170, 62, 32);
		timeTab.add(M_up);

		JButton M_down = new JButton("-");
		M_down.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == M_down)
				{
					timer.Minute_decrease();
					// minuteText.setText(timer.getMinute());
				}
			}
		});
		M_down.setForeground(Color.RED);
		M_down.setFont(new Font("黑体", Font.PLAIN, 22));
		M_down.setBounds(186, 200, 62, 32);
		timeTab.add(M_down);

		JButton S_up = new JButton("+");
		S_up.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == S_up)
				{
					timer.Second_increase();
					// secondText.setText(timer.getSecond());
				}
			}
		});
		S_up.setForeground(Color.BLUE);
		S_up.setFont(new Font("黑体", Font.PLAIN, 22));
		S_up.setBounds(279, 170, 62, 32);
		timeTab.add(S_up);

		JButton S_down = new JButton("-");
		S_down.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == S_down)
				{
					timer.Second_decrease();
					// secondText.setText(timer.getSecond());
				}
			}
		});
		S_down.setForeground(Color.RED);
		S_down.setFont(new Font("黑体", Font.PLAIN, 22));
		S_down.setBounds(279, 200, 62, 32);
		timeTab.add(S_down);

		hourText = new JTextField();
		hourText.setText("11");
		hourText.setFont(new Font("SansSerif", Font.PLAIN, 20));
		hourText.setBounds(93, 128, 62, 41);
		timeTab.add(hourText);
		hourText.setColumns(10);

		minuteText = new JTextField();
		minuteText.setText("29");
		minuteText.setFont(new Font("SansSerif", Font.PLAIN, 20));
		minuteText.setColumns(10);
		minuteText.setBounds(186, 128, 62, 41);
		timeTab.add(minuteText);

		secondText = new JTextField();
		secondText.setText("0");
		secondText.setFont(new Font("SansSerif", Font.PLAIN, 20));
		secondText.setColumns(10);
		secondText.setBounds(279, 128, 62, 41);
		timeTab.add(secondText);

		JButton startTimer = new JButton("\u5F00\u59CB\u8BA1\u65F6");
		startTimer.setFont(new Font("黑体", Font.PLAIN, 24));

		startTimer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == startTimer)
				{
					myThread = timer.new TimeThread();
					myThread.start();
					startTimer.setEnabled(false);
				}
			}
		});
		startTimer.setBounds(402, 117, 160, 52);
		timeTab.add(startTimer);

		JButton reSet = new JButton("\u6682\u505C");
		reSet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (reSet.getText().equals("暂停"))
				{
					timer.setFlag(false);
					reSet.setText("继续");
				} else
				{
					timer.setFlag(true);
					reSet.setText("暂停");
					myThread = timer.new TimeThread();
					myThread.start();
				}
			}
		});
		reSet.setFont(new Font("黑体", Font.PLAIN, 24));
		reSet.setBounds(402, 181, 160, 52);
		timeTab.add(reSet);

		JPanel database = new JPanel();
		tabbedPane.addTab("\u6570\u636E\u67E5\u8BE2", null, database, null);
		database.setLayout(null);

		JLabel UserName = new JLabel("\u7528\u6237\u540D");
		UserName.setFont(new Font("宋体", Font.PLAIN, 28));
		UserName.setBounds(38, 98, 84, 29);
		database.add(UserName);

		JLabel PassWord = new JLabel("\u5BC6 \u7801");
		PassWord.setFont(new Font("宋体", Font.PLAIN, 28));
		PassWord.setBounds(38, 157, 84, 29);
		database.add(PassWord);

		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setText("\u8BF7\u8F93\u5165\u767B\u9646\u4FE1\u606F");
		nameField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		nameField.setColumns(10);
		nameField.setBounds(134, 95, 185, 41);
		database.add(nameField);

		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (Login.Log(nameField.getText(), String.valueOf(passwordField.getPassword())) == true)
				{
					nameField.setText("登陆成功！");
					conn = DataBase.getDataBaseConnection();
					setEnabled();
				} else
				{
					nameField.setText("用户名或密码错误！");
				}
			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 16));
		button.setBounds(134, 218, 141, 37);
		database.add(button);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(134, 148, 185, 41);
		database.add(passwordField);

		JButton Select_button = new JButton("\u67E5\u8BE2\u6240\u6709\u6570\u636E");
		Select_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				try
				{
					objs = DataBase.selectAll(conn);
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// for (int i = 0; i < objs.length; i++)
				// for (int j = 0; j < objs[0].length; j++)
				// System.out.println(objs[i][j]);

				Object[] temp = new Object[DataBase.columns];
				tableModel.setRowCount(0);
				for (int i = 0; i < DataBase.rows; i++) // 需要完善
														// 也许迭代求出行数即可
				{
					for (int j = 0; j < DataBase.columns; j++)
					{
						temp[j] = objs[i][j];
						// System.out.println(temp[j]);
					}
					tableModel.addRow(temp);
				}

			}
		});
		Select_button.setFont(new Font("幼圆", Font.BOLD, 16));
		Select_button.setBounds(134, 267, 141, 37);
		database.add(Select_button);

		String[] titles = { "标书号码", "密码", "身份证号码", "姓名", "标书使用次数", "标书有效期限" };
		Object[][] use = {};
		tableModel = new DefaultTableModel(use, titles);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 50, 513, 296);
		database.add(scrollPane);
		table = new JTable(tableModel);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JButton createTable = new JButton("\u5BFC\u5165\u8868\u7ED3\u6784");
		createTable.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					DataBase.CreateTable();
					chckbx_table.setSelected(true);

				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		createTable.setFont(new Font("幼圆", Font.BOLD, 16));
		createTable.setBounds(357, 358, 141, 37);
		database.add(createTable);

		JButton button_1 = new JButton("\u4ECE\u6587\u672C\u5BFC\u5165\u8868");
		button_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					try
					{
						DataBase.Import();
						check_import.setSelected(true);
					} catch (FileNotFoundException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("幼圆", Font.BOLD, 16));
		button_1.setBounds(524, 358, 141, 37);
		database.add(button_1);

		JButton button_2 = new JButton("\u5BFC\u51FA\u8868\u5230\u6587\u672C");
		button_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					DataBase.Export();
					checkBox_export.setSelected(true);
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_2.setFont(new Font("幼圆", Font.BOLD, 16));
		button_2.setBounds(690, 358, 141, 37);
		database.add(button_2);

		chckbx_table = new JCheckBox("");
		chckbx_table.setEnabled(false);
		chckbx_table.setBounds(496, 368, 18, 18);
		database.add(chckbx_table);

		check_import = new JCheckBox("");
		check_import.setEnabled(false);
		check_import.setBounds(662, 368, 18, 18);
		database.add(check_import);

		checkBox_export = new JCheckBox("");
		checkBox_export.setEnabled(false);
		checkBox_export.setBounds(830, 368, 18, 18);
		database.add(checkBox_export);

		JLabel lblNewLabel_1 = new JLabel("\u8FDB\u884C\u64CD\u4F5C\u524D\u8BF7\u5148\u767B\u9646\uFF01");
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 16));
		lblNewLabel_1.setBounds(38, 23, 170, 18);
		database.add(lblNewLabel_1);

		JPanel SQL = new JPanel();
		tabbedPane.addTab("\u6570\u636E\u7BA1\u7406", null, SQL, null);
		SQL.setLayout(null);

		lblsql = new JLabel("\u8BF7\u767B\u9646\u6570\u636E\u5E93");
		lblsql.setEnabled(false);
		lblsql.setHorizontalAlignment(SwingConstants.CENTER);
		lblsql.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblsql.setBounds(108, 98, 138, 46);
		SQL.add(lblsql);

		run = new JButton("\u6267\u884C\u7EF4\u62A4");
		run.setEnabled(false);
		run.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					DataBase.update(queryPane.getText());
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		run.setFont(new Font("幼圆", Font.BOLD, 16));
		run.setBounds(105, 196, 141, 37);
		SQL.add(run);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(349, 65, 412, 285);
		SQL.add(scrollPane_1);

		queryPane = new JTextPane();
		queryPane.setEnabled(false);
		scrollPane_1.setViewportView(queryPane);
		queryPane.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		reset = new JButton("\u6E05\u9664\u5185\u5BB9");
		reset.setEnabled(false);
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				queryPane.setText("");
			}
		});
		reset.setFont(new Font("幼圆", Font.BOLD, 16));
		reset.setBounds(105, 245, 141, 37);
		SQL.add(reset);

		select = new JButton("\u6267\u884C\u67E5\u8BE2");
		select.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					objs = DataBase.query(queryPane.getText());
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Object[] temp = new Object[DataBase.columns];
				tableModel.setRowCount(0);

				for (int i = 0; i < DataBase.rows; i++) // 需要完善
				// 也许迭代求出行数即可
				{
					for (int j = 0; j < DataBase.columns; j++)
					{
						temp[j] = objs[i][j];
						// System.out.println(temp[j]);
					}
					tableModel.addRow(temp);
				}

			}
		});
		select.setFont(new Font("幼圆", Font.BOLD, 16));
		select.setEnabled(false);
		select.setBounds(105, 145, 141, 37);
		SQL.add(select);

		JPanel panel = new JPanel();
		tabbedPane.addTab("\u6D4B\u8BD5\u8BED\u53E5", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(51, 65, 358, 299);
		panel.add(scrollPane_2);

		JTextArea txtrInsertIntoMytab = new JTextArea();
		txtrInsertIntoMytab.setText(
				"\u67E5\u8BE2\u6D4B\u8BD5\u8BED\u53E5\uFF1A\r\n\r\n*********************\u590D\u5236\u4EE5\u4E0B\u4EE3\u7801\u8FDB\u884C\u6D4B\u8BD5**********************\r\n\r\nSELECT * FROM table_1530416012\r\nWHERE doc_id=3;\r\n\r\n");
		scrollPane_2.setViewportView(txtrInsertIntoMytab);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(464, 65, 358, 299);
		panel.add(scrollPane_3);

		JTextArea txtrDeleteDeleteFrom = new JTextArea();
		txtrDeleteDeleteFrom.setText(
				"INSERT\u6D4B\u8BD5\u8BED\u53E5\uFF1A\r\n\r\n*********************\u590D\u5236\u4EE5\u4E0B\u4EE3\u7801\u8FDB\u884C\u6D4B\u8BD5**********************\r\n\r\nINSERT INTO table_1530416012\r\n(doc_id,password,id,name,doc_status,doc_endDate)\r\nVALUES(6,12345,431381198807124341,'\u5468\u516B',3,'2009-2-3');\r\n\r\n\r\nDELETE\u6D4B\u8BD5\u8BED\u53E5\uFF08\u8BF7\u5728\u6267\u884C\u5B8C\u4E0A\u8FF0\u4EE3\u7801\u540E\u4F7F\u7528\uFF09\uFF1A\r\n\r\n*********************\u590D\u5236\u4EE5\u4E0B\u4EE3\u7801\u8FDB\u884C\u6D4B\u8BD5**********************\r\n\r\nDELETE FROM table_1530416012\r\nWHERE doc_id=6;");
		scrollPane_3.setViewportView(txtrDeleteDeleteFrom);

	}

	private void setEnabled()
	{
		lblsql.setText("请输入SQL语句");
		run.setEnabled(true);
		lblsql.setEnabled(true);
		reset.setEnabled(true);
		queryPane.setEnabled(true);
		select.setEnabled(true);
	}
}
