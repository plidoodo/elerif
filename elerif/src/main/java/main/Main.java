package main;

import domän.Contact;
import domän.ContactBook;

public class Main {

	public static void main(String[] args) {
		Contact c = new Contact("Aoife", "aoife@mejl.se", "123456789");
		
	//	System.out.println(c.toString());
		ContactBook cl = new ContactBook();
		cl.addContactToList(c.createContact("Aoife", "aoife@mejl.se", "+46 123 456 78"));
		cl.addContactToList(c.createContact("Elske", "elske@mejl.se", "073 45 67 8"));
		cl.printContactBook();
		
	}

}
