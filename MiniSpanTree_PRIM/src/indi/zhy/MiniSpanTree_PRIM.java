package indi.zhy;

public class MiniSpanTree_PRIM
{

	private class CloseEdge
	{
		Object adjVex;

		int lowCost;

		public CloseEdge(Object adjVex, int lowCost)
		{
			this.adjVex = adjVex;
			this.lowCost = lowCost;
		}
	}

	public Object[][] PRIM(MGraph G, Object u) throws Exception
	{
		Object[][] tree = new Object[G.getVexNum() - 1][2];
		int count = 0;
		CloseEdge[] closeEdge = new CloseEdge[G.getVexNum()];
		int k = G.locateVex(u);
		for (int j = 0; j < G.getVexNum(); j++)
			if (j != k)
				closeEdge[j] = new CloseEdge(u, G.getArcs()[k][j]);

		closeEdge[k] = new CloseEdge(u, 0);

		for (int i = 1; i < G.getVexNum(); i++)
		{
			k = getMinMum(closeEdge);
			tree[count][0] = closeEdge[k].adjVex;
			tree[count][1] = G.getVexs()[k];
			count++;
			closeEdge[k].lowCost = 0;
			for (int j = 0; j < G.getVexNum(); j++)
				if (G.getArcs()[k][j] < closeEdge[j].lowCost)
					closeEdge[j] = new CloseEdge(G.getVex(k), G.getArcs()[k][j]);
		}
		return tree;
	}

	private int getMinMum(CloseEdge[] closeEdge)
	{
		int min = Integer.MAX_VALUE;
		int v = -1;
		for (int i = 0; i < closeEdge.length; i++)
			if (closeEdge[i].lowCost != 0 && closeEdge[i].lowCost < min)
			{
				min = closeEdge[i].lowCost;
				v = i;
			}
		return v;
	}
}
