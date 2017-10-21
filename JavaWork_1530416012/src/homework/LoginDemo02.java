

//第二周作业
package homework;

class Check{
	public boolean validate(String name,String password)
	{
		if(name.equals("zhy")&&password.equals("java"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

class Operate{
	private String info[];
	
	public Operate(String info[])
	{
		this.info=info;
	}
	public String login()
	{
		Check check=new Check();
		this.isExit();
		
		String name=this.info[0];
		String password=this.info[1];
		String str=null;
		if(check.validate(name, password))
		{
			str="Welcome"+name;
		}
		else
		{
			str="Wrong UserName or Password";
		}
		return str;
	}

	public void isExit()
	{
		if(this.info.length!=2)
		{
			System.out.println("Wrong format,system shuts down!");
			System.out.println("Correct format:java Eg5_71 Username Password");
			System.exit(1);
		}
	}
}

public class LoginDemo02{
	public static void main(String args[]){
		Operate oper=new Operate(args);
		System.out.println(oper.login());
	}
}

