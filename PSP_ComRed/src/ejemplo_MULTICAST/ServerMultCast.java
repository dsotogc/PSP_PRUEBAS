package ejemplo_MULTICAST;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class ServerMultCast {

	public static void main(String[] args) {
		
		try {
			// Se crea el socket multicast para enviar datagramas:
			MulticastSocket multicast = new MulticastSocket();
			System.out.println("Servidor Iniciado...");
			
			int puerto = 12345;
			String host = "225.0.0.1";
			InetAddress grupo = InetAddress.getByName(host);
			
			// Se prepara el mensaje a enviar:
			String mensaje = "Bienvenidos!";
			byte[] datos = mensaje.getBytes(StandardCharsets.UTF_8);
			
			// Se crea el paquete con destino al grupo multicast:
			DatagramPacket paquete = new DatagramPacket(datos, datos.length, grupo, puerto);
			
			// Se envía el paquete al grupo:
			multicast.send(paquete);
			
			// Se cierra el socket:
			multicast.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
