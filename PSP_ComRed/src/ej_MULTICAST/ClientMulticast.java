package ej_MULTICAST;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class ClientMulticast {

    public static void main(String[] args) {
        try {
            String host = "225.0.0.1";
            int puerto = 12345;

            MulticastSocket socket = new MulticastSocket(puerto);
            InetAddress grupo = InetAddress.getByName(host);
            socket.joinGroup(grupo);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength(), StandardCharsets.UTF_8);
                System.out.println(mensaje);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

