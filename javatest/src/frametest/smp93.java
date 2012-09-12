package frametest;

import java.awt.*;
import java.awt.event.*;

class smp931 extends Frame implements ActionListener {
	FileDialog s, o;
	Button b1, b2;

	smp931() {
		super("smp931");
		setVisible(true);
		setSize(300, 250);
		setBackground(Color.yellow);
		setLayout(null);
		Panel pnl = new Panel();
		pnl.setBackground(Color.blue);
		add(pnl);
		b1 = new Button("打开");
		b2 = new Button("保存");
		add(b1);
		add(b2);
		pnl.setBounds(20, 40, 250, 150);
		b1.setBounds(50, 200, 80, 30);
		b2.setBounds(150, 200, 80, 30);
		o = new FileDialog(this, "打开", FileDialog.LOAD);
		s = new FileDialog(this, "保存", FileDialog.SAVE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		this.addWindowListener(
		/**
		 * WindowListener是接口，没有实现。
		 * WindowAdapter是抽象类，实现了所有的WindowListener方法，只不过方法内部都是空的。
		 */
		new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		}
		);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			o.setVisible(true);
		}
		if (e.getSource() == b2) {
			s.setVisible(true);
		}
	}
}

public class smp93 {
	public static void main(String args[]) {
		smp931 smp = new smp931();
	}
}
