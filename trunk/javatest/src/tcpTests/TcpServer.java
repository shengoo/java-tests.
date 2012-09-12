package tcpTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Qing
 *
 */

public class TcpServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(5050);  
        
        Socket socket  = serverSocket.accept();  
  
        InputStream in = socket.getInputStream();  
        OutputStream out = socket.getOutputStream();  
  
        //int radius = in.read(); 
        //System.out.println(" ’µΩ:" + radius);  
        
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));  
        System.out.println(bufferedReader.readLine());
  
        //byte[] result = caculate(radius);
        //out.write(result);
        //System.out.println("∑¢ÀÕ:" + new String(result));
          
        bufferedReader.close();
        out.close();  
        in.close();  
        socket.close();  
        serverSocket.close();
	}
	
	static byte[] caculate(int ra){
		double result = (ra*ra*Math.PI);
		return Double.toString(result).getBytes();
	}

}
