package modules;

import edu.princeton.cs.algs4.StdIn;

class isPrime{
	public static boolean judge(int N)
	{
	if(N<2) return false;
	for(int i=2;i*i<N;i++)
		if(N%i==0) return false;
	return true;
	}
	
}

public class judgePrime {
	public static void main(String[] args) {
		int N=StdIn.readInt();
		System.out.println(new isPrime().judge(N));
		
	
		
		

	}

}
