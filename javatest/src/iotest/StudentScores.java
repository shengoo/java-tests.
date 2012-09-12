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
 *（1）从键盘输入学生姓名、学号、成绩，并保存到文本文件中，重复进行直到遇到空字符为之。
 *（2）从文件读取各学生成绩，并计算所有学生成绩的平均值、最大、最小值。
 *
 */
public class StudentScores {
	
	static List<Student> students = new ArrayList<Student>();//列表，存放student
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//控制台输入
	static FileOutputStream fos;//文件输出流
	static BufferedOutputStream bos;//
	static File f = new File("Students");//读写的文件
	static BufferedReader br;
	static FileReader fr;
	
	public static void main(String[] args) throws Exception {
		System.out.println("输入\"1\"开始记录学生信息，输入\"2\"开始读取学生信息.");
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
		System.out.println("最低分:" + low + "最高分：" + high + "平均分：" + ava);
	}
	
	static void RecordStudentScores() throws Exception{
		String s;
		System.out.println("");
		while(true){
			Student stu = new Student();
			System.out.print("姓名（输入空格结束）:");
			s = in.readLine().trim();
			if(s.isEmpty())
				break;
			stu.setName(s);
			System.out.print("学号（输入空格结束）:");
			s = in.readLine().trim();
			if(s.isEmpty())
				break;
			stu.setNumber(s);
			System.out.print("分数（输入空格结束）:");
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
		System.out.println("文件输出至：" + f.getAbsolutePath());
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
