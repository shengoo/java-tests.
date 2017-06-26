package tcpTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10086);
		
		while (true) {
			System.out.println("Listening....");
			Socket socket = serverSocket.accept();
			System.out.println("accept....");
			InputStream inputStream = socket.getInputStream();
			System.out.println("getInputStream....");
			OutputStream outputStream = socket.getOutputStream();
			System.out.println("getOutputStream....");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			System.out.println("BufferedReader....");
			while(true){
				String inputStr = bufferedReader.readLine();
				System.out.println("readLine....");
				System.out.println("input:" + inputStr);
				if (inputStr.equalsIgnoreCase("quit")){
					System.out.println("Server will close.");
					bufferedReader.close();
					outputStream.close();
					socket.close();
					serverSocket.close();
					return;
				}
				else {
					System.out.println("output:welcome!" + inputStr);
					outputStream.write(("welcome!" + inputStr).getBytes());
				}
			}
		}
	}

}
