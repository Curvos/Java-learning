package ver1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Resolver
{
	// 存储多项式项数
	private int n = 1;
	private char[] a;
	private double[] coefs = new double[256];
	private int[] expns = new int[256];
	@SuppressWarnings("unused")
	private File file;

	public Resolver(String str)
	{
		// int j = 0;
		// int k = 0;
		a = str.toCharArray();
		for (int i = 0; i < a.length; i++)
		{

			if (a[i] == ',')
			{
				n++;
			}
		}

		File file = new File("temp.txt");
		PrintStream ps;
		try
		{
			ps = new PrintStream(new FileOutputStream(file));
			ps.println(str);// 往文件里写入字符串
			ps.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		try
		{
			Scanner sc = new Scanner(file);
			sc.useDelimiter("['' , \r\n]");
			for (int i = 0; i < n - 1; i++)
			{
				coefs[i] = sc.nextDouble();
				System.out.println(coefs[i]);
				expns[i] = sc.nextInt();
				System.out.println(expns[i]);
			}
			sc.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		// coefs = new double[256];
		// expns = new int[256];

		// int m = 0;

		// for (int i = 0; i < a.length; i++)
		// {
		//
		// if (a[i] == ',')
		// {
		// n++;
		// continue;
		// }
		//
		// if (i % 4 == 0)
		// {
		// String str1 = String.valueOf(a[i]);
		// coefs[j++] = Double.parseDouble(str1);
		// // System.out.print("i:" + i + " " + a[i] + " ");
		// // System.out.println("coef " + j + " " + coefs[j]);
		// continue;
		// }
		//
		// if ((i + 2) % 4 == 0 && i != 0)
		// {
		// String str2 = String.valueOf(a[i]);
		// expns[k++] = Integer.parseInt(str2);
		// // System.out.print("i:" + i + " " + a[i] + " ");
		// // System.out.println("expn " + k + " " + expns[k]);
		// continue;
		// }
		// }

		// while (coefs[m] != 0)
		// {

		// System.out.println(coefs[m]);
		// System.out.println(expns[m]);
		// m++;
		// }

	}

	public int num()
	{
		return n;
	}

	public double[] getCoefs()
	{
		return coefs;
	}

	public int[] getExpns()
	{
		return expns;
	}
}
