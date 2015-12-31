package neuhoff.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JList;

public class ContactsThread extends Thread {

	private JList guiList;
	private AccessContacts access;
	private Contact[] contacts;

	public ContactsThread(JList contacts) {
		guiList = contacts;
		access = new AccessContacts();
	}

	public void run() {

		try {
			contacts = access.getContacts();

			ArrayList<Contact> cont = new ArrayList<Contact>();
			for (int i = 0; i < contacts.length; i++) {
				cont.add(contacts[i]);
			}

			Collections.sort(cont);

			for (int i = 0; i < contacts.length; i++) {
				contacts[i] = cont.get(i);
			}
			guiList.setListData(contacts);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Contact[] getContacts(){
		return contacts;
	}
}
