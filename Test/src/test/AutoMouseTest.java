package test;

import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

public class AutoMouseTest
{
	public static void main(String[] args) throws Exception
	{
		moveAndClick(new Win());
	}

	private static void moveAndClick(final Win win) throws Exception
	{
		final Robot r = new Robot();
		new Thread()
		{
			public void run()
			{
				int w = Toolkit.getDefaultToolkit().getScreenSize().width;
				int h = Toolkit.getDefaultToolkit().getScreenSize().height;
				while (!win.stop)
				{
					// ������� x,y ����
					int x = (int) (Math.random() * w);
					int y = (int) (Math.random() * h);
					// ����ƶ��� x,y
					r.mouseMove(x, y);
					// Ϊ�˲��ҵ���꣬����������ֻ�е���굽��ɫ�� WIN �ϲŵ����
					if (win.win.getBounds().contains(x, y))
					{
						// �������
						r.mousePress(MouseEvent.BUTTON1_MASK);
						// �ͷ����
						r.mouseRelease(MouseEvent.BUTTON1_MASK);
					}
					String info = "<html>x:" + x + "<br/>y:" + y;
					// ��ʾ��굱ǰ�������Ϣ
					win.setInfo(info);
					try
					{
						sleep(50);
					} catch (Exception e)
					{
					}
				}
			}
		}.start();
	}
}

class Win
{
	JWindow win = new JWindow();
	JLabel info = new JLabel();
	boolean stop;

	public void setInfo(String s)
	{
		info.setText(s);
	}

	Win()
	{
		info.setOpaque(true);
		info.setBackground(Color.red);
		info.setHorizontalAlignment(JLabel.CENTER);
		win.setSize(80, 50);
		win.setAlwaysOnTop(true);
		win.add(info);
		win.setLocationRelativeTo(null);
		win.setVisible(true);
		win.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				stop = true;
				win.setVisible(false);
				JOptionPane.showMessageDialog(win, "������ƶ�����WIN���棬�������һ�£������˳���");
				System.exit(0);
			}
		});
		win.setVisible(true);
	}
}