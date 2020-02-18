package com.yrgo.contactbook;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import doman.Contact;

public class ContactTest {
	private Contact a;
	private String regExM = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private String regExTM = "^\\+?(?:\\s*\\d){10}\\s*$";
	private String regExIT = "^\\+(?:[0-9] ?){6,14}[0-9]$";

	/**
	 * @author elske
	 */
	@Test
	public void createContactTest() {
		a = new Contact("Anna", "anna@mejl.se", "+46 731 23 45 67");
		a.createContact("Anna", "anna@mejl.se", "+46 731 23 45 67");
		boolean compare = a.getNamn().trim().equalsIgnoreCase("anna") && a.getMejl().trim().equalsIgnoreCase("anna@mejl.se") && a.getTelefonNr().trim().equalsIgnoreCase("+46 731 23 45 67");
		assertTrue(compare, "Contacten har skapat med korrekta parametern");
	}
	
	/**
	 * @author elske
	 */
	@Test
	public void validatorTest() {
		a = new Contact("Anna", "anna@mejl.se", "+46 731 23 45 67 23 65");
		a.createContact("Anna", "anna@mejl.se", "+46 731 23 45 67 23 65");
		boolean validate = a.validator("anna@mejl.se", regExM);
		assertTrue(validate, "Korrekt email format returnerar true");
		
		a = new Contact("Anna", "anna-mejl-se", "+46 731 23 45 67 23 65");
		a.createContact("Anna", "anna-mejl-se", "+46 731 23 45 67 23 65");
		validate = a.validator("anna-mejl-se", regExM);
		assertFalse(validate, "Felaktigt email format returnerar false");
		
		validate = a.validator("+46 731 23 45 67 23 65", regExTM);
		assertFalse(validate, "Felaktigt telefonnummer retunerar false");
		
		a = new Contact("Anna", "anna-mejl-se", "+46 731 23 45 67");
		a.createContact("Anna", "anna-mejl-se", "+46 731 23 45 67");
		validate = a.validator("+46 731 23 45 67", regExIT);
		assertTrue(validate, "Korrekta telefonnummer format kommer att retuneras true");
		
		a = new Contact("Anna", "anna-mejl-se", "073 123 45 67");
		a.createContact("Anna", "anna-mejl-se", "073 123 45 67");
		validate = a.validator("073 123 45 67", regExTM);
		assertTrue(validate, "Andra mönster av korrekta telefonnummerformat kommer att returnerar true");
		
		a = new Contact("Anna", "anna-mejl-se", "073 123 4567");
		a.createContact("Anna", "anna-mejl-se", "073 123 4567");
		validate = a.validator("073 123 4567", regExTM);
		assertTrue(validate, "Andra mönster av korrekta telefonnummerformat kommer att returnerar true");
		
		a = new Contact("Anna", "anna-mejl-se", "073 1234567");
		a.createContact("Anna", "anna-mejl-se", "073 1234567");
		validate = a.validator("073 1234567", regExTM);
		assertTrue(validate, "Andra mönster av korrekta telefonnummerformat kommer att returnerar true");		
	}
	

}
