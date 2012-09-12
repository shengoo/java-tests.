package game.tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tetris extends JFrame implements KeyListener,Runnable {

	public Tetris() {
		// TODO Auto-generated constructor stub
		setSize(240,320);
		setUndecorated(true);
		int H=(int) (this.getToolkit().getScreenSize().height);
		int W=(int) (this.getToolkit().getScreenSize().width);
		setLocation(W/2-120,H/2-160);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
}
