package neuhoff.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JList;

public class ContactsThread extends Thread {

	private JList guiList;
	private AccessContacts access;

	public ContactsThread(JList contacts) {
		guiList = contacts;
		access = new AccessContacts();
	}

	public void run() {

		try {
			Contact[] contacts = access.getContacts();

			ArrayList<Contact> cont = new ArrayList<Contact>();
			for (int i = 0; i < contacts.length; i++) {
				cont.add(contacts[i]);
			}

			Collections.sort(cont);

			for (int i = 0; i < contacts.length; i++) {
				contacts[i] = cont.get(i);
			}
			guiList.setListData(contacts);

			MouseListener mouseListener = new MouseAdapter() {
				public void mouseClicked(MouseEvent mouseEvent) {
					if (mouseEvent.getClickCount() == 2) {
						int index = guiList.locationToIndex(mouseEvent
								.getPoint());
						if (index >= 0) {
							String name = contacts[index].getName();
							String email = contacts[index].getEmail();
							String address = contacts[index].getAddress()
									.toString();
							String phone = contacts[index].getPhone();
							
							ContactInfoGui gui = new ContactInfoGui(name,
									email, address, phone);
							gui.setVisible(true);
						}
					}
				}
			};
			guiList.addMouseListener(mouseListener);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
