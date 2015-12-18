package neuhoff.contacts;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ContactListGui extends JFrame {
	private JList names;

	public ContactListGui() {
		setTitle("Contact List");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		names = new JList();
		names.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		names.setLayoutOrientation(JList.VERTICAL);
		names.setVisibleRowCount(-1);
		names.setFont(new Font("Dialog", Font.BOLD, 24));

		add(new JScrollPane(names));

		ContactsThread thread = new ContactsThread(names);
		thread.start();
	}

	public static void main(String[] args) {
		ContactListGui gui = new ContactListGui();
		gui.setVisible(true);
	}
}
