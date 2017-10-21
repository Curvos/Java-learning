

//第4次作业
package homework;

class Info
{
	private String name = "苏州大学";	 
	private String content = "生物信息学"  ;	
	private boolean flag = false ;
	public synchronized void set(String name,String content)
	{
		if(!flag)
		{
			try
			{
				super.wait() ;
			}
			catch(InterruptedException e)
			{
				e.printStackTrace() ;
			}
		}
		this.setName(name) ;	
		try
		{
			Thread.sleep(300) ;
		}
		catch(InterruptedException e)
		{
			e.printStackTrace() ;
		}
		this.setContent(content) ;	
		flag  = false ;	
		super.notify() ;
	}
	public synchronized void get()
	{
		if(flag)
		{
			try{
				super.wait() ;
			}
			catch(InterruptedException e)
			{
				e.printStackTrace() ;
			}
		}
		try{
			Thread.sleep(300) ;
		}
		catch(InterruptedException e)
		{
			e.printStackTrace() ;
		}
		System.out.println(this.getName() + 
			" --> " + this.getContent()) ;
		flag  = true ;	
		super.notify() ;
	}
	public void setName(String name)
	{
		this.name = name ;
	}
	public void setContent(String content)
	{
		this.content = content ;
	}
	public String getName()
	{
		return this.name ;
	}
	public String getContent()
	{
		return this.content ;
	}
};

class Producer implements Runnable
{	
	private Info info = null ;
	public Producer(Info info)
	{
		this.info = info ;
	}
	public void run()
	{
		boolean flag = false ;
		for(int i=0;i<50;i++)
		{
			if(flag)
			{
				this.info.set("苏州大学","生物信息学") ;
				flag = false ;
			}
			else
			{
				this.info.set("章皓宇","	JAVA") ;
				flag = true ;
			}
		}
	}
};
class Consumer implements Runnable
{
	private Info info = null ;
	public Consumer(Info info){
		this.info = info ;
	}
	public void run()
	{
		for(int i=0;i<50;i++)
		{
			this.info.get() ;
		}
	}
};

public class ThreadDemo {
	public static void main(String[] args) {
		Info info=new Info();
		Producer pro=new Producer(info);
		Consumer con=new Consumer(info);
		new Thread(pro).start();
		new Thread(con).start();

	}

}
