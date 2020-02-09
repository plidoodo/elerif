package com.yrgo.contactbook;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domän.Contact;

public class ContactTest {
	private Contact a;

	
	@Test
	public void createContact() {
		a = new Contact("Anna", "anna@mejl.se", "+46 731 23 45 67");
		a.createContact("Anna", "anna@mejl.se", "+46 731 23 45 67");
		boolean compare = a.getNamn().equalsIgnoreCase("anna") && a.getMejl().equalsIgnoreCase("anna@mejl.se") && a.getTelefonNr().equalsIgnoreCase("+46 731 23 45 67");
		assertTrue("Contacten har skapat med korrekta parametern", compare);
	}

}
