package frametest.listenertest;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextMultListener implements MouseMotionListener, MouseListener {
	Frame f = new Frame("多重监听器");
	
	TextField tf = new TextField(30);
	Button b = new Button("按钮");

	public TextMultListener() {
		f.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e){
				  System.exit(0);
				 }
		});
		String string = "请按下鼠标左键移动";
		Label l = new Label(string);
		f.add(l, "North");
		f.add(tf, "South");
		f.setBackground(new Color(200, 200, 100));
		f.addMouseMotionListener(this);
		b.addMouseListener(this);
		f.addMouseListener(this);
		f.add(b, "East");
		f.setSize(300, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TextMultListener();
	}

	public void mouseDragged(MouseEvent e) {
		String s = "鼠标移动到的位置是：(" + e.getX() + "-" + e.getY() + ")";
		tf.setText(s);
	}

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(f))
			tf.setText("你点了Frame");
		if (e.getSource().equals(b)) 
			tf.setText("你点击了button");
	}

	public void mouseEntered(MouseEvent e) {

		tf.setBackground(Color.green);
		tf.setText("鼠标已经进入界面");

		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		tf.setText("鼠标已经出了界面");
		tf.setBackground(Color.RED);
//		System.out.print(tf.BOTTOM_ALIGNMENT);
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}