package ej_MULTICAST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class ServerMulticast {

    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String host = "225.0.0.1";
            int puerto = 12345;
            InetAddress grupo = InetAddress.getByName(host);

            while (true) {
                String linea = br.readLine();
                if (linea == null || linea.trim().equals("*")) {
                    break;
                }

                byte[] datos = linea.getBytes(StandardCharsets.UTF_8);
                DatagramPacket paquete = new DatagramPacket(datos, datos.length, grupo, puerto);
                socket.send(paquete);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

