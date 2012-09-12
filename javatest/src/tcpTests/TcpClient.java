package tcpTests;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1" , 5050);  
		  
        InputStream in = client.getInputStream();  
        OutputStream out = client.getOutputStream();  
          
        out.write(3);  
  
        byte[] b = new byte[20];
        in.read(b);
        System.out.println(" ’µΩ:" + new String(b));  
  
        out.close();  
        in.close();  
        client.close(); 
	}

}
