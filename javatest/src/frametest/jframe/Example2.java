package frametest.jframe;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example2 extends JFrame {
	MyPanel mp = null;

	public static void main(String[] args) {
		new Example2();

	}

	public Example2() {
		mp = new MyPanel();

		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

@SuppressWarnings("serial")
class MyPanel extends JPanel implements KeyListener {
	int x = 10;
	int y = 10;

	public void paint(Graphics g) {
		super.paint(g);
		g.fillOval(x, y, 20, 20);
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
			y++;

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			y--;
		}
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
