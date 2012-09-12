package tcpTests;

import java.io.IOException;
import java.io.InputStream;
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
		ServerSocket listen = new ServerSocket(5050);  
        
        Socket server  = listen.accept();  
  
        InputStream in = server.getInputStream();  
        OutputStream out = server.getOutputStream();  
  
        int radius = in.read(); 
        System.out.println(" ’µΩ:" + radius);  
  
        out.write(caculate(radius));
          
        out.close();  
        in.close();  
        server.close();  
        listen.close();
	}
	
	static byte[] caculate(int ra){
		double result = (ra*ra*Math.PI);
		return Double.toString(result).getBytes();
	}

}
