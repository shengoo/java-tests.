package iotest;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Qing
 *
 *��1���Ӽ�������ѧ��������ѧ�š��ɼ��������浽�ı��ļ��У��ظ�����ֱ���������ַ�Ϊ֮��
 *��2�����ļ���ȡ��ѧ���ɼ�������������ѧ���ɼ���ƽ��ֵ�������Сֵ��
 *
 */
public class StudentScores {
	
	static List<Student> students = new ArrayList<Student>();//�б����student
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//����̨����
	static FileOutputStream fos;//�ļ������
	static BufferedOutputStream bos;//
	static File f = new File("Students");//��д���ļ�
	static BufferedReader br;
	static FileReader fr;
	
	public static void main(String[] args) throws Exception {
		System.out.println("����\"1\"��ʼ��¼ѧ����Ϣ������\"2\"��ʼ��ȡѧ����Ϣ.");
		String s = in.readLine();
		if(s.equals("1"))
			RecordStudentScores();
		else
			ReadStudentScores();
	}
	
	static void ReadStudentScores() throws Exception{
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) !=null){
			String[] splits = line.split(" ");
			Student stu = new Student();
			stu.setName(splits[0]);
			stu.setNumber(splits[1]);
			stu.setScore(Integer.parseInt(splits[2]));
			students.add(stu);
		}
		OutPutStudentsInConsole();
	}
	
	static void OutPutStudentsInConsole(){
		int high = 0;
		int low = 0;
		int ava = 0;
		int all = 0;
		for (int i = 0; i<students.size(); i++){
			Student stu = students.get(i);
			int score = stu.getScore();
			if(low == 0)
				low = score;
			if(high == 0)
				high = score;
			if(score<low)
				low = score;
			if(score>high)
				high = score;
			all += score;
			System.out.println(stu.getName() + " " + stu.getNumber() + " " + stu.getScore());
		}
		ava = all/students.size();
		System.out.println("��ͷ�:" + low + "��߷֣�" + high + "ƽ���֣�" + ava);
	}
	
	static void RecordStudentScores() throws Exception{
		String s;
		System.out.println("");
		while(true){
			Student stu = new Student();
			System.out.print("����������ո������:");
			s = in.readLine().trim();
			if(s.isEmpty())
				break;
			stu.setName(s);
			System.out.print("ѧ�ţ�����ո������:");
			s = in.readLine().trim();
			if(s.isEmpty())
				break;
			stu.setNumber(s);
			System.out.print("����������ո������:");
			s = in.readLine().trim();
			if(s.isEmpty())
				break;
			stu.setScore(Integer.parseInt(s));
			students.add(stu);
		}
		WriteToFile();
	}
	
	static void WriteToFile() throws Exception{
		fos = new FileOutputStream(f, true);
		bos = new BufferedOutputStream(fos);
		for(int i = 0; i<students.size(); i++){
			Student stu = students.get(i);
			String str = stu.getName() + " " + stu.getNumber() + " " + stu.getScore() + "\n";
			byte[] content = str.getBytes();
			bos.write(content);
		}
		bos.flush();
		bos.close();
		fos.close();
		System.out.println("�ļ��������" + f.getAbsolutePath());
	}

}

class Student{
	private String name;
	private String number;
	private int score;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}
