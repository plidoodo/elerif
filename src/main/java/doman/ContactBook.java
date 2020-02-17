package doman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lagring.Lasning;

public class ContactBook {

	private List<Contact> contacts = new ArrayList<>();

	// Konstruktorn
	public ContactBook() {
		Lasning s = new Lasning();
		this.contacts = s.loadFromFile();
	}

	// Getter
	public List<Contact> getContacts() {
		return contacts;
	}

	// Metoden för att hitta vilken position en viss kontakt har i listan
	// hjälpmetod till olika metoder
	public int findPosition(Contact contact) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contact.getNamn().trim().equals(contacts.get(i).getNamn().trim())) {
				return i;
			}
		}
		return -1;
	}

	// Metoden för att addera nya kontakten till listan
	// Om kontakten redan finns får använderen ett meddelande
	public boolean addContactToList(Contact contact) {
		if (findPosition(contact) >= 0) {
			System.out.println("Kontakt finns redan");
			return false;
		} else {
			contacts.add(contact);
			sortContacts();
		}
		return true;
	}

	// Metoden för att hitta kontakten - mha namn
	// Om namnen inte finns i listan, kommer metoden att skriva ut att kontakten
	// inte finns
	public Contact findContact(String input) throws ContactNotFoundException {
		for (int i = 0; i < contacts.size(); i++) {
			if (input.trim().equalsIgnoreCase(contacts.get(i).getNamn().trim())) {
				return contacts.get(i);
			} else if (input.trim().equalsIgnoreCase(contacts.get(i).getMejl().trim())) {
				return contacts.get(i);
			} else if (input.trim().equalsIgnoreCase(contacts.get(i).getTelefonNr().trim())) {
				return contacts.get(i);
			}
		}
		throw new ContactNotFoundException("Kontakt finns inte");
	}

	// Metoden för att uppdatera kontakten
	// metoden placeras uppdaterade kontakten på samma plats i listan
	public void updateContact(Contact a, Contact b) throws ContactNotFoundException {
		if (findPosition(a) >= 0) {
			contacts.set(findPosition(a), b);
		} 
	}

	// Metoden för att ta bort kontakten från listan
	// Kontakten hittades mha namn
	public void deleteContact(Contact c) {
		if (findPosition(c) >= 0) {
			contacts.remove(findPosition(c));
		} 
	}

	// Metod för att sortera listan alfabetisk'
	// Metod anropas innan listan skrivas ut
	public void sortContacts() {
		Collections.sort(contacts, new CompareContactBook());
	}

	// Metod för att kontrollera antal kontakter i kontaktbok
	public int numberOfContacts() {
		return contacts.size();
	}
}
