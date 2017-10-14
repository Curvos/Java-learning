package examples;

class Singleton{
	private static Singleton instance=new Singleton();
	private Singleton(){
	}
		public static Singleton getInstance(){
			return instance;
		}
		public void print(){
			System.out.println("Hello Wolrd!!!");
		}
	}

public class Eg5_63 {
	public static void main(String args[]){
		Singleton s1= Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		Singleton s3=Singleton.getInstance();
		s1.print();
		s2.print();
		s3.print();
		
		
	} 

}
