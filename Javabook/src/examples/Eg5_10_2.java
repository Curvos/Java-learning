package examples;

class Person{
	private String name;
	private int age;
	private static String country="city A";
	public static void setCountry(String c){
		country=c;
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void info(){
		System.out.println("Name:"+this.name+" Age:"+this.age+" City:"+country);
	}
	public static String getCountry(){
		return country;
	}
}


public class Eg5_10_2 {

	public static void main(String[] args) {
		Person p1=new Person("Z",29);
		Person p2=new Person("H",14);
		Person p3=new Person("Y",19);
		Person.setCountry("B");
		p1.info();
		p2.info();
		p3.info();
		
	}

}
