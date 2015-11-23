package neuhoff.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class SmileComponent extends JComponent implements MouseMotionListener {

	private volatile int x1;
	private volatile int x2;
	private volatile int y;
    
   public SmileComponent(){
	   x1 = 350;
	   x2 = 425;
	   y = 215;
	   addMouseMotionListener(this);
   }
        
        @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		// face
		g.setColor(Color.YELLOW);
		g.fillOval(250, 100, 300, 300);
		
		//eyes
		g.setColor(Color.BLUE);
		g.fillOval(335, 175, 50, 70);
		g.fillOval(410, 175, 50, 70);
		
		//eyeballs
		g.setColor(Color.WHITE);
		g.fillOval(x1, y, 24, 30);
		g.fillOval(x2, y, 24, 30);

		
		//mouth
		g.setColor(Color.red);
		g.drawArc(330, 260, 150, 85, 180, 180);
		
	}


		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseMoved(MouseEvent e) {
			int locationX = (int)e.getLocationOnScreen().getX()/100;
			int locationY = (int)e.getLocationOnScreen().getY()/50;
			
			x1 = locationX + 345;
			x2 = locationX + 420;
			y = locationY + 200;
			repaint();
			}
}
