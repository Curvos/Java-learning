package no_6;

public class Eg_14_6
{
	public enum Color
	{
		RED, GREEN, BLUE;
	}

	public static void main(String[] args)
	{
		for (Color c : Color.values())
			print(c);
	}

	public static void print(Color color)
	{
		switch (color)
		{

		case RED:
		{
			System.out.println("��ɫ");
			break;
		}
		case GREEN:
		{
			System.out.println("��ɫ");
			break;
		}
		case BLUE:
		{
			System.out.println("��ɫ");
			break;
		}
		default:
		{
			System.out.println("δ֪��ɫ");
			break;
		}

		}
	}

}
