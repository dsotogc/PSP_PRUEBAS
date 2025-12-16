package ejercicio42;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		String host = "localhost";
		int puerto = 6000;
		OutputStream salida = null;
		InputStream entrada = null;
		String preguntaClave = "¿Cuál es el sentido de la vida, del universo y de todo lo demás?";
		
		try {
			System.out.println("Programa cliente iniciado...");
			Socket cliente = new Socket(host, puerto);
			
			entrada = cliente.getInputStream();
			salida = cliente.getOutputStream();
			
			DataInputStream flujoEntrada = new DataInputStream(entrada);
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			
			flujoSalida.writeUTF(preguntaClave);
			System.out.println("La respuesta del servidor ha sido: " + flujoEntrada.readUTF());
			
			flujoEntrada.close();
			flujoSalida.close();
			salida.close();
			entrada.close();
			cliente.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
