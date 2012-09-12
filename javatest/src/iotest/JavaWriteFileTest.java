package iotest;

import java.io.BufferedOutputStream;   
import java.io.File;   
import java.io.FileOutputStream;   
import java.io.FileWriter;   
import java.nio.ByteBuffer;   
import java.nio.channels.FileChannel;   
public class JavaWriteFileTest {
	public static void main(String[] args) {   
	    FileOutputStream out = null;   
	    FileOutputStream outSTr = null;   
	    BufferedOutputStream Buff = null;   
	    FileWriter fw = null;   
	    int count = 1000000;// д�ļ�����   
	    try {   
	      byte[] bs = "����java �ļ�����\r\n".getBytes();   
	      out = new FileOutputStream(new File("C:/add.txt"));   
	      long begin = System.currentTimeMillis();   
	      for (int i = 0; i < count; i++) {   
	        out.write(bs);   
	      }   
	      out.close();   
	      long end = System.currentTimeMillis();   
	      System.out.println("FileOutputStreamִ�к�ʱ:" + (end - begin) + " ����");   
	  
	      outSTr = new FileOutputStream(new File("C:/add0.txt"));   
	      Buff = new BufferedOutputStream(outSTr);   
	      long begin0 = System.currentTimeMillis();   
	      for (int i = 0; i < count; i++) {   
	        Buff.write(bs);   
	      }   
	      Buff.flush();   
	      Buff.close();   
	      long end0 = System.currentTimeMillis();   
	      System.out.println("BufferedOutputStreamִ�к�ʱ:" + (end0 - begin0) + " ����");   
	  
	      fw = new FileWriter("C:/add2.txt");   
	      long begin3 = System.currentTimeMillis();   
	      for (int i = 0; i < count; i++) {   
	        fw.write("����java �ļ�����\r\n");   
	      }   
	      fw.flush();   
	      fw.close();   
	      long end3 = System.currentTimeMillis();   
	      System.out.println("FileWriterִ�к�ʱ:" + (end3 - begin3) + " ����");   
	  
	      long begin4 = System.currentTimeMillis();   
	      String path = "C:/add3.txt";   
	      ByteBuffer bb = ByteBuffer.wrap(bs);   
	      FileChannel out2 = new FileOutputStream(path).getChannel();   
	      for (int i = 0; i < count; i++) {   
	        out2.write(bb);   
	        bb.rewind();   
	      }   
	  
	      out2.close();   
	      long end4 = System.currentTimeMillis();   
	      System.out.println("FileChannelִ�к�ʱ:" + (end4 - begin4) + " ����");   
	    } catch (Exception e) {   
	      e.printStackTrace();   
	    } finally {   
	      try {   
	        fw.close();   
	        Buff.close();   
	        outSTr.close();   
	        out.close();   
	      } catch (Exception e) {   
	        e.printStackTrace();   
	      }   
	    }   
	}
}
