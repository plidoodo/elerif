package domän;

import java.util.ArrayList;
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

<<<<<<< HEAD
=======
	//Metoden för att hitta kontakten - mha namn
		//Om namnen inte finns i listan, kommer metoden att skriva ut att kontakten inte finns
		public String findContact(String namn) {
			for (int i = 0; i < contacts.size(); i++) {
				if (namn.equalsIgnoreCase(contacts.get(i).getNamn())) {
					return "Följande kontakt hittades: \n" + contacts.get(i).toString();
				}
			}
			return "Kontakt hittades inte";
		}
		
	//Metoden för att uppdatera kontakten
	//metoden placeras uppdaterade kontakten på samma plats i listan
	public void updateContact(Contact a, Contact b) {
		for (int i = 0; i < contacts.size(); i++) {
			if (a.getNamn().equalsIgnoreCase(contacts.get(i).getNamn())) {
				contacts.set(i, b);	
			} else {
				System.out.println("Kontakt finns inte!");
			}
		}
	}
	
	//Metoden för att ta bort kontakten från listan
	//Kontakten hittades mha namn
	public void deleteContact(String namn) {
		for (int i = 0; i < contacts.size(); i++) {
			if (namn.equalsIgnoreCase(contacts.get(i).getNamn())) {
				contacts.remove(contacts.get(i));
			} else {
				System.out.println("Kontakt finns inte!");
			}
		}
	}
	
	//Metoden för att hitta vilken position en viss kontakt har i listan
	//hjälpmetod till "addContat" metoden
>>>>>>> 72c1a3cbef87ff59f8faa719fa14570627498fa9
	public int findPosition(Contact contact) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contact.getNamn().equals(contacts.get(i).getNamn())) {
				return i;
			}
		}
		return -1;
	}
	
	//Metod för att skriva ut alla kontakter i listan. 
	//Metod skall anropas för att skapa .txt filen
	public void printContactBook() {
		
		System.out.println("=============================");
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println();
			System.out.println("namn: " + getContacts().get(i).getNamn() + "\ntelnr: "
					+ getContacts().get(i).getTelefonNr() + "\nmejl: " + getContacts().get(i).getMejl());
			System.out.println();
			System.out.println("=============================");

		}
<<<<<<< HEAD
=======
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
>>>>>>> 72c1a3cbef87ff59f8faa719fa14570627498fa9
}
}

	



