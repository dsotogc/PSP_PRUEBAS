package ej_pag49;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 6000;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Conectado al servidor");

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            Scanner teclado = new Scanner(System.in);

            String respuestaServidor;
            String opcion;

            while (true) {
                respuestaServidor = entrada.readUTF();
                System.out.println(respuestaServidor);

                opcion = teclado.nextLine();
                
                salida.writeUTF(opcion);

                if (opcion.equalsIgnoreCase("salir")) {
                    respuestaServidor = entrada.readUTF();
                    System.out.println(respuestaServidor);
                    break;
                }

                respuestaServidor = entrada.readUTF();
                System.out.println(respuestaServidor);
            }

            teclado.close();
            entrada.close();
            salida.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}