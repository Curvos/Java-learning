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
					// 随机产生 x,y 坐标
					int x = (int) (Math.random() * w);
					int y = (int) (Math.random() * h);
					// 鼠标移动到 x,y
					r.mouseMove(x, y);
					// 为了不乱点鼠标，设置条件：只有当鼠标到红色的 WIN 上才点击！
					if (win.win.getBounds().contains(x, y))
					{
						// 按下鼠标
						r.mousePress(MouseEvent.BUTTON1_MASK);
						// 释放鼠标
						r.mouseRelease(MouseEvent.BUTTON1_MASK);
					}
					String info = "<html>x:" + x + "<br/>y:" + y;
					// 显示鼠标当前坐标的信息
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
				JOptionPane.showMessageDialog(win, "鼠标已移动到了WIN上面，并点击了一下，程序将退出！");
				System.exit(0);
			}
		});
		win.setVisible(true);
	}
}