package examples;

class Check{
	public boolean validate(String name,String password){
		if(name.equals("zhy")&&password.equals("java")){
			return true;
		}else{
			return false;
		}
	}
}
class Operate{
	private String info[];
	
	public Operate(String infop[]){
		this.info=info;
	}
	public String login(){
		Check check=new Check();
		this.isExit();
		
		String name=this.info[0];
		String password=this.info[1];
		String str=null;
		if(check.validate(name, password)){
			str="Welcome"+name;
		}else{
			str="Wrong UserName or Password";
		}
		return str;
	}

public void isExit()
{
	if(this.info.length!=2){
		System.out.println("Wrong format,system shuts down!");
		System.out.println("Correct format:java Eg5_71 Username Password");
		System.exit(1);
	}
}

public static class Eg5_71{
	public static void main(String args[]){
		Operate oper=new Operate(args);
		System.out.println(oper.login());
	}
}

}




/*
public class Eg5_15 {

	public static void main(String[] args) {
		if(args.length!=2){
			System.out.println("Wrong fomat.System's shutting down.");
			System.out.println("Acccepted foamt:UserName Password");
			System.exit(1);
		}
		String name=args[0];
		String password=args[1];
		if(name.equals("zhy")&&password.equals("Shadow")){
			System.out.println("Welcome MR. zhy");	
		}else{
			System.out.println("Wrong UserName or Password");
		}
		

	}

}
*/