package datastructure;

public class PriorityQueue implements IQueue
{
	private Node front;
	private Node rear;
	
	public PriorityQueue()
	{
		front = rear = null;
	}

	public void clear()
	{
		front = rear = null;
	}

	public boolean isEmpty()
	{
		return front == null;
	}

	public int length()
	{
		int length = 0;
		Node p = new Node();
		p = front;
		while (p != null)
		{
			p = p.next;
			++length;
		}
		return length;
	}

	// public void offer(Object x)
	// {
	// PriorityQData pn = (PriorityQData) x;
	// Node s = new Node(pn);
	// if (front == null)
	// front = rear = s;
	// else
	// {
	// Node p = front;
	// while (p != null)
	// {
	// if (pn.Priority < ((PriorityQData) p.data).Priority)
	// {
	// s.next = p ;
	// p = p.next;
	// } else if (pn.Priority >= ((PriorityQData) p.data).Priority)
	// {
	// rear.next = s;
	// }
	// }
	// }
	// }

	public void offer(Object x)
	{
		PriorityQData pn = (PriorityQData) x;
		Node s = new Node(pn);
		if (front == null)
			front = rear = s;
		else {
			Node p = front, q = front;
			while (p != null && pn.priority >= ((PriorityQData) p.data).priority)
					{
						q=p;
						p=p.next;
					}
			if (p == null)
			{
				rear.next = s;
				rear = s;
			}
			else if(p == front)
			{
				s.next = front;
				front = s;
			}
			else {
				q.next = s;
				s.next = p;
			}
		}
	}

	public Object peek()
	{
		if (front == null)
			return null;
		else
			return front;
	}

	public Object poll()
	{
		if (front == null)
			return null;
		else
		{
			Node p = front;
			front = p.next;
			return p.data;
		}
	}

	public String display()
	{
		StringBuffer str = new StringBuffer();
		str = str.append("");
		if (!isEmpty())
		{
			Node p = front;
			while (p != rear.next)
			{
				PriorityQData q = (PriorityQData) p.data;
				str = str.append("Process Id: " + q.elem + " " + "Process Priority: " + q.priority);
				str = str.append("\r\n");
				p = p.next;
			}
			String resl = str.toString();
			return resl;
		}
		else {
			str = str.append("Emoty Queue!");
			String resl = str.toString();
			return resl;
		}

	}

}