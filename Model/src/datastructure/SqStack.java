package datastructure;

public class SqStack implements IStack
{
	private Object[] stackElem;
	private int top;

	public SqStack(int maxSize)
	{
		stackElem = new Object[maxSize];
		top = 0;
	}

	public void clear()
	{
		top = 0;
	}

	public boolean isEmpty()
	{
		return top == 0;
	}

	public int length()
	{
		return top;
	}

	public Object peak()
	{
		if (!isEmpty())
			return stackElem[top - 1];
		else
			return null;
	}

	public void push(Object obj)
	{
		if (top == stackElem.length)
			System.out.println("Stack is full!");
		else
			stackElem[top++] = obj;
	}

	public Object pop()
	{
		if (isEmpty())
			return null;
		else
			return stackElem[--top];
	}

	public String display()
	{
		StringBuffer str = new StringBuffer("");
		for (int i = top - 1; i >= 0; i--)
			str = str.append(stackElem[i].toString());
		return str.toString();
	}

}
