package domän;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactBook {

	private List<Contact> contacts = new ArrayList<>();

	//Konstruktorn
	public ContactBook() {
		this.contacts = new ArrayList<Contact>();
	}

	//Getter
	public List<Contact> getContacts() {
		return contacts;
	}

	//Metoden för att hitta vilken position en viss kontakt har i listan
		//hjälpmetod till olika metoder
		public int findPosition(Contact contact) {
			for (int i = 0; i < contacts.size(); i++) {
				if (contact.getNamn().equals(contacts.get(i).getNamn())) {
					return i;
				}
			}
			return -1;
		}

	//Metoden för att addera nya kontakten till listan 
	//Om kontakten redan finns får använderen ett meddelande
	public boolean addContactToList(Contact contact) {
	if (findPosition(contact) >= 0) {
			System.out.println("Kontakt finns redan");
			return false;
		} else {
			contacts.add(contact);
		}
		return true;
	}

	//Metoden för att hitta kontakten - mha namn
		//Om namnen inte finns i listan, kommer metoden att skriva ut att kontakten inte finns
		public Contact findContact(String input) throws Exception {
			for (int i = 0; i < contacts.size(); i++) {
				if (input.equalsIgnoreCase(contacts.get(i).getNamn())) {
					return contacts.get(i);
				} else if (input.equalsIgnoreCase(contacts.get(i).getMejl())) {
					return contacts.get(i);
				} else if (input.equalsIgnoreCase(contacts.get(i).getTelefonNr())) {
					return contacts.get(i);
				}
			}
			throw new ContactNotFoundException("Kontakt finns inte");
		}
		
	//Metoden för att uppdatera kontakten
	//metoden placeras uppdaterade kontakten på samma plats i listan
	public void updateContact(Contact a, Contact b) {
		if (findPosition(a) >= 0) {
				contacts.set(findPosition(a), b);	
			} else {
				System.out.println("Kontakt finns inte!");
			}
		}
	
	//Metoden för att ta bort kontakten från listan
	//Kontakten hittades mha namn
	public void deleteContact(Contact c) {
		if (findPosition(c) >= 0) {
			contacts.remove(findPosition(c));
			} else {
				System.out.println("Kontakt finns inte!");
			}
		}
	
	
	//Metod för att sortera listan alfabetisk'
	//Metod anropas innan listan skrivas ut
	public void sortContacts() {
		Collections.sort(contacts, new CompareContactBook());
	}
	
	//Metod för att kontrollera antal kontakter i kontaktbok
	public int numberOfContacts() {
		return contacts.size();
	}
}


