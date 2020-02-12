package main;


import java.io.IOException;

import doman.Contact;
import doman.ContactBook;
import doman.ContactNotFoundException;
import lagring.Lagring;
import lagring.Lasning;
import ui.UiTva;

public class Main {

	public static void main(String[] args) throws ContactNotFoundException, IOException {
//		Contact c = new Contact();
//		ContactBook cl = new ContactBook();
//		cl.addContactToList(c.createContact("någon annan", "", "+31 63922880"));
//		cl.addContactToList(c.createContact("Aoife", "aoife@mejl.se", "+46 123 456 78"));
//		cl.addContactToList(c.createContact("Elske", "elske@mejl.se", "073 455 67 88"));
//		try {
//			System.out.println(cl.findContact("elske").toString());
//		} catch (Exception e) {
//			throw new ContactNotFoundException("Kontakt finns inte");
//			
//			
//		}
//	
//
//		UiTva ui = new UiTva();
//		
//		ui.userInterface();
//		
//		Lagring l = new Lagring();
//		l.addContactToFile(cl);
//		
//		
		ContactBook n = new ContactBook();
		Lasning l = new Lasning();
		l.loadAllContactsFromFile(n);
		for(Contact next: n.getContacts()) {
			System.out.println(next.toString());
			System.out.println();
		}

		
	}

}