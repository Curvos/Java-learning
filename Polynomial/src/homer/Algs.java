package homer;

// 计算一元多项式
public class Algs
{
	public static double compute(int n, double a[], double x)
	{
		double value = a[n];
		for (int i = n; i > 0; i--)
		{
			value = a[i - 1] + x * value;
		}
		return value;
	}
}
