package ejemplo_laraUDP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_ClienteObjeto {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
			
		// El cliente envía al servidor un mensaje introducido por teclado y el servidor devuelve el mensaje
		// añadiendo "recibido por el servidor"
				
		
		// Creamos el socket cliente
		DatagramSocket clienteSocket = new DatagramSocket();
		
		byte[] enviado = null;
		
		Brawler meeple =new Brawler("Meeple",1,10);
		
		// Envío objeto
		ByteArrayOutputStream bArrayOut =new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bArrayOut);
		out.writeObject(meeple);
		out.close();
		enviado = bArrayOut.toByteArray();
		
		// Obtener IP servidor
		InetAddress IPServidor = InetAddress.getLocalHost();
		int puertoServidor = 6780;		 
			
		// Creamos el paquete a enviar al servidor
		DatagramPacket paquete_enviar = new DatagramPacket(enviado, enviado.length, IPServidor, puertoServidor );
		clienteSocket.send(paquete_enviar);
		
		System.out.println("PAQUETE ENVIADO AL SERVIDOR");
		System.out.println("Objeto: "+ meeple.getClass() 
					+ " Nombre: " + meeple.getNombre() 
					+ ", Nivel: " + meeple.getNivel()
					+ " y Coronas: " + meeple.getCoronas());	
			
		// Cerrar stream y socket
		bArrayOut.close();
		clienteSocket.close();
		
	}

}
