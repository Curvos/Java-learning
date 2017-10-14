package examples;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Eg_19_4 {

	public static void main(String[] args)throws Exception {
		String keyWord = "Ë¹¿¨¹þ Queen";
		String encod   =   URLEncoder.encode(keyWord, "UTF-8");
		System.out.println("Encoded content:"+encod);
		String decod   =   URLDecoder.decode(encod, "UTF-8");
		System.out.println("Decoded content:"+decod);
		
	}

}
