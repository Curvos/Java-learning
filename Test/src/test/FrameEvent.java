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
		textarea.setText("请按任意键:");
		c.add(textarea);
		addKeyListener(this);
		setSize(350, 300);
		show();
		this.setDefaultCloseOperation(3);
	}

	public void keyPressed(KeyEvent e)
	{
		// String line1="按键:"+e.getKeyChar()+"\n";
		// String line2="a按键是否为Action键:"+e.isActionKey();
		// @SuppressWarnings("static-access")
		// String mKey=e.getKeyModifiersText(e.getModifiers());
		// String line3="是否按下Modifier键"+(mKey.equals("")?"否":"是,其键为"+mKey);
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