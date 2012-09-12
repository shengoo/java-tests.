package frametest;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RectangleDemo {

	JFrame main = new JFrame();
	JLabel widthLbl = new JLabel("Width");
	JTextField widthTf = new JTextField();
	JLabel heightLbl = new JLabel("Height");
	JTextField heightTf = new JTextField();

	public RectangleDemo(){
		widthLbl.setSize(60, 20);
		widthLbl.setLocation(100, 100);
		main.add(widthLbl);
		widthTf.setSize(80,20);
		widthTf.setLocation(180, 100);
		main.add(widthTf);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(500,400);
		main.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RectangleDemo();
		
	}

}
