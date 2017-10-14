package exercises;

//using indexOf() and length().

public class E_1_2_6 {
	public static void main(String[] args){
		String a=args[0];
		String b=args[1];
		System.out.println(isRota(a,b));
	}
	public static boolean isRota(String a,String b)
	{
		if((a.length() == b.length()) && (a.concat(a).indexOf(b) >= 0))
		return true;
		return false;
	}

}
