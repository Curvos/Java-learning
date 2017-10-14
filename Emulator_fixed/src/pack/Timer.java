package pack;

public class Timer
{
	private int Hour;
	private int Minute;
	private int Second;
	private boolean flag = true;
	// private Submit sub = new Submit();

	public Timer()
	{
		Hour = 11;
		Minute = 29;
		Second = 0;
	}

	public void Hour_increase()
	{
		Hour = (Hour + 1) % 24;
		MyWindow.hourText.setText(getHour());
	}

	public void Hour_decrease()
	{
		Hour = Hour - 1;
		if (Hour < 0)
			Hour = 23;
		MyWindow.hourText.setText(getHour());
	}

	public void Minute_increase()
	{
		if (Minute + 1 == 60)
			Hour_increase();
		Minute = (Minute + 1) % 60;
		MyWindow.minuteText.setText(getMinute());
	}

	public void Minute_decrease()
	{
		if (Minute - 1 < 0)
			Hour_decrease();
		Minute = Minute - 1;
		if (Minute < 0)
			Minute = 59;
		MyWindow.minuteText.setText(getMinute());
	}

	public void Second_increase()
	{
		if (Second + 1 == 60)
			Minute_increase();
		Second = (Second + 1) % 60;
		MyWindow.secondText.setText(getSecond());
	}

	public void Second_decrease()
	{
		if (Second - 1 < 0)
			Minute_decrease();
		Second = Second - 1;
		if (Second < 0)
			Second = 59;
		MyWindow.secondText.setText(getSecond());
	}

	class TimeThread extends Thread
	{
		public void run()
		{
			while (flag == true)
			{
				try
				{
					Thread.sleep(1000);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				if (Hour == 11 && Minute == 29 && Second == 48)
				{
					Submiter.autoSubmit();
				}

				if (Hour == 11 && Minute == 29 && Second == 55)
				{
					Submiter.autoConfirm();
				}
				Second_increase();
			}
		}
	}

	public String getHour()
	{
		return String.valueOf(Hour);
	}

	public void setHour(int hour)
	{
		Hour = hour;
	}

	public String getMinute()
	{
		return String.valueOf(Minute);
	}

	public void setMinute(int minute)
	{
		Minute = minute;
	}

	public String getSecond()
	{
		return String.valueOf(Second);
	}

	public void setSecond(int second)
	{
		Second = second;
	}

	public boolean isFlag()
	{
		return flag;
	}

	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}

}
