package examples;

class Person0{
	private String name;
	private int age;
	public Person0(String name,int age){
		this.setName(name);
		this.setAge(age);
	}
	public boolean compare(Person0 per){
		Person0 p1=this;
		Person0 p2=per;
		if(p1==p2){
			return true;
		}
		if(p1.name.equals(p2.name)&&p1.age==p2.age){
			return true;
		}else{
			return false;
		}
	}
	public String getName(){
		return name;
	}
	public  void setName(String n){
		name=n;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int a){
		age=a;
	}
}

public class Eg5_48 {

	public static void main(String[] args) {
		Person0 per1=new Person0("Z",30);
		Person0 per2=new Person0("y",27);
		if(per1.compare(per2)){
			System.out.println("Same");
		}else{
			System.out.println("Different");
		}
		
		

	}

}
