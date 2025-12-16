package ejemplo_Socket;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) {
		
		int numeroPuerto = 6000;
		Socket clienteConectado = null;
		InputStream entrada = null;
		OutputStream salida = null;
		
		try {
			ServerSocket servidor = new ServerSocket(numeroPuerto);
			
			System.out.println("Esperando al cliente...");
			clienteConectado = servidor.accept();
			
			System.out.println("Conexión establecida" + clienteConectado);
			
			salida = clienteConectado.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			flujoSalida.writeUTF("Flujo de salida desde el servidor, buenos dias.");
			
			flujoSalida.close();
			entrada.close();
			salida.close();
			clienteConectado.close();
			servidor.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
