package ver1;

public class LinkList
{
	public Node head;

	public LinkList()
	{
		head = new Node();
	}

	public LinkList(int n, boolean Order) throws Exception
	{
		this();
		if (Order)
			create1(n);
		else
			create2(n);
	}

	public void create1(int n) throws Exception
	{

	}

	public void create2(int n) throws Exception
	{

	}

	public void clear()
	{
		head.data = null;
		head.next = null;
	}

	public boolean isEmpty()
	{
		return head.next == null;
	}

	public int length()
	{
		Node p = head.next;
		int length = 0;
		while (p != null)
		{
			p = p.next;
			++length;
		}
		return length;
	}

	public Object get(int i) throws Exception
	{
		Node p = head.next;
		int j = 0;
		while (p != null && j < i)
		{
			p = p.next;
			++j;
		}
		if (j > i || p == null)
		{
			throw new Exception("第" + i + "个元素不存在");
		}
		return p.data;
	}

	public void insert(int i, Object x) throws Exception
	{
		Node p = head;
		int j = -1;
		while (p != null && j < i - 1)
		{
			p = p.next;
			++j;
		}
		if (j > i - 1 || p == null)
			throw new Exception("插入位置不合法");
		Node s = new Node(x);
		s.next = p.next;
		p.next = s;
	}

	public void display()
	{
		Node node = head.next;
		while (node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
}
