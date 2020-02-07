package domän;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {

	private List<Contact> contacts = new ArrayList<>();

	public ContactBook() {
		this.contacts = new ArrayList<Contact>();
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	
	public String findContact(String namn) {
		for (int i = 0; i < contacts.size(); i++) {
			if (namn.equalsIgnoreCase(contacts.get(i).getNamn())) {
				return "Följande kontakt hittades: \n" + contacts.get(i).toString();
			} 
		} return "Kontakt hittades inte";
	}

	public boolean addContactToList(Contact contact) {
		if (findPosition(contact) >= 0) {
			System.out.println("Kontakt finns redan");
			return false;
		} else {
			contacts.add(contact);
		}
		return true;
	}

	private int findPosition(Contact contact) {
		return this.contacts.indexOf(contact);

	}

	public void printContactBook() {
		System.out.println("=============================");
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println();
			System.out.println("namn: " + getContacts().get(i).getNamn() + "\ntelnr: "
					+ getContacts().get(i).getTelefonNr() + "\nmejl: " + getContacts().get(i).getMejl());
			System.out.println();
			System.out.println("=============================");
			
		}
	}

}
