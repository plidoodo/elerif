package com.yrgo.contactbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import domän.Contact;
import domän.ContactBook;
import domän.ContactNotFoundException;

public class ContactBookTest {
	
	private Contact c;
	private ContactBook cl;
	
	
	//Test för att se om metoden addContact fungerar bra
	@Test
	public void addContactTest() {
		cl = new ContactBook();
		boolean sizeContacts = cl.numberOfContacts() == 0;
		
		assertTrue("Arraylisten cl är tom", sizeContacts);
		
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		boolean sizeAfterAdd = cl.numberOfContacts() == 1;
		
		assertTrue("Kontakten finns i listan, listan är inte tom mer", sizeAfterAdd);
	}		
	
	@Test
	public void addDoubleContactTest() {
		cl = new ContactBook();
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		int sizeAfterAdd1 = cl.numberOfContacts();
		
		boolean addSameContactAgain = cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89")) == false;
		int sizeAfterAdd2 = cl.numberOfContacts();
		
		boolean sizeIsTheSame = sizeAfterAdd1 == sizeAfterAdd2;
		assertTrue("Metoden returneras false om man lägger samma kontakt in igen", addSameContactAgain);
		assertTrue("Storlek av ContactBook har inte ändrats", sizeIsTheSame);
			
	}
	
	//Test för att se om findContact metoden fungerar som den borde
	@Test
	public void findContactTest() throws Exception {
		cl = new ContactBook();
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		
		boolean contactFound = cl.findContact("Sara").getNamn().equals(c.getNamn());
		assertTrue("Korrekta kontakt hittades", contactFound);
		
		contactFound = cl.findContact("saar@mejl.se").getMejl().equals(c.getMejl());
		assertTrue("Korrekta kontakt hittades med mejl som parametern", contactFound);
	}
	
	//Test för att se om findContact kastar ContactNotFoundException
	@Test
	public void ExceptionTest() {
		cl = new ContactBook();
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		assertThrows(ContactNotFoundException.class, () -> {
			cl.findContact("Anna");	
	    });
	}	

}

