package ejercicio42;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		int numeroPuerto = 6000;
		Socket clienteConectado = null;
		InputStream entrada = null;
		OutputStream salida = null;
		String preguntaClave = "¿Cuál es el sentido de la vida, del universo y de todo lo demás?";
		
		try {
			ServerSocket servidor = new ServerSocket(numeroPuerto);
			
			System.out.println("Esperando al cliente...");
			clienteConectado = servidor.accept();
			
			System.out.println("Conexión establecida" + clienteConectado);
			
			entrada = clienteConectado.getInputStream();
			salida = clienteConectado.getOutputStream();
			
			DataInputStream flujoEntrada = new DataInputStream(entrada);
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			
			String preguntaCliente = flujoEntrada.readUTF().trim();
			
			System.out.println(preguntaCliente);
			
			if (preguntaCliente.equals(preguntaClave))
				flujoSalida.writeUTF("42");
			else
				flujoSalida.writeUTF("No has hecho la pregunta correcta");
			
			flujoSalida.close();
			flujoEntrada.close();
			entrada.close();
			salida.close();
			clienteConectado.close();
			servidor.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
