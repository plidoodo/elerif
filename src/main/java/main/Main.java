package main;

import doman.Contact;
import doman.ContactBook;
import ui.UiTva;

public class Main {

	public static void main(String[] args) {
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

//		n.addContactToList(new Contact("Erik", "kalaspuff@mejl.se", "+31 63922880"));
//		n.addContactToList(new Contact("Aoife", "aoife@mejl.se", "+46 123 456 78"));
//		n.addContactToList(new Contact("Elske", "elske@mejl.se", "073 455 67 88"));
//		Lagring lg = new Lagring();
//		lg.addToFile(n);
//		n.deleteContact(n.findContact("Erik"));
//		n.deleteContact(n.findContact("Aoife"));
//		n.deleteContact(n.findContact("Elske"));
		ContactBook cb = new ContactBook();
		for (Contact next: cb.getContacts()) {
			System.out.println(next.toString());
			System.out.println();
			
			UiTva ui = new UiTva();
			
			ui.userInterface();
		}
		
		
		
		
		
		

	}
}