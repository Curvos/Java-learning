package modules;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum
{
	public static int count(int[] a)
	{
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				for (int k = 0; k < N; k++)
					if (a[i] + a[j] + a[k] == 0)
					{
						cnt++;
						// StdOut.print(i + " " + j + " " + k);
						// StdOut.println(a[i] + " " + a[j] + " " + a[k]);
					}
		return cnt;
	}

	public static void main(String[] args)
	{
		int a[] = In.readInts(args[0]);
		StdOut.println(count(a));
	}

}
