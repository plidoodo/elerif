package com.yrgo.contactbook;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import doman.Contact;
import doman.ContactBook;
import doman.ContactNotFoundException;

public class ContactBookTest {

	private Contact c;
	private Contact d;
	private ContactBook cl;

	// Test för att se om metoden addContact fungerar bra
	@Test
	public void addContactTest() {
		cl = new ContactBook();
		boolean sizeContacts = cl.numberOfContacts() == 0;

		assertTrue(sizeContacts, "Arraylisten cl är tom");

		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		boolean sizeAfterAdd = cl.numberOfContacts() == 1;

		assertTrue(sizeAfterAdd, "Kontakten finns i listan, listan är inte tom längre");
	}

	@Test
	public void addDoubleContactTest() {
		cl = new ContactBook();
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));

		int sizeAfterAdd1 = cl.numberOfContacts();

		boolean addSameContactAgain = cl
				.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89")) == false;

		int sizeAfterAdd2 = cl.numberOfContacts();
		boolean sizeIsTheSame = sizeAfterAdd1 == sizeAfterAdd2;

		assertTrue(addSameContactAgain, "Metoden returneras false om man lägger samma kontakt in igen");
		assertTrue(sizeIsTheSame, "Storlek av ContactBook har inte ändrats");

	}

	// Test för att se om findContact metoden fungerar som den borde
	@Test
	public void findContactTest() throws Exception {
		cl = new ContactBook();
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));

		boolean contactFound = cl.findContact("Sara").getNamn().equals(c.getNamn());
		assertTrue(contactFound, "Korrekta kontakt hittades");

		contactFound = cl.findContact("saar@mejl.se").getMejl().equals(c.getMejl());
		assertTrue(contactFound, "Korrekta kontakt hittades med mejl som parametern");
	}

	// Test för att se om findContact kastar ContactNotFoundException
	@Test
	public void ExceptionTest() {
		cl = new ContactBook();
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		assertThrows(ContactNotFoundException.class, () -> {
			cl.findContact("Anna");
		});
	}

	@Test
	public void updateContactTest() throws Exception {
		cl = new ContactBook();

		c = new Contact("Sara", "saar@mejl.se", "073 450 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 450 67 89"));

		d = new Contact("Sara", "sara@mejl.se", "073 450 67 99");
		d.createContact("Sara", "sara@mejl.se", "073 450 67 99");
		cl.updateContact(c, d);

		boolean updated = cl.findContact("Sara").getMejl().equals("sara@mejl.se") && cl.findContact("Sara").getTelefonNr().equals("073 450 67 99");
		assertTrue(updated, "Kontakt blev uppdaterat med korrekta mejl och telefonnummer");
	}

}
