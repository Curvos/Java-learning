package w04;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Filter
{
	private String str = "";
	private String temp;
	private boolean flag = false;

	public String Filt(File f) throws IOException
	{
		Scanner scan = new Scanner(new FileReader(f));
		while (scan.hasNext())
		{
			// flag为false时不对字符串进行过滤
			if (flag == false)
			{
				temp = scan.nextLine() + System.lineSeparator();
				str = str + temp;
				// 如果读取一行中含有“>”，将flag置为true
				if (temp.startsWith(">"))
					flag = true;
				continue;
			}

			// flag为true，对字符串进行过滤并连接读取的字符串
			if (flag == true)
			{

				temp = scan.nextLine();
				temp = (temp.replaceAll("\\d", "")).trim();
				if (temp.equals(""))
				{
					str = str + System.lineSeparator() + System.lineSeparator();
					flag = false;
				}
				str = str + temp;
				continue;
			}

		}
		scan.close();
		return str;
	}
}
