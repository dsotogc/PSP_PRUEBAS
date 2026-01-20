package ejemplo_laraUDP;

import java.io.*;
import java.net.*;


public class UDP_ServidorObjeto {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		DatagramSocket servidorSocket = new DatagramSocket(6780);
		
		byte[] recibidos = new byte[1024];
		
		System.out.println("Esperando datagrama...");
		// Crear paquete para recibir el mensaje
		DatagramPacket paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
		servidorSocket.receive(paqueteRecibido);
			
		// Convertimos Bytes a objeto
		ByteArrayInputStream bArrayIn = new ByteArrayInputStream(recibidos);
		ObjectInputStream in= new ObjectInputStream(bArrayIn);
		Brawler meeple = (Brawler) in.readObject();
		in.close();
			
		System.out.println("PAQUETE RECIBIDO");
		System.out.println("Objeto: "+ meeple.getClass().getName() + " Nombre: " + meeple.getNombre()
			+ ", Nivel: " + meeple.getNivel() + " y Coronas: " + meeple.getCoronas());
		
		bArrayIn.close();
		servidorSocket.close();
	}

}
