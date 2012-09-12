package frametest.listenertest;

import java.awt.*;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TextMultListener implements MouseMotionListener, MouseListener {
	Frame f = new Frame("多重监听器");
	TextField tf = new TextField(30);
	Button b = new Button("start");

	public TextMultListener() {
		Label l = new Label("请按下鼠标左键移动");
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

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(f))
			tf.setText("你点了Frame");
		if (e.getSource().equals(b)) 
			tf.setText("你点击了button");
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		tf.setBackground(Color.green);
		tf.setText("鼠标已经进入界面");

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		tf.setText("鼠标已经出了界面");
		tf.setBackground(Color.RED);
//		System.out.print(tf.BOTTOM_ALIGNMENT);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}