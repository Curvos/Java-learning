package ver2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GUI
{

	private JFrame frame;
	private BiTree bTree;

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
		frame.setResizable(false);
		frame.setTitle("二叉树遍历");
		frame.setBounds(100, 100, 498, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setRows(1);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 22));
		textArea.setBounds(42, 210, 409, 62);
		textArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 2, false));
		frame.getContentPane().add(textArea);

		JButton btnNewButton = new JButton("层次遍历");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{				
				String str;
				str = bTree.levelTraverse();
				textArea.setText("层次遍历序列为: " + str);
			}
		});
		btnNewButton.setBounds(42, 285, 94, 49);
		frame.getContentPane().add(btnNewButton);
		
		JButton in = new JButton("递归中序");
		in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				bTree.str.setLength(0);
				str = bTree.inRootTraverse(bTree.getRoot());
				textArea.setText("递归中序遍历序列为: " + str);
			}
		});
		in.setEnabled(false);
		in.setBounds(255, 285, 93, 49);
		frame.getContentPane().add(in);
		
		JButton post = new JButton("递归后序");
		post.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				bTree.str.setLength(0);
				str = bTree.postRootTraverse(bTree.getRoot());
				textArea.setText("递归后序遍历序列为: " + str);
			}
		});
		post.setEnabled(false);
		post.setBounds(358, 285, 93, 49);
		frame.getContentPane().add(post);
		
		JButton pre = new JButton("递归先序");
		pre.setEnabled(false);
		pre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				bTree.str.setLength(0);
				str = bTree.preRootTraverse(bTree.getRoot());
				textArea.setText("递归先序遍历序列为: " + str);
			}
		});
		pre.setBounds(150, 285, 93, 49);
		frame.getContentPane().add(pre);
		
		JButton npre = new JButton("非递先序");
		npre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				bTree.str.setLength(0);
				str = bTree.preRootTraverse();				
				textArea.setText("非递归先序遍历序列为: " + str);
			}
		});
		npre.setEnabled(false);
		npre.setBounds(150, 341, 93, 49);
		frame.getContentPane().add(npre);
		
		JButton nin = new JButton("非中先序");
		nin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				bTree.str.setLength(0);
				str = bTree.inRootTraverse();				
				textArea.setText("非递归中序遍历序列为: " + str);
			}
		});
		nin.setEnabled(false);
		nin.setBounds(255, 341, 93, 49);
		frame.getContentPane().add(nin);
		
		JButton npost = new JButton("非递后序");
		npost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				bTree.str.setLength(0);
				str = bTree.postRootTraverse();				
				textArea.setText("非递归后序遍历序列为: " + str);
			}
		});
		npost.setEnabled(false);
		npost.setBounds(358, 341, 93, 49);
		frame.getContentPane().add(npost);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnClear.setEnabled(false);
		btnClear.setBounds(42, 341, 93, 49);
		frame.getContentPane().add(btnClear);
		
		JLabel lblNewLabel = new JLabel("先序序列：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 53, 105, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("中序序列：");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(31, 114, 105, 28);
		frame.getContentPane().add(label);
		
		JTextArea textA_1 = new JTextArea();
		textA_1.setText("ABDEGCFH");
		textA_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		textA_1.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 2, false));
		textA_1.setBounds(127, 51, 221, 37);
		frame.getContentPane().add(textA_1);
		
		JTextArea textA_2 = new JTextArea();
		textA_2.setText("DBGEAFHC");
		textA_2.setFont(new Font("Monospaced", Font.PLAIN, 17));
		textA_2.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 2, false));
		textA_2.setBounds(127, 109, 221, 37);
		frame.getContentPane().add(textA_2);
		
		JButton btnNewButton_1 = new JButton("Build");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String preOrder = textA_1.getText();
				String inOrder = textA_2.getText();
				bTree = new BiTree(preOrder, inOrder,0,0,preOrder.length());
				btnNewButton.setEnabled(true);
				btnClear.setEnabled(true);
				pre.setEnabled(true);
				npre.setEnabled(true);
				in.setEnabled(true);
				nin.setEnabled(true);
				post.setEnabled(true);
				npost.setEnabled(true);
				textArea.setText("Success!");
			}
		});
		btnNewButton_1.setBounds(358, 51, 101, 93);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
	}

	public BiTree createBiTree()
	{
		BiTreeNode d = new BiTreeNode('D');
		BiTreeNode g = new BiTreeNode('G');
		BiTreeNode h = new BiTreeNode('H');
		BiTreeNode e = new BiTreeNode('E', g, null);
		BiTreeNode b = new BiTreeNode('B', d, e);
		BiTreeNode f = new BiTreeNode('F', null, h);
		BiTreeNode c = new BiTreeNode('C', f, null);
		BiTreeNode a = new BiTreeNode('A', b, c);
		return new BiTree(a);
	}
}
