package neuhoff.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel labelAngle, labelVelocity, labelTime, ansX, answerX, ansY, answerY;
	private JTextField inAngle, inVelocity, inTime;
	private JButton button;

	public ProjectileGUI() {
		setTitle("ProjectileGUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// closes the window exits your program

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		labelAngle = new JLabel("angle");
		inAngle = new JTextField();
		add(labelAngle);
		add(inAngle);
		labelVelocity = new JLabel("velocity");
		inVelocity = new JTextField();
		add(labelVelocity);
		add(inVelocity);
		labelTime = new JLabel("time");
		inTime = new JTextField();
		add(labelTime);
		add(inTime);
		button = new JButton("calculate");
		add(button);
		answerX = new JLabel();
		answerY = new JLabel();

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event){

				double angle = Double.parseDouble(inAngle.getText());
				double velocity = Double.parseDouble(inVelocity.getText());
				double time = Double.parseDouble(inTime.getText());
				Projectile p = new Projectile(angle, velocity, time);
				Double x = p.getX();
				Double y = p.getY();
				
				ansX = new JLabel("X= ");
				add(ansX);
				add(answerX);
				answerX.setText(x.toString());
				
				ansY = new JLabel("Y= ");
				add(ansY);
				add(answerY);
				answerY.setText(y.toString());

			}
		});

	}
	public static void main (String[] args){
		ProjectileGUI p = new ProjectileGUI();
		p.setVisible(true);
	}

}
