package examples;
//在外部访问内部类
class Outer{
	private String info="Hello World";
	class Inner{
		public void print(){
			System.out.println(info);
		}
	};
};

public class Eg5_69 {

	public static void main(String[] args) {
		Outer out=new Outer();
		Outer.Inner in=out.new Inner();
		in.print();

	}

}
