package frametest.listenertest;

import java.awt.*;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TextMultListener implements MouseMotionListener, MouseListener {
	Frame f = new Frame("���ؼ�����");
	TextField tf = new TextField(30);
	Button b = new Button("start");

	public TextMultListener() {
		Label l = new Label("�밴���������ƶ�");
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
		String s = "����ƶ�����λ���ǣ�(" + e.getX() + "-" + e.getY() + ")";
		tf.setText(s);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(f))
			tf.setText("�����Frame");
		if (e.getSource().equals(b)) 
			tf.setText("������button");
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		tf.setBackground(Color.green);
		tf.setText("����Ѿ��������");

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		tf.setText("����Ѿ����˽���");
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