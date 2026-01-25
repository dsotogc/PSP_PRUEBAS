package ejemploUDP_datagrama;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClienteUDP {
	
	public static void main(String[] args)
	{
		try {
			InetAddress destino = InetAddress.getLocalHost();
			int port = 12345;
			String saludo = "Enviando Saludos !!";
			byte[] mensaje = saludo.getBytes();
			
			DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
			DatagramSocket socket = new DatagramSocket(34567); //Puerto local
			
			System.out.println("Enviando datagrama de longitud: " + mensaje.length);
			System.out.println("Host destino: " + destino.getHostName());
			System.out.println("IP destino: " + destino.getHostAddress());
			System.out.println("Puerto local del socket: " + socket.getLocalPort());
			System.out.println("Puerto al que envio: " + envio.getPort());
			
			socket.send(envio);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
