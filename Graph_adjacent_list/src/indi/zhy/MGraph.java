package indi.zhy;

public class MGraph implements IGraph
{
	public final static int INFINITY = Integer.MAX_VALUE;

	private GraphKind kind;

	private int vexNum, arcNum;

	private Object[] vexs;

	private int[][] arcs;

	public MGraph()
	{
		this(null, 0, 0, null, null);
	}

	public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs)
	{
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}

	public void createGraph()
	{

		GraphKind kind = GraphKind.valueOf(GUI.tfType.getText());
		switch (kind)
		{
		case UDG:
			createUDG();

			return;
		case DG:
			createDG();
			return;
		case UDN:
			// createUDN();
			resolveUDN();
			return;
		case DN:
			// createDN();
			resolveDN();
			return;
		}
	}

	private void createUDG()
	{
		// get vexs
		vexNum = Integer.parseInt(GUI.tfVexNum.getText());
		arcNum = Integer.parseInt(GUI.tfArcNum.getText());
		vexs = new Object[vexNum];
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < arcNum; u++)
				arcs[v][u] = 0;

		String vexsinfo = GUI.tfVexs.getText();
		String[] temp1 = vexsinfo.split(",");
		int len1 = temp1.length;

		// Object[] vexs = new Object[len1];
		for (int i = 0; i < len1; i++)
		{
			vexs[i] = temp1[i];
		}
		//

		// create

		String arcsinfo = GUI.tfArcs.getText();
		String[] temp = arcsinfo.split(",");

		// int len = temp.length;
		String[] dim2;
		int ind = 0;
		// Object[] vexs2 = new Object[len];
		do
		{
			dim2 = temp[ind].split(" ");
			int v = locateVex(dim2[0]);
			int u = locateVex(dim2[1]);
			arcs[v][u] = arcs[u][v] = 1;
			ind++;
		} while (ind < temp.length);
	};

	private void createDG()
	{
		// get vexs
		vexNum = Integer.parseInt(GUI.tfVexNum.getText());
		arcNum = Integer.parseInt(GUI.tfArcNum.getText());
		vexs = new Object[vexNum];
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < arcNum; u++)
				arcs[v][u] = 0;

		String vexsinfo = GUI.tfVexs.getText();
		String[] temp1 = vexsinfo.split(",");
		int len1 = temp1.length;

		// Object[] vexs = new Object[len1];
		for (int i = 0; i < len1; i++)
		{
			vexs[i] = temp1[i];
		}
		//

		// create

		String arcsinfo = GUI.tfArcs.getText();
		String[] temp = arcsinfo.split(",");

		// int len = temp.length;
		String[] dim2;
		int ind = 0;
		// Object[] vexs2 = new Object[len];
		do
		{
			dim2 = temp[ind].split(" ");
			int v = locateVex(dim2[0]);
			int u = locateVex(dim2[1]);
			arcs[v][u] = 1;
			ind++;
		} while (ind < temp.length);
	};

	// alt
	public Object[] resolveVexs()
	{
		String vexsinfo = GUI.tfVexs.getText();
		String[] temp = vexsinfo.split(vexsinfo, ',');
		int len = temp.length;
		Object[] vexs = new Object[len];
		for (int i = 0; i < len; i++)
		{
			vexs[i] = temp[i];
		}
		return vexs;
	}

	public void resolveUDN()
	{
		// get vexs
		vexNum = Integer.parseInt(GUI.tfVexNum.getText());
		arcNum = Integer.parseInt(GUI.tfArcNum.getText());
		vexs = new Object[vexNum];
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < arcNum; u++)
				arcs[v][u] = INFINITY;

		String vexsinfo = GUI.tfVexs.getText();
		String[] temp1 = vexsinfo.split(",");
		int len1 = temp1.length;

		// Object[] vexs = new Object[len1];
		for (int i = 0; i < len1; i++)
		{
			vexs[i] = temp1[i];
		}
		//

		// create

		String arcsinfo = GUI.tfArcs.getText();
		String[] temp = arcsinfo.split(",");

		// int len = temp.length;
		String[] dim2;
		int ind = 0;
		// Object[] vexs2 = new Object[len];
		do
		{
			dim2 = temp[ind].split(" ");
			int v = locateVex(dim2[0]);
			int u = locateVex(dim2[1]);
			arcs[v][u] = arcs[u][v] = Integer.parseInt(dim2[2]);
			ind++;
		} while (ind < temp.length);

	}

	public void resolveDN()
	{
		// get vexs
		vexNum = Integer.parseInt(GUI.tfVexNum.getText());
		arcNum = Integer.parseInt(GUI.tfArcNum.getText());
		vexs = new Object[vexNum];
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < arcNum; u++)
				arcs[v][u] = INFINITY;

		String vexsinfo = GUI.tfVexs.getText();
		String[] temp1 = vexsinfo.split(",");
		int len1 = temp1.length;

		// Object[] vexs = new Object[len1];
		for (int i = 0; i < len1; i++)
		{
			vexs[i] = temp1[i];
		}
		//

		// create

		String arcsinfo = GUI.tfArcs.getText();
		String[] temp = arcsinfo.split(",");

		// int len = temp.length;
		String[] dim2;
		int ind = 0;
		// Object[] vexs2 = new Object[len];
		do
		{
			dim2 = temp[ind].split(" ");
			int v = locateVex(dim2[0]);
			int u = locateVex(dim2[1]);
			arcs[v][u] = Integer.parseInt(dim2[2]);
			ind++;
		} while (ind < temp.length);

	}

	public int getVexNum()
	{
		return vexNum;
	}

	public int getArcNum()
	{
		return arcNum;
	}

	public int locateVex(Object vex)
	{
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}

	public Object getVex(int v) throws Exception
	{
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		return vexs[v];
	}

	public int firstAdjVex(int v) throws Exception
	{
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	public int nextAdjVex(int v, int w) throws Exception
	{
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	public GraphKind getKind()
	{
		return kind;
	}

	public int[][] getArcs()
	{
		return arcs;
	}

	public Object[] getVexs()
	{
		return vexs;
	}

	public void setArcNum(int arcNum)
	{
		this.arcNum = arcNum;
	}

	public void setArcs(int[][] arcs)
	{
		this.arcs = arcs;
	}

	public void setKind(GraphKind kind)
	{
		this.kind = kind;
	}

	public void setVexNum(int vexNum)
	{
		this.vexNum = vexNum;
	}

	public void setVexs(Object[] vexs)
	{
		this.vexs = vexs;
	}

}
