package examples;

import java.net.InetAddress;

public class Eg_19_1 {

	public static void main(String[] args)throws Exception {
		InetAddress locAdd = null;
		InetAddress remAdd = null;
		locAdd = InetAddress.getLocalHost();
		//remAdd = InetAddress.getByName("www.mldnjava.cn");
		System.out.println("Local IP:"+locAdd.getHostAddress());
		//System.out.println("Remote IP:"+remAdd.getHostAddress());
		System.out.println("If Local Host can reach:"+locAdd.isReachable(5000));
	}

}
