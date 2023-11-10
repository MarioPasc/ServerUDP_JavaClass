/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 *
 * @author pinilla
 */
public class ServerUDP {
	public static void main(String[] args) throws IOException {
		DatagramSocket server = null;
		byte[] byte_echomax = new byte[255];
		byte[] sendData;
		String line;
		int port = 54322; // puerto del servidor
		
		
		try {
			/*
			 * COMPLETAR Crear e inicalizar el socket del servidor
			 */
			server = new DatagramSocket(port);
		} catch (IOException e) {
			System.out.println("Could not listen on port " + port);
			System.exit(-1);
		}

		while (true) // funcion PRINCIPAL del servidor:
		{
			System.out.println("Waiting for a new UDP client");

			/* COMPLETAR Crear e inicializar un datagrama VACIO para recibir */
			DatagramPacket packet_in = new DatagramPacket(byte_echomax, byte_echomax.length);

			/* COMPLETAR Recibir datagrama */
			server.receive(packet_in);

			/*
			 * COMPLETAR Mostrar por pantalla la direccion socket del cliente que solicito
			 * el servicio de eco
			 */
			InetAddress clientAddress = packet_in.getAddress();
			int clientPort = packet_in.getPort();

			System.out.println("Client adress: " + clientAddress + "\nClient Port: " + clientPort);

			/*
			 * COMPLETAR revertir y poner en mayúscula la cadena y Crear datagrama de
			 * respuesta
			 */
			String receivedSentence = new String(packet_in.getData(), 0, packet_in.getLength());
            String capitalizedSentence = new StringBuilder(receivedSentence).reverse().toString().toUpperCase();
            
			/* COMPLETAR Enviar datagrama de respuesta */
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            server.send(sendPacket);
			/**/

            System.out.println("STATUS: Echo sent to " + clientAddress.getHostAddress() + ":" + clientPort);
            System.out.println("STATUS: Waiting for new echo");

		} // fin del bucle del servicio de Echo

	}

}
