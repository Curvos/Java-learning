package ver1;

public class Matcher_fixed
{
	private final int LEFT = 0;
	private final int RIGHT = 1;
	private final int OTHER = 2;

	public int verifyFlag(String str)
	{
		if ("(".equals(str) || "[".equals(str) || "{".equals(str) || "/*".equals(str))
			return LEFT;
		else if (")".equals(str) || "]".equals(str) || "}".equals(str) || "*/".equals(str))
			return RIGHT;
		else
			return OTHER;
	}

	public boolean matches(String str1, String str2)
	{
		if(("(".equals(str1) && ")".equals(str2))
				|| ("[".equals(str1) && "]".equals(str2))
				|| ("{".equals(str1) && "}".equals(str2))
				|| ("/*".equals(str1) && "*/".equals(str2)))
			return true;
		else
			return false;
	}

	public boolean isLegal(String str) throws Exception
	{
		if (!"".equals(str) && str != null)
		{
			SqStack S = new SqStack(100);
			int length = str.length();
			for (int i = 0; i < length; i++)
			{
				char c = str.charAt(i);
				String t = String.valueOf(c);
				if (i != length)
				{
					if (('/' == c && '*' == str.charAt(i + 1)) || ('*' == c && '/' == str.charAt(i + 1)))
					{
						t = t.concat(String.valueOf(str.charAt(i + 1)));
						++i;
					}
				}
				if (LEFT == verifyFlag(t))
				{
					S.push(t);
				} else if (RIGHT == verifyFlag(t))
				{
					if (S.isEmpty() || !matches(S.pop().toString(), t))
					{
						// System.out.println("invalid syntax");
						GUI.textField.setText("Invalid JAVA expression!");
						throw new Exception("Invalid JAVA expression!");
					}
				}
			}
			if (!S.isEmpty()){
			//	System.out.println("invalid syntax");
				GUI.textField.setText("Invalid JAVA expression!");
				throw new Exception("Invalid JAVA expression!");
			}
			return true;
		}
		else {
//			System.out.println("nothing inputed");
			GUI.textField.setText("Nothing inputted!");
			throw new Exception("Nothing inputted!");
			
		}
	}
}
