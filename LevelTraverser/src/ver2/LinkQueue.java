package ver2;

public class LinkQueue implements IQueue
{
	private Node front;

	private Node rear;

	public LinkQueue()
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
		Node p = front;
		int length = 0;
		while (p != null)
		{
			p = p.next;
			++length;
		}
		return length;
	}

	public void offer(Object o)
	{
		Node p = new Node(o);
		if (front != null)
		{
			rear.next = p;
			rear = p;
		} else

			front = rear = p;
	}

	public Object peek()
	{
		if (front != null)
			return front.data;
		else
			return null;
	}

	public Object poll()
	{
		if (front != null)
		{
			Node p = front;
			front = front.next;
			if (p == rear)
				rear = null;
			return p.data;
		} else
			return null;
	}

	public void display()
	{
		if (!isEmpty())
		{
			Node p = front;
			while (p != rear.next)
			{
				System.out.print(p.data.toString() + " ");
				p = p.next;
			}
		} else
		{
			System.out.println("此队列为空");
		}
	}

}
