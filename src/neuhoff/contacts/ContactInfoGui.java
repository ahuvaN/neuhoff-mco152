package neuhoff.contacts;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactInfoGui extends JFrame {

	private JLabel name, email, address, phone;

	public ContactInfoGui(String inName, String inEmail, String inAddress,
			String inPhone) {
		setTitle("Contact Info");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		Font font = new Font("Dialog", Font.PLAIN, 18);

		name.setText(inName);
		email.setText(inEmail);
		address.setText(inAddress);
		phone.setText(inPhone);

		name.setFont(font);
		email.setFont(font);
		address.setFont(font);
		phone.setFont(font);

		add(name);
		add(email);
		add(address);
		add(phone);
	}
}
