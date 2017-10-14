package ver1;

public class Resolver
{
	// 存储多项式项数
	private int n = 1;
	private char[] a;
	private double[] coefs;
	private int[] expns;

	public Resolver(String str)
	{
		a = str.toCharArray();
		coefs = new double[256];
		expns = new int[256];
		int j = 0;
		int k = 0;
		// int m = 0;

		for (int i = 0; i < a.length; i++)
		{

			if (a[i] == ',')
			{
				n++;
				continue;
			}

			if (i % 4 == 0)
			{
				String str1 = String.valueOf(a[i]);
				coefs[j++] = Double.parseDouble(str1);
				// System.out.print("i:" + i + " " + a[i] + " ");
				// System.out.println("coef " + j + " " + coefs[j]);
				continue;
			}

			if ((i + 2) % 4 == 0 && i != 0)
			{
				String str2 = String.valueOf(a[i]);
				expns[k++] = Integer.parseInt(str2);
				// System.out.print("i:" + i + " " + a[i] + " ");
				// System.out.println("expn " + k + " " + expns[k]);
				continue;
			}
		}

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
