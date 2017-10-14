package exercises;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class E_1_3_4
{
	private static char[] Left = { '(', '[', '{' };
	private static char[] Right = { ')', ']', '}' };
	private static boolean parentheses = false;

	public static void main(String[] args)
	{
		// char的包装类为Character.
		// 2017.3.27: Maybe we can use three stacks.
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();

		while (!StdIn.isEmpty())
		{
			char temp = StdIn.readChar();
			if (isLeft(temp))
			{
				left.push(temp);
			} else if (isRight(temp))
			{
				right.push(temp);
				char leftC = left.pop();
				char rightC = right.pop();
				if (leftC == '(' && rightC == ')' || leftC == '{' && rightC == '}' || leftC == '[' && rightC == ']')
					parentheses = true;
			}

			else
			{
				System.out.println("Error");
				break;
			}
		}

		System.out.println(parentheses);

	}

	public static boolean isLeft(char temp)
	{
		for (int i = 0; i < Left.length; i++)
			if (Left[i] == temp)
				return true;
		return false;
	}

	public static boolean isRight(char temp)
	{
		for (int i = 0; i < Right.length; i++)
			if (Right[i] == temp)
				return true;
		return false;
	}

}
