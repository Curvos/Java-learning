package examples;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyKeyHandle extends JFrame implements KeyListener
{
	private JTextArea text = new JTextArea();

	public MyKeyHandle()
	{
		super.setTitle("Hello World!");
		JScrollPane scr = new JScrollPane(text);
		scr.setBounds(5, 5, 300, 200);

	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}

public class Eg_18_31
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
