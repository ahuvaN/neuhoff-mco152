package neuhoff.quadraticEquation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import neuhoff.physics.DivideByZeroException;
import neuhoff.physics.ImaginaryNumberException;

public class QuadraticEquationGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel labelA, labelB, labelC, ansX, answer;
	private JTextField inA, inB, inC;
	private JButton button;

	public QuadraticEquationGUI() {
		setTitle("QuadraticEquationGUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// closes the window exits your program

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		labelA = new JLabel("a");
		inA = new JTextField();
		add(labelA);
		add(inA);
		labelB = new JLabel("b");
		inB = new JTextField();
		add(labelB);
		add(inB);
		labelC = new JLabel("c");
		inC = new JTextField();
		add(labelC);
		add(inC);
		button = new JButton("calculate");
		add(button);
						
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				QuadraticEquation q;
				try {
					double a = Double.parseDouble(inA.getText());
					double b = Double.parseDouble(inB.getText());
					double c = Double.parseDouble(inC.getText());
					q = new QuadraticEquation(a, b, c);
					Double x = q.getPositiveX();
					StringBuilder sb = new StringBuilder();
					sb.append(x);
					ansX = new JLabel("x= ");
					answer = new JLabel();
					
					add(ansX);
					add(answer);
					answer.setText(sb.toString());
					
										
				} catch (ImaginaryNumberException | DivideByZeroException e) {
					System.out.println(e);
				}
			}
		});
		
		

	}
	public static void main (String[] args){
		QuadraticEquationGUI q = new QuadraticEquationGUI();
		q.setVisible(true);
	}
}
