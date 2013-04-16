package threadTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new BounceFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}


class BallRunnable implements Runnable{
	/**
	 * Constructs the runnable.
	 * @param aBall the ball to bounce
	 * @param the component in which the ball bounces
	 */
	public BallRunnable(Ball aBall,Component aComponent){
		ball=aBall;
		component=aComponent;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			/*for(int i=1;i<=STEPS;i++){
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
			}*/
			while(ball.isMoving()){
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
			}
			while(!ball.isDeleted()){
				component.repaint();
				Thread.sleep(DELAY);
			}
			component.repaint();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	private Ball ball;
	private Component component;
	public static final int STEPS=1000;
	public static final int DELAY=5;
	
	
}

/**
 * A ball that moves and bounces off the
 * edges of a rectangle
 */
class Ball
{
	/**
	 * Moves the ball to the next position, reversing 
	 * direction if it hits one of the edges
	 */
	public void move(Rectangle2D bounds) {
		x += dx;
		y += dy;
		if(x < bounds.getMinX()){
			x = bounds.getMinX();
			dx = -dx;
		}
		if(x + XSIZE >= bounds.getMaxX()){
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		if(y < bounds.getMinY()){
			y = bounds.getMinY();
			dy = -dy;
		}
		if(y + YSIZE >= bounds.getMaxY()){
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}
	
	/**
	 * Get the shape of the ball at its current position
	 */
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
	}
	
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	
	private boolean moving = true;

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	private boolean deleted = false;

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}

/**
 * The panel that draws the balls
 */
class BallPanel extends JPanel{
	/**
	 * Add a ball to the panel
	 * @param b the ball to add
	 */
	public void add(Ball b) {
		balls.add(b);
	}
	
	public void stopBalls() {
		for(Ball b:balls){
			b.setMoving(false);
		}
	}
	
	public void clearBalls() {
		for(Ball b:balls){
			b.setMoving(false);
			b.setDeleted(true);
		}
		balls.clear();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(Ball b : balls){
			g2.fill(b.getShape());
		}
	}
	
	private ArrayList<Ball> balls = new ArrayList<Ball>();
}

/**
 * the frame with panel and buttons.
 */
class BounceFrame extends JFrame{
	/**
	 * Constructs the frame with the panel for showing the
	 * bouncing ball and Start and Close buttons
	 */
	public BounceFrame(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("BounceThread");
		
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panel = new BallPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel,BorderLayout.CENTER);
		
		JPanel buttonpPanel = new JPanel();
		addButton(buttonpPanel, "Add", 
				new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addBall();
			}
		});
		addButton(buttonpPanel, "Stop", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stopBalls();
			}
		});
		addButton(buttonpPanel, "Clear", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				clearBalls();
			}
		});
		addButton(buttonpPanel, "Close",
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
				});
		add(buttonpPanel,BorderLayout.SOUTH);
	}
	
	
	
	/**
	 * Add a button to the container
	 * @param c the container
	 * @param title the title
	 */
	public void addButton(Container c,String title,ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	
	
	/**
	 * add a ball
	 */
	public void addBall() {
		Ball b = new Ball();
		panel.add(b);
		Runnable r = new BallRunnable(b, panel);
		Thread t = new Thread(r);
		t.start();
	}
	
	/**
	 * stop all balls
	 */
	public void stopBalls() {
		panel.stopBalls();
	}
	
	public void clearBalls() {
		panel.clearBalls();
	}
	
	private BallPanel panel;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	
	
}





