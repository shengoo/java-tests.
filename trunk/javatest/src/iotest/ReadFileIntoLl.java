package iotest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;

public class ReadFileIntoLl {

	/**
	 * @param args
	 * @throws Exception 
	 * 	（1）     String的使用
	 *	（2）     Java文件的输入输出
	 *	（3）     LinkedList的使用
	 *	要求：
	 *	编写一个Java应用程序，开启一个文本文件（以本程序源文件为例读取），
	 *	一次读取其内的一行文本，令每行形成一个String，
	 *	并将读出的String对象置于LinkedList中，以相反次序显示出LinkedList内的所有内容
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:/Development/workspace/Eclipse3.5/JavaTest/src/iotest/ReadFileIntoLl.java");//change to your file path.
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		LinkedList<String> list = new LinkedList<String>();
		String line;
		while((line = br.readLine()) !=null){
			list.add(line);
		}
		Iterator<String> iterator = list.descendingIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
