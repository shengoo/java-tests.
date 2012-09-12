package iotest;

import java.io.*;

public class e {
	public static void main(String[] args) throws Exception{
	     
	         BufferedReader in=new BufferedReader (new InputStreamReader(System.in));
	         String s;
	         s=in.readLine();
	         while(! s.equals("exit")){
	             System.out.println(s);
	             s=in.readLine();
	         }
	     }
}
