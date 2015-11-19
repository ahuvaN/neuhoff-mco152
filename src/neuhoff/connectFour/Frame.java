package neuhoff.connectFour;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame{

	private Panel panel;
	
	public Frame(){
		setTitle("Connect 4");
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new Panel();
		add(panel, BorderLayout.CENTER);
	}
	
	public int showWin(){
		dispose();
		return panel.showWin();
	}
	
	public int draw(){
		dispose();
		return panel.draw();
	}
	
	public boolean isWinner(){
		return panel.isWinner();
	}
	
	public boolean isDraw(){
		return panel.isDraw();
	}
	
	public boolean exit(){
		return panel.exit();
	}
	
	public boolean newGame(){
		return panel.newGame();
	}
	
}


