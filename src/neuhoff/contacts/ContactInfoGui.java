package neuhoff.contacts;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContactInfoGui extends JFrame {

	private JLabel name, email, address1, address2, phone;

	public ContactInfoGui(Contact contact) {
		setTitle("Contact Info");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		Font font = new Font("Dialog", Font.PLAIN, 22);

		name = new JLabel(contact.getName());
		email = new JLabel(contact.getEmail());
		address1 = new JLabel(contact.getAddress().line1());
		address2 = new JLabel(contact.getAddress().line2());
		phone = new JLabel(contact.getPhone());

		name.setFont(font);
		email.setFont(font);
		address1.setFont(font);
		address2.setFont(font);
		phone.setFont(font);

		
		add(name);
		add(email);
		add(address1);
		add(address2);
		add(phone);
	}
}
