package zhy.indi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI
{

	private JFrame frame;

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
		frame.setTitle("二叉树层次遍历");
		frame.setBounds(100, 100, 498, 287);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 23));
		textArea.setBounds(53, 57, 380, 62);
		frame.getContentPane().add(textArea);

		JButton btnNewButton = new JButton("层次遍历");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{

				BiTree biTree = createBiTree();
				String str;
				str = biTree.levelTraverse();
				textArea.setText("层次遍历序列为: " + str);
			}
		});
		btnNewButton.setBounds(53, 132, 380, 49);
		frame.getContentPane().add(btnNewButton);
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
