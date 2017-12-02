package indi.zhy;

public class ALGraph implements IGraph
{
	private GraphKind kind;

	private int vexNum, arcNum;

	private VNode[] vexs;

	public ALGraph()
	{
		this(null, 0, 0, null);
	}

	public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs)
	{
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	public void createGraph()
	{

		GraphKind kind = GraphKind.valueOf(GUI.tfType.getText());
		setKind(kind);
		switch (kind)
		{
		case UDG:
			createUDG();

			return;
		case DG:
			createDG();
			return;
		case UDN:
			createUDN();
			return;
		case DN:
			createDN();
			return;
		}
	}

	private void createUDG()
	{
		// get vexs
		vexNum = Integer.parseInt(GUI.tfVexNum.getText());
		arcNum = Integer.parseInt(GUI.tfArcNum.getText());
		vexs = new VNode[vexNum];
		// arcs = new int[vexNum][vexNum];

		String vexsinfo = GUI.tfVexs.getText();
		String[] temp1 = vexsinfo.split(",");
		int len1 = temp1.length;

		// Object[] vexs = new Object[len1];
		for (int i = 0; i < len1; i++)
		{
			vexs[i] = new VNode(temp1[i]);
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
			// int value = Integer.parseInt(dim2[2]);
			addArc(v, u);
			addArc(u, v);
			ind++;
		} while (ind < temp.length);

	};

	private void createDG()
	{
		// get vexs
		vexNum = Integer.parseInt(GUI.tfVexNum.getText());
		arcNum = Integer.parseInt(GUI.tfArcNum.getText());
		vexs = new VNode[vexNum];
		// arcs = new int[vexNum][vexNum];

		String vexsinfo = GUI.tfVexs.getText();
		String[] temp1 = vexsinfo.split(",");
		int len1 = temp1.length;

		// Object[] vexs = new Object[len1];
		for (int i = 0; i < len1; i++)
		{
			vexs[i] = new VNode(temp1[i]);
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
			addArc(v, u);
			ind++;
		} while (ind < temp.length);
	};

	public void createUDN()
	{
		// get vexs
		vexNum = Integer.parseInt(GUI.tfVexNum.getText());
		arcNum = Integer.parseInt(GUI.tfArcNum.getText());
		vexs = new VNode[vexNum];
		// arcs = new int[vexNum][vexNum];

		String vexsinfo = GUI.tfVexs.getText();
		String[] temp1 = vexsinfo.split(",");
		int len1 = temp1.length;

		// Object[] vexs = new Object[len1];
		for (int i = 0; i < len1; i++)
		{
			vexs[i] = new VNode(temp1[i]);
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
			int value = Integer.parseInt(dim2[2]);
			addArc(v, u, value);
			addArc(u, v, value);
			ind++;
		} while (ind < temp.length);

	}

	public void createDN()
	{
		// get vexs
		vexNum = Integer.parseInt(GUI.tfVexNum.getText());
		arcNum = Integer.parseInt(GUI.tfArcNum.getText());
		vexs = new VNode[vexNum];
		// arcs = new int[vexNum][vexNum];

		String vexsinfo = GUI.tfVexs.getText();
		String[] temp1 = vexsinfo.split(",");
		int len1 = temp1.length;

		// Object[] vexs = new Object[len1];
		for (int i = 0; i < len1; i++)
		{
			vexs[i] = new VNode(temp1[i]);
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
			int value = Integer.parseInt(dim2[2]);
			addArc(v, u, value);
			ind++;
		} while (ind < temp.length);

	}

	public void addArc(int v, int u, int value)
	{
		ArcNode arc = new ArcNode(u, value);
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}

	public void addArc(int v, int u)
	{
		ArcNode arc = new ArcNode(u);
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
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
			if (vexs[v].data.equals(vex))
				return v;
		return -1;
	}

	public VNode[] getVexs()
	{
		return vexs;
	}

	public GraphKind getKind()
	{
		return kind;
	}

	public Object getVex(int v) throws Exception
	{
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		return vexs[v].data;
	}

	public int firstAdjVex(int v) throws Exception
	{
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		VNode vex = vexs[v];
		if (vex.firstArc != null)
			return vex.firstArc.adjVex;
		else
			return -1;
	}

	public int nextAdjVex(int v, int w) throws Exception
	{
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		VNode vex = vexs[v];

		ArcNode arcvw = null;
		for (ArcNode arc = vex.firstArc; arc != null; arc = arc.nextArc)
			if (arc.adjVex == w)
			{
				arcvw = arc;
				break;
			}
		if (arcvw != null && arcvw.nextArc != null)
			return arcvw.nextArc.adjVex;
		else
			return -1;
	}

	public void setArcNum(int arcNum)
	{
		this.arcNum = arcNum;
	}

	public void setKind(GraphKind kind)
	{
		this.kind = kind;
	}

	public void setVexNum(int vexNum)
	{
		this.vexNum = vexNum;
	}

	public void setVexs(VNode[] vexs)
	{
		this.vexs = vexs;
	}
}
