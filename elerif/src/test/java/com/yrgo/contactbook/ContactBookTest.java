package com.yrgo.contactbook;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import domän.Contact;
import domän.ContactBook;

public class ContactBookTest {
	
//	private List<Contact> contacts;
	private Contact c;
	private ContactBook cl;
	
	public ContactBookTest() {
		c = new Contact();
//		contacts = new ArrayList<>();
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
		
	}
	

}
