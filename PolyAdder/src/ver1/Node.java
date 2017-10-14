package ver1;

public class Node
{
	public Object data;
	public Node next;

	public Node(Object data, Node next)
	{
		this.data = data;
		this.next = next;
	}

	public Node()
	{
		this(null, null);
	}

	public Node(Object data)
	{
		this(data, null);
	}
}
