package pack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Submit
{
	public Robot robot;

	public Submit()
	{
		try
		{
			@SuppressWarnings("unused")
			Robot robot = new Robot();
		} catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aotoSubmit()
	{

		robot.mouseMove(Coordinate.A.x, Coordinate.A.y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.keyPress('7');
		robot.keyRelease('7');
		robot.keyPress('0');
		robot.keyRelease('0');
		robot.keyPress('0');
		robot.keyRelease('0');
		robot.mouseMove(Coordinate.S.x, Coordinate.S.y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	}

	public void autoConfirm()
	{
		robot.mouseMove(Coordinate.D.x, Coordinate.D.y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
}
