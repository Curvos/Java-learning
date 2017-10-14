package test;


	
	class Info
	{
		private String name="Scathach";
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
	
	class Producer implements Runnable
	{
		private Info info=null;
		public Producer(Info info)
		{
			this.info=info;
		}
		public void run()
		{
			boolean flag=true;
			for(int i=0;i<50;i++)
			{
				if(flag)
				{
					this.info.set("Scathach", "Queen");
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
					Thread.sleep(300);
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
		Info info=new Info();
		Producer pro=new Producer(info);
		Consumer con=new Consumer(info);
		new Thread(pro).start();
		new Thread(con).start();
		
		
		

	}

}
