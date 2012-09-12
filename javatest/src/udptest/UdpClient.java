package udptest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int serverPort = 2345;
		int clientPort = 2346;
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket datagramSocket = new DatagramSocket(clientPort);
		while (true) {

			System.out.println("输入半径：");
			Scanner sio = new Scanner(System.in);
			int radius = sio.nextInt();
			if (radius < 0) {
				System.out.println("输入错误");
				continue;
			}
			

			DatagramPacket dataPack = new DatagramPacket(Integer.toString(
					radius).getBytes(), Integer.toString(radius).length(),
					InetAddress.getByName("127.0.0.1"), new Integer(serverPort));
			sendSocket.send(dataPack);
			System.out.println("Client发送:\t" + radius);

			byte[] buffer = new byte[2048];
			DatagramPacket datagramPacket = new DatagramPacket(buffer,
					buffer.length);
				datagramSocket.receive(datagramPacket);
				System.out.println("Client收到:\t"
						+ new String(datagramPacket.getData()).trim());
		}
	}

}
