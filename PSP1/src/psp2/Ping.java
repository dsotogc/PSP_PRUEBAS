package psp2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ping {
	
	public static void main(String[] args) {
		BufferedReader buffer= null;
		String linea = "";
		
		InputStreamReader input= new InputStreamReader(System.in);
		try {
			buffer = new BufferedReader(input);
			System.out.println("Introduce el dominio al que quieres hacer ping:");
			linea = buffer.readLine();
			System.out.print(linea);
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping", linea);
			Process p = pb.start();
			
			InputStream salidaComando = p.getInputStream();
			BufferedReader buffer2 = new BufferedReader(new InputStreamReader (salidaComando));
			linea = buffer2.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = buffer2.readLine();
			}
			buffer2.close();
			buffer.close();
		}catch (Exception e) {
			System.out.println("Error en: " );
			e.printStackTrace();
	
		}
	}
}
