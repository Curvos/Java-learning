package w04;

import java.io.File;
import java.io.IOException;

public class Delegate
{

	public static void main(String[] args) throws IOException
	{
		File f = new File("res" + File.separator + "sample_d.txt");
		Filter Genes = new Filter();
		char[] r;
		r = Genes.Filt(f);

		/*
		 * char[] a; a = Genes.Filt(f); for (int i = 0; i < Genes.getCont();
		 * i++) { System.out.print(a[i]); }
		 */
		// InputStream in = new FileInputStream(f);
		// InputStreamReader inRead = new InputStreamReader(in);
		// Reader reader = new FileReader(f);
		// String s = "";
		// String temp;
		// char[] c = new char[1024];
		// int len = (int) f.length();
		// System.out.println(len);
		// char[] a = new char[len];
		// int temp = 0;
		// int len = 0;
		/*
		 * for (int i = 0; (temp = reader.read()) != -1; i++) { temp =
		 * reader.read(); a[i] = (char) temp; System.out.print(a[i]); }
		 */

		// a = (char) reader.read();
		// c[len] = (char) a;
		// len++;

		/*
		 * for (int i = 0; i < 300; i++) { a = (char) inRead.read(); s = s + a;
		 * }
		 */
		// reader.close();
		// a = (char) inRead.read();
		// a = (char) inRead.read();
		// a = (char) inRead.read();
		// System.out.println("原基因字符串:");
		// System.out.println(new String(c, 0, len));
		// System.out.println(s);

	}
}
