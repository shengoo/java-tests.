package frametest.jframe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyBrowser extends JFrame implements ActionListener{
	
	private JTextField url;
	private MyBrowser webBrowser;
	private Container container;
	private JButton go;
	private JPanel panel;
	
	public MyBrowser(){
//		super("browser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new FlowLayout());
		url = new JTextField();
		url.setEditable(true);
		url.setSize(600, 30);
		go = new JButton();
		go.setSize(60,30);
		go.setText("go");
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(url);
		panel.add(go);
		add(panel,BorderLayout.NORTH);
		setSize(800,600);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyBrowser();
	}


}
