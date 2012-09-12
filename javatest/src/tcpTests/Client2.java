package tcpTests;
import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.InetAddress;  
import java.net.Socket; 

public class Client2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try  
	    {  
	        Socket s=new Socket("192.168.0.254",8080);  
//	        if(args.length < 2)  
//	        {  
//	            System.out.println("Usage:java TcpClient ServerIP ServerPort");  
//	            return;  
//	        }  
	        //½¨Á¢Socket  
//	        Socket s=new Socket(InetAddress.getByName(args[0]),Integer.parseInt(args[1]));  
	        InputStream ips=s.getInputStream();  
	        OutputStream ops=s.getOutputStream();  
	          
	        BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));//¼üÅÌÊäÈë  
	        DataOutputStream dos = new DataOutputStream(ops);  
	        BufferedReader brNet = new BufferedReader(new InputStreamReader(ips));  
	  
	        while(true)  
	        {  
	            String strWord = brKey.readLine();  
	            dos.writeBytes(strWord + System.getProperty("line.separator"));  
	            if(strWord.equalsIgnoreCase("quit"))  
	                break;  
	            else  
	                System.out.println(brNet.readLine());  
	        }  
	        dos.close();  
	        brNet.close();  
	        brKey.close();  
	        s.close();  
	    }catch(Exception e){e.printStackTrace();}  
	    }  

}
