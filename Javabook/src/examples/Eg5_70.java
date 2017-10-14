package examples;

class Outer0{
	private String info="Hello World";
	public void fun(final int temp){
		class Inner{
			public void print(){
				System.out.println("properties in class: "+info);
				System.out.println("parameters in method: "+temp);
			}
		};
		new Inner().print();
	}
};

public class Eg5_70 {
	public static void main(String[] args) {
		new Outer0().fun(30);
	}
}

