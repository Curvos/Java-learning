package examples;

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
}

public class Eg_18_31
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
