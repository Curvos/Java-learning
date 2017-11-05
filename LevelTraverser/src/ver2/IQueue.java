package ver2;

public interface IQueue
{
	public void clear();

	public boolean isEmpty();

	public int length();

	public Object peek();

	public Object poll();

	public void offer(Object o) throws Exception;

	public void display();

}
