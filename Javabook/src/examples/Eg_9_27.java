package examples;

class Info2
{
	private String name="Scathahc";
	private String content="Queen";
	public synchronized void set(String name,String content)
	{
		this.setName(name);
		try
		{
			Thread.sleep(300);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		this.setContent(content);
	}
	public synchronized void get()
	{
		try
		{
			Thread.sleep(300);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(this.getName()+"-->"+this.getContent());
	}
	
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

class Producer2 implements Runnable
{
	private Info2 info=null;
	public Producer2(Info2 info)
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
				this.info.set("Scathach","Queen");
				flag=false;
			}
			else
			{
				this.info.set("Emiya", "Guardian");
				flag=true;
			}
		}
	}
}

class Consumer2 implements Runnable
{
	private Info2 info=null;
	public Consumer2(Info2 info)
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
			this.info.get();
		}
	}
}


public class Eg_9_27 {

	public static void main(String[] args) {
		Info2 i=new Info2(); 
		Producer2 pro=new Producer2(i);
		Consumer2 con=new Consumer2(i);
		new Thread(pro).start();
		new Thread(con).start();

	}

}
