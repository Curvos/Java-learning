package pack;

public class Login
{
	public static boolean Log(String user, String password)
	{
		if (user.equals(DataBase.user) && password.equals(DataBase.password))
			return true;
		return false;
	}
}
