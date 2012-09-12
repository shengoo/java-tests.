package frametest.jframe;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Frame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9;
	JTextField jt1, jt2;

	public Frame() {
		super("窗口");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());
		jl1 = new JLabel("请选择提示语言的种类");

		jb1 = new JButton("普通话");
		jb2 = new JButton("英语");
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		this.getContentPane().add(jl1);
		this.getContentPane().add(jb1);
		this.getContentPane().add(jb2);

		this.setSize(400, 300);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			JFrame f1 = new JFrame("");
			f1.setSize(400, 300);
			f1.getContentPane().setLayout(new FlowLayout());
			jl2 = new JLabel("请选择服务项目");

			jb3 = new JButton("冲值卡冲值");
			jb4 = new JButton("查询余额");
			jb3.addActionListener(this);
			jb4.addActionListener(this);

			f1.getContentPane().add(jl2);
			f1.getContentPane().add(jb3);
			f1.getContentPane().add(jb4);

			f1.setSize(200, 100);
			f1.setVisible(true);
		}

		if (e.getSource() == jb2) {
			JFrame f2 = new JFrame("");
			f2.getContentPane().setLayout(new FlowLayout());
			jl3 = new JLabel("please");

			jb5 = new JButton("chongzhi");
			jb6 = new JButton("yu e");
			jb5.addActionListener(this);
			jb6.addActionListener(this);

			f2.getContentPane().add(jl3);
			f2.getContentPane().add(jb5);
			f2.getContentPane().add(jb6);

			f2.setSize(250, 150);
			f2.setVisible(true);
		}
		if (e.getSource() == jb3) {
			JFrame f3 = new JFrame("");
			f3.getContentPane().setLayout(new FlowLayout());
			jl4 = new JLabel("请输入你要冲值的金额");

			jt1 = new JTextField(10);
			jt1.addActionListener(this);
			f3.getContentPane().add(jl4);
			f3.getContentPane().add(jt1);

			f3.setSize(250, 150);
			f3.setVisible(true);

		}
		if (e.getSource() == jb4) {
			JFrame f4 = new JFrame("");
			f4.getContentPane().setLayout(new FlowLayout());
			jl5 = new JLabel("您的余额是：");
			jl6 = new JLabel("60元 30分");
			f4.getContentPane().add(jl5);
			f4.getContentPane().add(jl6);

			f4.setSize(250, 150);
			f4.setVisible(true);
		}
		if (e.getSource() == jb5) {
			JFrame f5 = new JFrame("");
			f5.getContentPane().setLayout(new FlowLayout());
			jl7 = new JLabel("please input:");

			jt2 = new JTextField(10);
			jt2.addActionListener(this);
			f5.getContentPane().add(jl7);
			f5.getContentPane().add(jt2);

			f5.setSize(250, 150);
			f5.setVisible(true);
		}
		if (e.getSource() == jb6) {
			JFrame f6 = new JFrame("");
			f6.getContentPane().setLayout(new FlowLayout());
			jl8 = new JLabel("you still have:");
			jl9 = new JLabel("60.3 yuan");
			f6.getContentPane().add(jl8);
			f6.getContentPane().add(jl9);

			f6.setSize(250, 150);
			f6.setVisible(true);
		}
	}
}

public class FrameTest {
	public static void main(String args[]) {
		new Frame();
	}
}
