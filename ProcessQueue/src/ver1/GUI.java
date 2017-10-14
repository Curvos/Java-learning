package ver1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI
{

	private JFrame frmPriorityQueue;

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
					window.frmPriorityQueue.setVisible(true);
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
		frmPriorityQueue = new JFrame();
		frmPriorityQueue.setTitle("Priority Queue");
		frmPriorityQueue.setBounds(100, 100, 600, 457);
		frmPriorityQueue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPriorityQueue.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Microsoft YaHei", Font.PLAIN, 22));
		textArea.setBounds(81, 62, 436, 241);
		frmPriorityQueue.getContentPane().add(textArea);

		JButton butt = new JButton("Run");
		butt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				PriorityQueue pm = new PriorityQueue();
				pm.offer(new PriorityQData(1, 30));
				pm.offer(new PriorityQData(2, 40));
				pm.offer(new PriorityQData(3, 10));
				pm.offer(new PriorityQData(4, 20));
				pm.offer(new PriorityQData(5, 40));
				pm.offer(new PriorityQData(6, 0));
				textArea.setText(pm.display());
			}
		});
		butt.setBounds(198, 316, 198, 37);
		frmPriorityQueue.getContentPane().add(butt);



	}
}
