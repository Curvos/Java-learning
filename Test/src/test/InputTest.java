package test;

import edu.princeton.cs.algs4.StdIn;

public class InputTest {

	public static void main(String[] args) {
		int[] a=new int[3];
		int n=0;
		while(!StdIn.isEmpty())
		{
				a[n]=StdIn.readInt();
				n++;
		}
		System.out.println("1");
		for(int i=0;i<3;i++)
			System.out.println(a[i]);

	}

}
