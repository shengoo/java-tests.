package udptest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int serverPort = 2345;
		int clientPort = 2346;
		String result;
		String raduis;
		DatagramSocket datagramSocket = new DatagramSocket(serverPort);
		for (int i = 0; i < 10; i++) {
			byte[] buffer = new byte[2048];
			DatagramPacket datagramPacket = new DatagramPacket(buffer,
					buffer.length);

			System.out.println("begin");
			datagramSocket.receive(datagramPacket);
			raduis = new String(datagramPacket.getData()).trim();
			System.out.println("ServerÊÕµ½:\t" + raduis);
			result = caculate(raduis);
			DatagramSocket sendSocket = new DatagramSocket();
			DatagramPacket dataPack = new DatagramPacket(result.getBytes(),
					result.length(), 
					datagramPacket.getAddress(),
					clientPort);
			sendSocket.send(dataPack);
			System.out.println("Server·¢ËÍ:\t" + result);
			sendSocket.close();

		}
	}

	static String caculate(String ra) {
		int radius = Integer.parseInt(ra);
		return Double.toString(radius * radius * Math.PI);
	}

}
