package indi.ver1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField inputPath;
	private JTextField outputPath;
	private JTextField resultContent;
	private JTextField key;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setTitle("\u6587\u6863\u52A0\u5BC6/\u89E3\u5BC6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputpath = new JLabel("InputPath:");
		lblInputpath.setFont(new Font("黑体", Font.PLAIN, 18));
		lblInputpath.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputpath.setBounds(61, 49, 108, 16);
		contentPane.add(lblInputpath);
		
		JLabel lblOutputpath = new JLabel("OutputPath:");
		lblOutputpath.setFont(new Font("黑体", Font.PLAIN, 18));
		lblOutputpath.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputpath.setBounds(61, 126, 108, 16);
		contentPane.add(lblOutputpath);
		
		JLabel lblResult = new JLabel("Message:");
		lblResult.setFont(new Font("黑体", Font.PLAIN, 18));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(61, 364, 93, 21);
		contentPane.add(lblResult);
		
		inputPath = new JTextField();
		inputPath.setFont(new Font("宋体", Font.PLAIN, 18));
		inputPath.setBounds(194, 34, 505, 47);
		contentPane.add(inputPath);
		inputPath.setColumns(10);
		
		outputPath = new JTextField();
		outputPath.setFont(new Font("宋体", Font.PLAIN, 18));
		outputPath.setColumns(10);
		outputPath.setBounds(194, 111, 505, 47);
		contentPane.add(outputPath);
		
		resultContent = new JTextField();
		resultContent.setEditable(false);
		resultContent.setFont(new Font("宋体", Font.PLAIN, 18));
		resultContent.setBounds(194, 349, 505, 47);
		contentPane.add(resultContent);
		resultContent.setColumns(10);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setFont(new Font("黑体", Font.PLAIN, 18));
		lblKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblKey.setBounds(80, 196, 61, 29);
		contentPane.add(lblKey);
		
		key = new JTextField();
		key.setFont(new Font("宋体", Font.PLAIN, 18));
		key.setColumns(10);
		key.setBounds(194, 189, 505, 47);
		contentPane.add(key);
		
		JButton btnNewButton = new JButton("Encrypt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputpath = inputPath.getText();
				String outputpath = outputPath.getText();
				int pwd = Integer.parseInt(key.getText());
				TextFileEncryption encryptor = new TextFileEncryption();
				try
				{
					encryptor.encryptFile(inputpath, outputpath, pwd);
					resultContent.setText("encryption succeed! please checkout your file.");
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// resultContent.setText(engine.encoder());
			}
		});
		btnNewButton.setBounds(194, 264, 250, 59);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decrypt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputpath = inputPath.getText();
				SeqString in1 = new SeqString(inputpath);
				String outputpath = outputPath.getText();
				SeqString out1 = new SeqString(outputpath);
				int pwd = Integer.parseInt(key.getText());
				TextFileEncryption decoder = new TextFileEncryption();
				try
				{
					decoder.decryptFile(in1, out1, pwd);
					resultContent.setText("decryption succeed! please checkout your file.");
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// resultContent.setText(engine.decoder());
			}
		});
		btnNewButton_1.setBounds(458, 264, 241, 59);
		contentPane.add(btnNewButton_1);
	}
}
