package pack;

import java.awt.AWTException;
import java.awt.Robot;//问题1：此处Eclipse补全没有Robot 需要解决。
//问题2：为什么创建Robot必须处理异常
import java.awt.event.InputEvent;

public class Submiter
{
	// private Robot rob;
	//
	// public Submiter()
	// {
	// try
	// {
	// Robot rob = new Robot();
	// } catch (AWTException e)
	// {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// 问题3 两个方法都需要调用Robot 应创建一个Private Robot 还是每个方法单独实例化Robot?
	public static void autoSubmit()
	{
		try
		{
			Robot rob = new Robot();
			rob.mouseMove(Coordinate.A.x, Coordinate.A.y);
			rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			rob.keyPress('7');
			rob.keyRelease('7');
			rob.keyPress('0');
			rob.keyRelease('0');
			rob.keyPress('0');
			rob.keyRelease('0');
			rob.mouseMove(Coordinate.S.x, Coordinate.S.y);
			rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void autoConfirm()
	{
		try
		{
			Robot rob = new Robot();
			rob.mouseMove(Coordinate.D.x, Coordinate.D.y);
			rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
