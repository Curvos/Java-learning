package indi.zhy;

public class SeqList
{

	public RecordNode[] r;
	public int curlen;

	public SeqList()
	{
	}

	public SeqList(int maxSize)
	{
		this.r = new RecordNode[maxSize];
		this.curlen = 0;
	}

	public int length()
	{
		return curlen;
	}

	public void insert(int i, RecordNode x) throws Exception
	{
		if (curlen == r.length)
		{
			throw new Exception("顺序表已满");
		}
		if (i < 0 || i > curlen)
		{
			throw new Exception("插入位置不合理");
		}
		for (int j = curlen; j > i; j--)
		{
			r[j] = r[j - 1];
		}
		r[i] = x;
		this.curlen++;
	}

	public void display()
	{
		for (int i = 0; i < this.curlen; i++)
		{
			GUI.sb.append(" " + r[i].key.toString());
		}
		GUI.sb.append("\r\n");
	}

	/* Shellsort */
	public void shellSort(int[] d)
	{
		RecordNode temp;
		int i, j;

		for (int k = 0; k < d.length; k++)
		{

			int dk = d[k];
			for (i = dk; i < this.curlen; i++)
			{
				temp = r[i];
				for (j = i - dk; j >= 0 && temp.key.compareTo(r[j].key) < 0; j -= dk)
				{
					r[j + dk] = r[j];
				}
				r[j + dk] = temp;
			}
			GUI.sb.append("增量dk=" + dk + "  ");
			display();
		}
	}

	/* Quicksort */

	public int Partition(int i, int j)
	{
		RecordNode pivot = r[i];

		while (i < j)
		{
			while (i < j && pivot.key.compareTo(r[j].key) <= 0)
			{
				j--;
			}
			if (i < j)
			{
				r[i] = r[j];
				i++;
			}
			while (i < j && pivot.key.compareTo(r[i].key) > 0)
			{
				i++;
			}
			if (i < j)
			{
				r[j] = r[i];
				j--;
			}
		}
		r[i] = pivot;

		return i;
	}

	public void qSort(int low, int high)
	{
		if (low < high)
		{
			int pivotloc = Partition(low, high);
			qSort(low, pivotloc - 1);
			qSort(pivotloc + 1, high);
		}
	}

	public void quickSort()
	{
		qSort(0, this.curlen - 1);
	}

	/* MergeSort */

	public void merge(RecordNode[] r, RecordNode[] order, int h, int m, int t)
	{
		int i = h, j = m + 1, k = h;
		while (i <= m && j <= t)
		{
			if (r[i].key.compareTo(r[j].key) <= 0)
			{
				order[k++] = r[i++];
			} else
			{
				order[k++] = r[j++];
			}
		}
		while (i <= m)
		{
			order[k++] = r[i++];
		}
		while (j <= t)
		{
			order[k++] = r[j++];
		}
	}

	public void mergepass(RecordNode[] r, RecordNode[] order, int s, int n)
	{
		GUI.sb.append("子序列长度s=" + s + "  ");
		int p = 0;
		while (p + 2 * s - 1 <= n - 1)
		{
			merge(r, order, p, p + s - 1, p + 2 * s - 1);
			p += 2 * s;
		}
		if (p + s - 1 < n - 1)
		{
			merge(r, order, p, p + s - 1, n - 1);
		} else
		{
			for (int i = p; i <= n - 1; i++)
			{
				order[i] = r[i];
			}
		}
	}

	public void mergeSort()
	{
		int s = 1;
		int n = this.curlen;
		RecordNode[] temp = new RecordNode[n];
		while (s < n)
		{
			mergepass(r, temp, s, n);
			display();
			s *= 2;
			mergepass(temp, r, s, n);
			display();
			s *= 2;
		}
	}

}
