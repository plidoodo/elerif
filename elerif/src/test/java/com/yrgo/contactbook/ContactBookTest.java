package com.yrgo.contactbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domän.Contact;
import domän.ContactBook;

public class ContactBookTest {
	
	private Contact c;
	private ContactBook cl;
	
	public ContactBookTest() {
		c = new Contact();
		cl = new ContactBook();
	}
	
	//Test för att se om metoden addContact fungerar bra
	@Test
	public void addContactTest() {
		ContactBookTest bt = new ContactBookTest();
		boolean sizeContacts = cl.numberOfContacts() == 0;
		
		assertTrue("Arraylisten cl är tom", sizeContacts);
		
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		boolean sizeAfterAdd = cl.numberOfContacts() == 1;
		
		assertTrue("Kontakten finns i listan, listan är inte tom mer", sizeAfterAdd);
	}
	
	@Test
	public void findContactTest() {
		ContactBookTest bt = new ContactBookTest();
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		
		boolean contactFound = cl.findContact("sara").equalsIgnoreCase("Följande kontakt hittades: \n"+ c.toString());
		
		assertTrue("Korrekta kontakt hittades", contactFound);
	}
	
	public void updateContactTest() {
		
	}

}
