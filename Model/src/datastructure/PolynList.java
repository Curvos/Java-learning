package datastructure;

public class PolynList extends LinkList
{
	public static String result;

	public PolynList(int n, double[] coefs, int[] expns)
	{
		head.data = new PolynNode(0, -1);
		for (int i = 0; i < n; i++)
		{
			double coef = coefs[i];
			int expn = expns[i];
			try
			{
				insert(new PolynNode(coef, expn));
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void insert(PolynNode e) throws Exception
	{
		int j = 0;
		while (j < length())
		{
			PolynNode t = (PolynNode) get(j);
			if (t.expn > e.expn)
				break;
			j++;
		}
		insert(j, e);
	}

	public int cmp(PolynNode a, PolynNode b)
	{
		if (a.expn < b.expn)
			return -1;
		else if (a.expn == b.expn)
			return 0;
		else
			return 1;
	}

	public PolynList addPolyn(PolynList LA, PolynList LB)
	{
		Node ha = LA.head;
		Node qa = LA.head.next;
		Node qb = LB.head.next;
		while (qa != null && qb != null)
		{
			PolynNode a = (PolynNode) qa.data;
			PolynNode b = (PolynNode) qb.data;
			switch (cmp(a, b))
			{
			case -1:
				ha.next = qa;
				ha = qa;
				qa = qa.next;
				break;
			case 0:
				double sum = a.coef + b.coef;
				if (sum != 0.0)
				{
					a.coef = sum;
					ha.next = qa;
					ha = qa;
					qa = qa.next;
					qb = qb.next;
				} else
				{
					qa = qa.next;
					qb = qb.next;
				}
				break;
			case 1:
				ha.next = qb;
				ha = qb;
				qb = qb.next;
				break;
			}
		}
		ha.next = (qa != null ? qa : qb);
		return LA;
	}

	public void display()
	{

		result = "";
		for (int i = 0; i < length(); i++)
		{
			try
			{
				PolynNode e = (PolynNode) get(i);
				result = result + "第 " + (i + 1) + " 项" + "系数为：" + e.coef + " 指数为: " + e.expn + "\r\n";
				// System.out.println("系数为：" + e.coef + "指数为: " + e.expn);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		// System.out.println(result);

	}
}
