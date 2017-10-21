package examples;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Eg_18_16
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("测试软件");
		Container cont = frame.getContentPane();
		JTabbedPane tab = null;
		tab = new JTabbedPane(JTabbedPane.TOP);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JButton but = new JButton("按钮");
		JLabel lab = new JLabel("标签");
		pan1.add(but);
		pan2.add(lab);
		tab.add("图片选项", pan1);
		tab.add("文字选项", pan2);
		cont.add(tab);
		frame.setSize(800, 1200);
		frame.setLocation(300, 200);
		frame.setVisible(true);
	}

}
