package zhy.indi;

public class LinkStack implements IStack
{

	private Node top;

	public void clear()
	{
		top = null;
	}

	public boolean isEmpty()
	{
		return top == null;
	}

	public int length()
	{
		Node p = top;
		int length = 0;
		while (p != null)
		{
			p = p.next;
			++length;
		}
		return length;
	}

	public Object peek()
	{
		if (!isEmpty())
			return top.data;
		else
			return null;
	}

	public Object pop()
	{
		if (!isEmpty())
		{
			Node p = top;
			top = top.next;
			return p.data;
		} else
			return null;
	}

	public void push(Object x)
	{
		Node p = new Node(x);
		p.next = top;
		top = p;
	}

	public void display()
	{
		Node p = top;
		while (p != null)
		{
			System.out.print((p.data.toString() + " "));
			p = p.next;
		}
	}
}
