package neuhoff.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo  extends JFrame {
	
	private JLabel label1, label2;
	private JTextField textField;
	private JButton button;

	public JFrameDemo(){
		setTitle("JrameDemo");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//closes the window exits your program
		
		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		label1 = new JLabel("All this text gets shown all the time"); 
		label2 = new JLabel("MORE LABELS");
		button = new JButton("Button1");
		textField = new JTextField();
		
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// this is an anonymous class
				System.out.println(new Date());
				
			}
		});
		
		add(label1);
		add(label2);
		add(textField);
		add(button);
	}
}
