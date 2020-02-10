package com.yrgo.contactbook;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domän.Contact;

public class ContactTest {
	private Contact a;
	private String regExM = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private String regExTM = "^\\+?(?:\\s*\\d){10}\\s*$";
	private String regExIT = "^\\+(?:[0-9] ?){6,14}[0-9]$";

	
	@Test
	public void createContactTest() {
		a = new Contact("Anna", "anna@mejl.se", "+46 731 23 45 67");
		a.createContact("Anna", "anna@mejl.se", "+46 731 23 45 67");
		boolean compare = a.getNamn().equalsIgnoreCase("anna") && a.getMejl().equalsIgnoreCase("anna@mejl.se") && a.getTelefonNr().equalsIgnoreCase("+46 731 23 45 67");
		assertTrue("Contacten har skapat med korrekta parametern", compare);
	}
	
	@Test
	public void validatorTest() {
		a = new Contact("Anna", "anna@mejl.se", "+46 731 23 45 67 23 65");
		a.createContact("Anna", "anna@mejl.se", "+46 731 23 45 67 23 65");
		boolean validate = a.validator("anna@mejl.se", regExM);
		assertTrue("Korrekt email format returnerar true", validate);
		
		a = new Contact("Anna", "anna-mejl-se", "+46 731 23 45 67 23 65");
		a.createContact("Anna", "anna-mejl-se", "+46 731 23 45 67 23 65");
		validate = a.validator("anna-mejl-se", regExM);
		assertFalse("Felaktigt email format returnerar false", validate);
		
		validate = a.validator("+46 731 23 45 67 23 65", regExTM);
		assertFalse("Felaktigt telefonnummer retunerar false", validate);
		
		a = new Contact("Anna", "anna-mejl-se", "+46 731 23 45 67");
		a.createContact("Anna", "anna-mejl-se", "+46 731 23 45 67");
		validate = a.validator("+46 731 23 45 67", regExIT);
		assertTrue("Korrekta telefonnummer format kommer att retuneras true", validate);
		
		a = new Contact("Anna", "anna-mejl-se", "073 123 45 67");
		a.createContact("Anna", "anna-mejl-se", "073 123 45 67");
		validate = a.validator("073 123 45 67", regExTM);
		assertTrue("Andra mönster av korrekta telefonnummerformat kommer att returnerar true", validate);
		
		a = new Contact("Anna", "anna-mejl-se", "073 123 45 67");
		a.createContact("Anna", "anna-mejl-se", "073 123 45 67");
		validate = a.validator("073 123 45 67", regExTM);
		assertTrue("Andra mönster av korrekta telefonnummerformat kommer att returnerar true", validate);
		
		a = new Contact("Anna", "anna-mejl-se", "073 1234567");
		a.createContact("Anna", "anna-mejl-se", "073 1234567");
		validate = a.validator("073 1234567", regExTM);
		assertTrue("Andra mönster av korrekta telefonnummerformat kommer att returnerar true", validate);		
	}
	

}
