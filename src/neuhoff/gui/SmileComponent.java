package neuhoff.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		g.setColor(Color.YELLOW);
		g.fillOval(250, 100, 300, 300);
		g.setColor(Color.BLUE);
		g.fillOval(335, 175, 50, 70);
		g.fillOval(410, 175, 50, 70);
		g.setColor(Color.red);
		g.drawArc(320, 260, 150, 85, 180, 180);
		
	}

}
