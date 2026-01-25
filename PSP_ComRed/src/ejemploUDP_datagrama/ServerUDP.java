package ejemploUDP_datagrama;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {
	
	public static void main(String[] args)
	{
		byte[] buffer = new byte[1024];
		
		try {
			DatagramSocket socket = new DatagramSocket(12345); //12345 es el puerto
			
			System.out.println("Esperando datagrama... " + socket);
			DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
			
			socket.receive(recibo); //datagrama
			int bytesRec = recibo.getLength(); //numero de bytes
			String paquete = new String(recibo.getData()); //String
			
			System.out.println("Número de bytes recibidos: " + bytesRec);
			System.out.println("Contenido del paquete: " + paquete.trim());
			System.out.println("Puerto origen del mensaje: " + recibo.getPort());
			System.out.println("IP del origen: " + recibo.getAddress().getHostAddress());
			System.out.println("Puerto destino del mensaje: " + socket.getLocalPort());
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
