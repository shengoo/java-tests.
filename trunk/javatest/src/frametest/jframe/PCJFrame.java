package frametest.jframe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PCJFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -276627774239831064L;
	private JRadioButton radio_Rec, radio_Ell;
	private JButton button_paint;
	private JTextField text_perimeter, text_area;
	public JTextField text_length, text_width;
	public int l, w;
	private RectangleCanvas Rectangle;
	private EllipseCanvas Ellipse;

	public PCJFrame() {
		super("绘制平面图形并计算周长和面积");
		this.setSize(600, 300);
		this.setLocation(200, 100);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel(new FlowLayout(1));
		this.getContentPane().add(panel1, "North");
		ButtonGroup bgroup = new ButtonGroup();
		radio_Rec = new JRadioButton("矩形", true);
		panel1.add(radio_Rec);
		bgroup.add(radio_Rec);
		radio_Ell = new JRadioButton("椭圆", true);
		panel1.add(radio_Ell);
		bgroup.add(radio_Ell);
		panel1.add(new Label("长度"));
		text_length = new JTextField(10);
		panel1.add(text_length);
		panel1.add(new Label("宽度"));
		text_width = new JTextField(10);
		panel1.add(text_width);
		button_paint = new JButton("绘图");
		button_paint.addActionListener(this);
		panel1.add(button_paint);
		JPanel panel2 = new JPanel(new FlowLayout(1));
		this.getContentPane().add(panel2, "South");
		text_perimeter = new JTextField(20);
		panel2.add(new Label("周长"));
		panel2.add(text_perimeter);
		text_area = new JTextField(20);
		panel2.add(new Label("面积"));
		panel2.add(text_area);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		double length = Double.parseDouble(text_length.getText());
		double width = Double.parseDouble(text_width.getText());
		l = (int) length;
		w = (int) width;
		if (Rectangle != null) {
			getContentPane().remove(Rectangle);
		}
		if (Ellipse != null) {
			getContentPane().remove(Ellipse);
		}
		Rectangle = new RectangleCanvas(l, w);
		Ellipse = new EllipseCanvas(l, w);
		if (length > 0 && width > 0) {
			if (e.getSource() == button_paint) {
				if (radio_Rec.isSelected()) {
					double perimeter = (width + length) * 2;
					double area = length * width;
					text_perimeter.setText("" + perimeter);
					text_area.setText("" + area);
					this.getContentPane().add(Rectangle, "Center");

				}
				if (radio_Ell.isSelected()) {
					double perimeter = 3.14 * (1.5 * (length + width) - Math
							.sqrt(length * width));
					double area = 3.14 * length * width;
					text_perimeter.setText("" + perimeter);
					text_area.setText("" + area);
					this.getContentPane().add(Ellipse, "Center");
				}
				this.setVisible(true);
			}
		}
	}

	public static void main(String[] args) {
		new PCJFrame();
	}
}

class RectangleCanvas extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4271723821787047583L;
	private Color color;
	private int length, width;

	public RectangleCanvas(int l, int w) {
		this.color = Color.red;
		this.length = l;
		this.width = w;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.drawRect(150, 50, this.length, this.width);
	}
}

class EllipseCanvas extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 608473407534619186L;
	private Color color;
	private int length, width;

	public EllipseCanvas(int l, int w) {
		this.color = Color.green;
		this.length = l;
		this.width = w;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.drawOval(150, 50, this.length, this.width);
	}
}
