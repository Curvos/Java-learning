
//可变参数&foreach
package examples;

public class Eg_4_23
{

	public static void main(String[] args)
	{

		System.out.print("no passing parameters fun() : ");
		fun();
		System.out.print("\n" + "passing one parameter fun(1) : ");
		fun(1);
		System.out.print("\n" + "passing five parameters fun(1,2,3,4,5) : ");
		fun(1, 2, 3, 4, 5);

	}

	public static void fun(int... arg)
	{
		for (int x : arg)
			System.out.print(x + ", ");
	}

}
