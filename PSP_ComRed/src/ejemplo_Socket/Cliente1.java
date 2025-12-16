package ejemplo_Socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente1 {

	public static void main(String[] args) {

		String host = "localhost";
		//String Host = "10.203.9.47";
		int puerto = 6000;
		OutputStream salida = null;
		InputStream entrada = null;
		
		try {
			System.out.println("Programa cliente iniciado...");
			Socket cliente = new Socket(host, puerto);
			entrada = cliente.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);
			System.out.println("Servidor dice al cliente: \n" + flujoEntrada.readUTF());
			
			flujoEntrada.close();
			salida.close();
			entrada.close();
			cliente.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
