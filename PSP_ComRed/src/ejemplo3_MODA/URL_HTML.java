package ejemplo3_MODA;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class URL_HTML {

	public static void main(String[] args) {
		
		try {
			String linea = "";
			URL url = URI.create("https://www.lamaravillosaorquestadelalcohol.com/").toURL();
			
			InputStream urlStream = url.openStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(urlStream));
			linea = buffer.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = buffer.readLine();
			}
			buffer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
