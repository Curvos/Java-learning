package exercises;
import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E_1_2_9 {
	
	public static int rank(int key,int[] a,Counter c)
	{
		c.increment();
		int lo=0;
		int hi=a.length-1;
		while(lo<=hi)
		{
			int mid = lo+(hi-lo)/2;
			if	   (key>mid)   lo=mid+1;
			else if(key<mid)   hi=mid-1;
			else               return mid;
		}
		return -1;
		
	}
	public static void main(String[] args) {
		Counter c =new Counter("c0");
		int [] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		while(!StdIn.isEmpty())
		{
			int key = StdIn.readInt();
			if(rank(key,whitelist,c)<0)
				StdOut.println(key);
		}
		StdOut.println("Number of examined keys:"+c.tally());
		
	}

}
