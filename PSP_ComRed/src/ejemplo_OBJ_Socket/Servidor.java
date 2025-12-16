package ejemplo_OBJ_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Serializable {

	public static void main(String[] args) {
		
		int numeroPuerto = 6060;
		Socket clienteConectado = null;
		InputStream entrada = null;
		OutputStream salida = null;
		
		Persona persona1 = new Persona("David", 19);
		
		try {
			ServerSocket servidor = new ServerSocket(numeroPuerto);
			
			System.out.println("Esperando al cliente...");
			clienteConectado = servidor.accept();
			System.out.println("Conexión establecida" + clienteConectado);
			
			entrada = clienteConectado.getInputStream();
			salida = clienteConectado.getOutputStream();
			
			ObjectOutputStream outObjeto = new ObjectOutputStream(salida);
			ObjectInputStream inObjeto = new ObjectInputStream(entrada);
			
			outObjeto.writeObject(persona1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
