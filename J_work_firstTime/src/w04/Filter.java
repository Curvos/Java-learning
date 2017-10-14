package w04;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Filter
{
	private String s;
	private int temp = 0;
	private int flag = 0;
	private int cont = 0;
	private int newline = 0;
	private Reader reader;

	/*
	 * public Filter(Reader reader) { this.reader = reader; }
	 */

	public char[] Filt(File f) throws IOException
	{
		Reader reader = new FileReader(f);
		char[] out = new char[(int) f.length()];
		for (int i = 0; (temp = reader.read()) != -1; i++)
		{
			if ((char) temp == '>')
			{
				flag = 1;
				newline++;
			}

			if (flag == 1)
			{
				out[cont++] = (char) temp;
				newline++;
				// if ((s = String.valueOf(out[cont])).equals("\r\n"))
				if (newline == 7)
				{
					flag = 0;
				}
			}

			if (flag == 0)
			{
				if (isGenes(temp))
					out[cont++] = (char) temp;
			}

			/*
			 * if (flag == 1 && (char) temp == ' ') {
			 * 
			 * }
			 */

		}
		reader.close();

		return out;
	}

	public boolean isGenes(int temp)
	{
		char[] t = { 'A', 'G', 'C', 'T' };
		for (int i = 0; i < t.length; i++)
			if ((char) temp == t[i])
				return true;
		return false;
	}

	public int getCont()
	{
		return cont;
	}
	/*
	 * public String Filt(InputStreamReader in) throws IOException { while
	 * (in.read() != -1) { a = (char) in.read(); s = s + a; } return s; }
	 */
}
