package neuhoff.contacts;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ContactListGui extends JFrame {
	private JList<Contact> names;

	public ContactListGui() {
		setTitle("Contact List");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		names = new JList<Contact>();
		names.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		names.setLayoutOrientation(JList.VERTICAL);
		names.setVisibleRowCount(-1);
		names.setFont(new Font("Dialog", Font.BOLD, 24));

		add(new JScrollPane(names));

		ContactsThread thread = new ContactsThread(names);
		thread.start();
		
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {
					//use list.getSelectedIndex
					int index = names.locationToIndex(mouseEvent
							.getPoint());
					if (index >= 0) {
						Contact contact = thread.getContacts()[index];
						ContactInfoGui gui = new ContactInfoGui(contact);
						
					}
				}
			}
		};
		names.addMouseListener(mouseListener);

	}

	public static void main(String[] args) {
		ContactListGui gui = new ContactListGui();
		gui.setVisible(true);
	}
}
