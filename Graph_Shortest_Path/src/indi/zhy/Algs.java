package indi.zhy;

public class Algs
{
	public final static int INFINITY = Integer.MAX_VALUE;
	public static StringBuffer sb = new StringBuffer("");

	public static String findPlace(MGraph G, int[][] D) throws Exception
	{
		int min = INFINITY;
		int sum = 0;// 用于记录一个顶点到其他顶点的最短路径长度的和
		int u = -1;
		for (int v = 0; v < D.length; v++)
		{
			sum = 0;
			for (int w = 0; w < D.length; w++)
				sum += D[v][w];// 求一点到其他顶点的最短长度之和
			if (min > sum)
			{
				min = sum;
				u = v;
			}
		}
		sb.append("俱乐部应设在" + G.getVex(u) + "村，其到各村的路径长度依次为：").append("\r\n");
		// System.out.println("俱乐部应设在" + G.getVex(u) + "村，其到各村的路径长度依次为：");
		for (int i = 0; i < D.length; i++)
			// System.out.print(D[u][i] + "\t");
			sb.append(D[u][i] + "\t");
		// System.out.println();
		return sb.toString();
	}

	public static String display(int[][] D)
	{
		sb.append("各村之间的最短路径长度为：").append("\r\n");
		// System.out.println("各村之间的最短路径长度为：");
		for (int v = 0; v < D.length; v++)
		{
			for (int w = 0; w < D.length; w++)
				// System.out.print(D[v][w] + "\t");
				sb.append(D[v][w] + "\t");
			sb.append("\r\n");
			// System.out.println();
		}
		return sb.toString();
	}
}
