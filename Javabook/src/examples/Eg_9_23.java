package examples;


class Info
{
	private String name="Scathach";
	private String content="Queen";
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
}

class Producer implements Runnable
{
	private Info info=null;
	public Producer(Info info)
	{
		this.info=info;
	}
	public void run()
	{
		boolean flag=false;
		for(int i=0;i<50;i++)
		{
			if(flag)
			{
				this.info.setName("Scathach");
				try
				{
					Thread.sleep(90);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				this.info.setContent("Queen");
				flag=false;
			}
			else
			{
				this.info.setName("Emiya");
				try
				{
					Thread.sleep(90);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				this.info.setContent("Guardian");
				flag=true;
			}
		}
	}
}

class Consumer implements Runnable
{
	private Info info=null;
	public Consumer(Info info)
	{
		this.info=info;
	}
	public void run()
	{
		for(int i=0;i<50;i++)
		{
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(this.info.getName()+"-->"+this.info.getContent());
		}
	}
}
	

public class Eg_9_23 {
	public static void main(String[] args) {
		Info i=new Info();
		Producer pro=new Producer(i);
		Consumer con=new Consumer(i);
		new Thread(pro).start();
		new Thread(con).start();
		

	}

}
