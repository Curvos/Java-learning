package examples;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Eg_19_2 {

	public static void main(String[] args)throws Exception {
		URL url = new URL("http","www.mldnjava.cn",80,"/curriculum.htm");
		InputStream input = url.openStream();
		Scanner scan = new Scanner(input);
		scan.useDelimiter("\n");
		while(scan.hasNext())
		{
			System.out.println(scan.next());
		}
	}

}
