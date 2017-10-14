package exercises;
import java.util.Arrays;

import edu.princeton.cs.algs4.Point2D;


public class E_1_2_1 {

	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		int E=N*(N-1)/2;
		Point2D[] p=new Point2D[N];
		double[] d=new double[E];
		int count=0;
		
		for(int i=0;i<N;i++)
		{
			p[i]=new Point2D(Math.random(),Math.random());
			p[i].draw();
			for(int temp=(i+1);(temp-1)>0;temp--)
			{
				d[count++]=p[temp-1].distanceTo(p[temp-2]);
			}
		}
		
		Arrays.sort(d);
		System.out.println("The min distance:"+d[0]);
		System.out.println("The max distance:"+d[d.length-1]);
		


		

	}

}
