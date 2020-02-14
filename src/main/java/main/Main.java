package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import doman.Contact;
import doman.ContactBook;
import doman.ContactNotFoundException;
import lagring.Lagring;
import lagring.Lasning;
import ui.UiTva;

public class Main {

	public static void main(String[] args) throws Exception {
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

//		n.addContactToList(new Contact("Erik", "kalaspuff@mejl.se", "+31 63922880"));
//		n.addContactToList(new Contact("Aoife", "aoife@mejl.se", "+46 123 456 78"));
//		n.addContactToList(new Contact("Elske", "elske@mejl.se", "073 455 67 88"));
//		Lagring lg = new Lagring();
//		lg.addToFile(n);
//		n.deleteContact(n.findContact("Erik"));
//		n.deleteContact(n.findContact("Aoife"));
//		n.deleteContact(n.findContact("Elske"));
		
		Lasning ls = new Lasning();
		ls.loadFromFile(n.getContacts());
		
		
		

	}
}