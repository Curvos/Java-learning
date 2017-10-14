

//第1次作业
package homework;

public class MethodDemo03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int one=add(10,20);
		int two=add(10,20,30);
		float three=add(10.3f,13.3f);
		System.out.println("result of add(int x,int y):"+ one);
		System.out.println("result of add(int x,int y,int z):"+ two);
		System.out.println("result of add(float x,flota y):"+ three);
	}
	public static int add(int x,int y){
		int temp=0;
		temp=x+y;
		return temp;
	}
	public static int add(int x,int y,int z){
		int temp=0;
		temp=x+y+z;
		return temp;
	}
	public static float add(float x,float y){
		float temp=0;
		temp=x+y;
		return temp;
	}

}
