package examples;

class myThread extends Thread
{
	private String name;
	public myThread(String name)
	{
		this.name=name;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(name+"run,i="+i);
		}
	}
}

public class Eg_9_1 {
	public static void main(String[] args) {
		myThread mt1=new myThread("Thread1");
		myThread mt2=new myThread("Thread2");
		
//程序依然是顺序进行，并未实现线程		
//		mt1.run();
//		mt2.run();

//需要实现多线程,需要调用Thread类的start()方法
		mt1.start();
		mt2.start();
		
	}

}
