package pack;

import java.awt.MouseInfo;
import java.awt.Point;

public class Coordinate
{
	public static Point A = new Point();
	public static Point S = new Point();
	public static Point D = new Point();

	public void setLocation(char key)
	{
		switch (key)
		{
		case 'A':
			A = MouseInfo.getPointerInfo().getLocation();
			MyWindow.textCustom.setText(String.valueOf(A.getX()) + "," + String.valueOf(A.getY()));
			break;
		case 'a':
			A = MouseInfo.getPointerInfo().getLocation();
			MyWindow.textCustom.setText(String.valueOf(A.getX()) + "," + String.valueOf(A.getY()));
			break;
		case 'S':
			S = MouseInfo.getPointerInfo().getLocation();
			MyWindow.textRaise.setText(String.valueOf(S.getX()) + "," + String.valueOf(S.getY()));
			break;
		case 's':
			S = MouseInfo.getPointerInfo().getLocation();
			MyWindow.textRaise.setText(String.valueOf(S.getX()) + "," + String.valueOf(S.getY()));
			break;
		case 'D':
			D = MouseInfo.getPointerInfo().getLocation();
			MyWindow.textConfirm.setText(String.valueOf(D.getX()) + "," + String.valueOf(D.getY()));
			break;
		case 'd':
			D = MouseInfo.getPointerInfo().getLocation();
			MyWindow.textConfirm.setText(String.valueOf(D.getX()) + "," + String.valueOf(D.getY()));
			break;
		}
	}
}
