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
			// flagΪfalseʱ�����ַ������й���
			if (flag == false)
			{
				temp = scan.nextLine() + System.lineSeparator();
				str = str + temp;
				// �����ȡһ���к��С�>������flag��Ϊtrue
				if (temp.startsWith(">"))
					flag = true;
				continue;
			}

			// flagΪtrue�����ַ������й��˲����Ӷ�ȡ���ַ���
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
