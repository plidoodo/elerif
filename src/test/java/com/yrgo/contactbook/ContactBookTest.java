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
	private Contact e;
	private ContactBook cl;

	// Test för att se om metoden addContact fungerar bra
	@Test
	public void addContactTest() {
		cl = new ContactBook();
		cl.getContacts().clear();
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
		cl.getContacts().clear();
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
		cl.getContacts().clear();
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 45 67 89"));
		assertThrows(ContactNotFoundException.class, () -> {
			cl.findContact("Anna");
		});
	}

	// Test för att kontrolera om kontakten verkligen blir uppdaterad med
	// uppdateContact metoden
	@Test
	public void updateContactTest() throws Exception {
		cl = new ContactBook();
		cl.getContacts().clear();

		c = new Contact("Sara", "saar@mejl.se", "073 450 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 450 67 89"));

		d = new Contact("Sara", "sara@mejl.se", "073 450 67 99");
		d.createContact("Sara", "sara@mejl.se", "073 450 67 99");
		cl.updateContact(c, d);

		boolean updated = cl.findContact("Sara").getMejl().trim().equals("sara@mejl.se")
				&& cl.findContact("Sara").getTelefonNr().trim().equals("073 450 67 99");
		assertTrue(updated, "Kontakt blev uppdaterat med korrekta mejl och telefonnummer");
	}

	// Test för att kontrolera om kontakten blir borttagen från ContactBook med
	// metoden deleteContact.
	@Test
	public void deleteContactTest() {
		cl = new ContactBook();
		cl.getContacts().clear();

		c = new Contact("Sara", "saar@mejl.se", "073 450 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 450 67 89"));
		int afterAdd = cl.numberOfContacts();

		cl.deleteContact(c);
		int afterDelete = cl.numberOfContacts();

		boolean deleted = afterAdd == afterDelete + 1;
		assertTrue(deleted, "Kontakt blev borttagen från ContactBook");
	}

	// Test för att kontrolera om sorteringsmetod fungerar bra. ContactBook blir
	// sorterad varje gång man lägger till ett kontakt.
	@Test
	public void sortContactsTest() {
		cl = new ContactBook();
		cl.getContacts().clear();

		c = new Contact("Sara", "saar@mejl.se", "073 450 67 89");
		cl.addContactToList(c.createContact("Sara", "saar@mejl.se", "073 450 67 89"));

		d = new Contact("Anna", "anna@mejl.se", "+46 731 23 45 67");
		cl.addContactToList(d.createContact("Anna", "anna@mejl.se", "+46 731 23 45 67"));
		
		e = new Contact("Chris", "chris@mejl.se", "073 678 45 65");
		cl.addContactToList(e.createContact("Chris", "chris@mejl.se", "073 678 45 65"));
		
		int positionSara = cl.findPosition(c);
		int positionAnna = cl.findPosition(d);
		int positionChris = cl.findPosition(e);
		
		boolean sorted = positionSara == 2 && positionAnna == 0 && positionChris == 1;
		assertTrue(sorted, "Kontakter ligger på alfabetiskt följd i ContactBook");
		
		
	}
}
