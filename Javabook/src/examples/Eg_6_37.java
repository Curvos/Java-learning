package examples;

interface USB
{
	public void start();
	public void stop();
}

class Computer
{
	 public static void plugin(USB usb)
	 {
		 usb.start();
		 System.out.println("========USB device is working========");
		 usb.stop();
	 }
}

class Flash implements USB
{
	public void start()
	{
		System.out.println("U-disk starts");
	}
	public void stop()
	{
		System.out.println("U-disk stops");
	}
}

class Printer implements USB
{
	public void start()
	{
		System.out.println("Printer starts");
	}
	public void stop()
	{
		System.out.println("Printer stops");
	}
}
 
 
public class Eg_6_37 {
	public static void main(String[] args) {
		Computer.plugin(new Flash());
		Computer.plugin(new Printer());

	}
}
