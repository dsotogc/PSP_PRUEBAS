package ej_pag49;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		int port = 6000;
		Socket clientSocket = null;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Servidor iniciado, esperando clientes...");
			
			while(true)
			{
				clientSocket = serverSocket.accept();
				System.out.printf("Cliente conectado: %s\n", clientSocket);
				
				HiloCliente hiloCliente = new HiloCliente(clientSocket);
				Thread hilo = new Thread(hiloCliente);
				hilo.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
