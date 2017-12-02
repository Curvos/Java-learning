package indi.zhy;

public class DTraverser
{
	private static boolean[] visited;
	public static StringBuffer sb = new StringBuffer("");

	public static void DFSTraverse(IGraph G) throws Exception
	{
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++)

			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])
				DFS(G, v);
	}

	public static void DFS(IGraph G, int v) throws Exception
	{
		visited[v] = true;
		sb.append(G.getVex(v).toString() + " ");
		// System.out.print(G.getVex(v).toString() + " ");
		for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w))
			if (!visited[w])
				DFS(G, w);
	}

}
