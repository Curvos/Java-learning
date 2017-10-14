package w04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Delegate
{

	public static void main(String[] args) throws IOException
	{
		File f = new File("res" + File.separator + "dna_data.txt");
		Filter Genes = new Filter();
		String r;
		r = Genes.Filt(f);
		System.out.print(r);

		File o = new File("res" + File.separator + "result.txt");
		Writer out = new FileWriter(o);
		out.write(r);
		out.close();
	}
}