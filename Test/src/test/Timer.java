package test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Timer
{

	public static void main(String[] args)
	{

		Calendar c = new GregorianCalendar();
		c.set(Calendar.HOUR_OF_DAY, 11);
		c.set(Calendar.MINUTE, 29);
		c.set(Calendar.SECOND, 00);
		System.out.println(Calendar.HOUR_OF_DAY);

	}
}
