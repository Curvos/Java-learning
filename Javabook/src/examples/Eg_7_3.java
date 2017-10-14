package examples;

public class Eg_7_3 {

	public static void main(String[] args) {
		System.out.println("Strat cacul");
		int i=1;
		int j=0;
		try{
			System.out.println("1/0");
			int temp=i/j;
		}
		catch(ArithmeticException e)
		{
			System.out.println("math error");
		}
		finally
		{
			System.out.println("Default threads");
		}
		System.out.println("End cacul");
		

	}

}
