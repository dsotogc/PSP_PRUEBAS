package ej_pag49;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HiloCliente implements Runnable{
	
	private Socket clientSocket;
	
	public HiloCliente(Socket s)
	{
		this.clientSocket = s;
	}
	
	public void run()
	{
		try {
			DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());
			
			String strcliente = null;
			
			while (true)
			{
				salida.writeUTF("Elige una opción (fecha/hora/salir)");
				strcliente = entrada.readUTF();
				
				if (strcliente == null || strcliente.equals("salir"))
				{
					salida.writeUTF("Cerrando conexión...");
					System.out.printf("Se cerró la conexión con el cliente: %s\n", clientSocket);
					break;
				}
				
				if (strcliente.equals("fecha"))
				{
					Date fecha = new Date();
					salida.writeUTF("Fecha: " + fecha.toString());
				}
				else if (strcliente.equals("hora"))
				{
					SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
					salida.writeUTF("Hora: " + formatoHora.format(new Date()));
				}
				else
					salida.writeUTF("Opción no valida, escriba una de estas (fecha|hora|salir)");
			}
			
			entrada.close();
			salida.close();
			clientSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
