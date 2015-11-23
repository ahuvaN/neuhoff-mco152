package neuhoff.physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		//convert Graphics to 2D to be able to accept input of double
		Graphics2D g2 = (Graphics2D) g;
		
		double x1, y1, x2, y2;
		
		Projectile p = new Projectile(31, 20, 0);
		//initialize the first line
		x1 = p.getX();
		y1 = getHeight() - p.getY();
		p.setTime(.1);
		x2 = p.getX();
		y2 = getHeight() - p.getY();
		g2.draw(new Line2D.Double(x1, y1, x2, y2));
		//g2.setColor(Color.RED);
		
		
		for (double i = 0.0; i < 20; i += .1) {
			p.setTime(i);
			x1 = x2;
			y1 = y2;
			x2 = p.getX();
			y2 = getHeight() - p.getY();
			g2.draw(new Line2D.Double(x1, y1, x2, y2));
		} 

	}

}
