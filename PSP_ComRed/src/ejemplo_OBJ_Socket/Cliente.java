package ejemplo_OBJ_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente implements Serializable{

	public static void main(String[] args) {
		
		String host = "localhost";
		int puerto = 6060;
		OutputStream salida = null;
		InputStream entrada = null;
		
		try {
			System.out.println("Programa cliente iniciado...");
			Socket cliente = new Socket(host, puerto);
			
			entrada = cliente.getInputStream();
			salida = cliente.getOutputStream();
			
			ObjectOutputStream outObjeto = new ObjectOutputStream(salida);
			ObjectInputStream inObjeto = new ObjectInputStream(entrada);
			
			String persona_servidor = (String) inObjeto.readObject();
			System.out.println(persona_servidor);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
