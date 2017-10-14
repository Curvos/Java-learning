package imp1;

public class SeqList
{
	private Object[] listElem;
	private int curLen;

	public SeqList(int maxSize)
	{
		curLen = 0;
		listElem = new Object[maxSize];
	}

	public void clear()
	{
		curLen = 0;
	}

	public boolean isEmpty()
	{
		return curLen == 0;
	}

	public int length()
	{
		return curLen;
	}

	public Object get(int index)
	{
		return listElem[index];
	}

	public void remove(int index) throws Exception
	{
		if (index < 0 || index > curLen - 1)
			throw new Exception("删除位置不合法");
		for (int i = index; i < curLen - 1; i++)
			listElem[i] = listElem[i + 1];
		curLen -= 1;
	}

	public void insert(int index, Object x) throws Exception
	{
		if (curLen == listElem.length)
			throw new Exception("顺序表已满");
		if (index < 0 || index > curLen)
			throw new Exception("插入位置不合法");
		for (int i = curLen; i > index; i--)
			listElem[i] = listElem[i - 1];
		listElem[index] = x;
		curLen++;
	}

	public int indexOf(Object x)
	{
		int i = 0;
		while (i < curLen && !listElem[i].equals(x))
		{
			i++;
		}
		if (i < curLen)
			return i;
		else
			return -1;
	}

	public String display()
	{
		String temp = "";
		for (int i = 0; i < curLen; i++)
		{
			temp = temp + listElem[i] + ",";
		}
		return temp;
	}

}
