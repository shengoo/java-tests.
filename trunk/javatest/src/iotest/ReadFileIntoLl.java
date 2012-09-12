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
	 * 	��1��     String��ʹ��
	 *	��2��     Java�ļ����������
	 *	��3��     LinkedList��ʹ��
	 *	Ҫ��
	 *	��дһ��JavaӦ�ó��򣬿���һ���ı��ļ����Ա�����Դ�ļ�Ϊ����ȡ����
	 *	һ�ζ�ȡ���ڵ�һ���ı�����ÿ���γ�һ��String��
	 *	����������String��������LinkedList�У����෴������ʾ��LinkedList�ڵ���������
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
