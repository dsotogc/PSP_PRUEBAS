package ut3_ejemplo1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjemploInetAddress {

	public static void main(String[] args) {
		
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println("SALIDA LOCALHOST:");
			System.out.println(".getLocalHost: "+ localhost);
			System.out.println(".getByName(String host): "+InetAddress.getByName("ED09012096P350"));
			System.out.println("DIRECCIONES IP DE " + localhost.getHostName());
			
			for (int i = 0; i < InetAddress.getAllByName("ED09012096P350").length; i++ )
				System.out.println(InetAddress.getAllByName("ED09012096P350")[i]);
			
			System.out.println(".getHostAddress(): "+localhost.getHostAddress());
			System.out.println(".getHostName(): "+localhost.getHostName());
			System.out.println(". getCanonicalHostName(): "+localhost. getCanonicalHostName());
			
			System.out.println("SALIDA PARA URL:");
			InetAddress google = InetAddress.getByName("www.google.es");
			System.out.printf("\tMetodo getByName(): %s\n", google.toString());
			System.out.printf("\tMetodo getLocalHost(): %s\n", InetAddress.getLocalHost());
			System.out.printf("\tMetodo getHostName(): %s\n", google.getHostName());
			System.out.printf("\tMetodo getHostAddress(): %s\n", google.getHostAddress());
			System.out.printf("\tMetodo getCanonicalHostName(): %s\n", google.getCanonicalHostName());
			System.out.printf("\tDIRECCIONES IP PARA %s\n", google.getHostName());
			for (int i = 0; i < InetAddress.getAllByName("www.google.es").length; i++)
				System.out.printf("\t\t%s\n", InetAddress.getAllByName("www.google.es")[i]);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
