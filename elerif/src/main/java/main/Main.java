package main;


import domän.Contact;
import domän.ContactBook;
import domän.ContactNotFoundException;

public class Main {

	public static void main(String[] args) throws ContactNotFoundException {
		Contact c = new Contact();
		ContactBook cl = new ContactBook();
		cl.addContactToList(c.createContact("någon annan", "", "+31 63922880"));
		cl.addContactToList(c.createContact("Aoife", "aoife@mejl.se", "+46 123 456 78"));
		cl.addContactToList(c.createContact("Elske", "elske@mejl.se", "073 455 67 88"));
		try {
			System.out.println(cl.findContact("aoife").toString());
		} catch (Exception e) {
			throw new ContactNotFoundException("Kontakt finns inte");
		}

	}

}