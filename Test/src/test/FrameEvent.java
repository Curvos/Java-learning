package test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FrameEvent extends JFrame implements KeyListener
{
	JTextArea textarea = new JTextArea(10, 30);
	private JLabel status;

	public FrameEvent()
	{
		super("KeyinEvent.java: ");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setFocusable(true);
		textarea.setText("�밴�����:");
		c.add(textarea);
		addKeyListener(this);
		setSize(350, 300);
		show();
		this.setDefaultCloseOperation(3);
	}

	public void keyPressed(KeyEvent e)
	{
		// String line1="����:"+e.getKeyChar()+"\n";
		// String line2="a�����Ƿ�ΪAction��:"+e.isActionKey();
		// @SuppressWarnings("static-access")
		// String mKey=e.getKeyModifiersText(e.getModifiers());
		// String line3="�Ƿ���Modifier��"+(mKey.equals("")?"��":"��,���Ϊ"+mKey);
		// textarea.setText(line1+"\n"+line2+"\n"+line3+"\n");
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			System.out.println("123");
		}
		// char ch = e.getKeyChar();
		// status.setText(String.valueOf(ch) + " " +(int)ch);

	}

	public void keyReleased(KeyEvent e)
	{
	}

	public void keyTyped(KeyEvent e)
	{
	}

	public static void main(String args[])
	{
		FrameEvent app = new FrameEvent();
	}
}