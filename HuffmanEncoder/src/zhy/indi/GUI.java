package zhy.indi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUI
{

	private JFrame frame;
	public static int[][] HN;
	public static HuffmanTree T;

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
		frame.setTitle("哈夫曼编码");
		frame.setBounds(100, 100, 551, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea input = new JTextArea();
		input.setEnabled(false);
		input.setFont(new Font("Monospaced", Font.PLAIN, 15));
		input.setLineWrap(true);
		input.setBounds(65, 77, 426, 160);
		frame.getContentPane().add(input);

		JTextArea output = new JTextArea();
		output.setEnabled(false);
		output.setFont(new Font("Monospaced", Font.PLAIN, 15));
		output.setLineWrap(true);
		output.setBounds(65, 291, 426, 160);
		frame.getContentPane().add(output);

		JButton encode = new JButton("Encode");
		encode.setEnabled(false);
		encode.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				HuffmanEncoder en = new HuffmanEncoder();
				String str = en.encode(input.getText());
				output.setText(str);
				input.setText("");
			}
		});
		encode.setBounds(221, 477, 113, 27);
		frame.getContentPane().add(encode);

		JButton decode = new JButton("Decode");
		decode.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				HuffmanDecoder de = new HuffmanDecoder();
				String str = de.decode(output.getText());
				input.setText(str);
				output.setText("");
			}
		});
		decode.setEnabled(false);
		decode.setBounds(367, 477, 113, 27);
		frame.getContentPane().add(decode);

		JLabel label = new JLabel("原字符串");
		label.setBounds(69, 23, 418, 55);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("编码输出");
		label_1.setBounds(65, 261, 72, 18);
		frame.getContentPane().add(label_1);

		JButton btnNewButton = new JButton("Build");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				input.setEnabled(true);
				output.setEnabled(true);
				encode.setEnabled(true);
				decode.setEnabled(true);
				@SuppressWarnings("unused")
				RandomAscii rand = new RandomAscii();
				int[] dict = RandomAscii.dict;
				T = new HuffmanTree();
				HN = T.huffmanCoding(dict);
				// System.out.println("root " + T.root.weight + " " +
				// T.root.isLeaf());
				// System.out.println("HUffman Code：");

				label.setText("Huffman Tree建立成功，请在此处输入需要加密的字符串");
			}
		});
		btnNewButton.setBounds(65, 477, 113, 27);
		frame.getContentPane().add(btnNewButton);

	}
}
