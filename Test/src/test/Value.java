package test;

class cal{
	public static int divide(){
		return (0+15)/2;
	}
	public static double sci(){
		return 2.0e-6*100000000.1;
	}
	public static boolean bool(){
		return true && false || true && true;
	}
}

public class Value {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cal.divide());
		System.out.println(cal.sci());
		System.out.println(cal.bool());

	}

}
