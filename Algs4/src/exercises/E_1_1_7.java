package exercises;
import edu.princeton.cs.algs4.StdOut;

public class E_1_1_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funa();

	}

	private static void funa() {
		// TODO Auto-generated method stub
		double t=9.0;
		while(Math.abs(t-9.0/t)>.001)
			t=(9.0/t+t)/2.0;
		StdOut.printf("%.5f\n", t);
		double a=0.001;
		if(a==.001) StdOut.println("true");
		}


}
