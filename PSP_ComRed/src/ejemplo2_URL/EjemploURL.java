package ejemplo2_URL;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class EjemploURL {

	public static void main(String[] args) {
		
		try {
			System.out.println("Constructor simple para URL:");
			URL url = URI.create("https://aulavirtual.educa.jcyl.es/cifpjuandecolonia/course/view.php?id=1128").toURL();
			
			System.out.printf("\tURL completa: %s\n", url.toString());
			System.out.printf("\tgetProtocol(): %s\n", url.getProtocol());
			System.out.printf("\tgetHost(): %s\n", url.getHost());
			System.out.printf("\tgetDefaultPort(): %s\n", url.getDefaultPort());
			System.out.printf("\tgetFile(): %s\n", url.getFile());
			System.out.printf("\tgetUserInfo(): %s\n", url.getUserInfo());
			System.out.printf("\tgetPath(): %s\n", url.getPath());
			System.out.printf("\tgetAuthority(): %s\n", url.getAuthority());
			System.out.printf("\tgetQuery(): %s\n", url.getQuery());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
