package exercises;

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
	public static String intstr(){
		return 1+2+"3";
	}
}

public class E_1_1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cal.divide());
		System.out.println(cal.sci());
		System.out.println(cal.bool());
		System.out.println(cal.intstr());
		
//1.1.8 b. c. p33
		System.out.println('b'+'c');
		//"+" convert char to int
		System.out.println((char)('a'+4));
		//the same
	}

}
