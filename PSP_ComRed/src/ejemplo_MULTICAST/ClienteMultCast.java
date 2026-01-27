package ejemplo_MULTICAST;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMultCast {

	public static void main(String[] args) {
		
		MulticastSocket multicast;
		try {
			// Se configura el puerto donde escucharemos:
			multicast = new MulticastSocket(12345);
			int puerto = 12345;
			String host = "225.0.0.1";
			
			// Se une al grupo multicast:
			multicast.joinGroup(InetAddress.getByName(host));
			
			// Recibe el paquete del servidor multicast:
			byte[] bufer = new byte[1000];
			DatagramPacket recibido = new DatagramPacket(bufer, bufer.length);
			multicast.receive(recibido);
			
			// Se muestra por pantalla el contenido del paquete recibido:
			String texto = new String(recibido.getData(), 0, recibido.getLength());
			System.out.println("Mensaje recibido: " + texto);
			
			// Salimos del grupo multicast
			multicast.leaveGroup(InetAddress.getByName(host));
			
			// Se cierra el socket:
			multicast.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
