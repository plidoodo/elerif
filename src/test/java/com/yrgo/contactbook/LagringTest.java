package com.yrgo.contactbook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import doman.Contact;
import doman.ContactBook;
import lagring.Lagring;
import lagring.Lasning;

public class LagringTest {

	private Contact c;
	private ContactBook cb;
	private ContactBook cb2;
	private ContactBook cb3;
	private Lagring l;
	private Lasning ls;

	
	/**
	 * Testar om addToFile-metoden fångar FileNotFoundException
	 *
	 * @author Erik Blixt Dackhammar
	 */
	@Test
	public void fileNotFoundTestAddToFile() {
		try {
			l = new Lagring();
			cb = new ContactBook();

			l.addToFile(cb, "filSomInteFinns");
		} catch (Exception e) {
			assertEquals(FileNotFoundException.class, e.getClass());
		}

	}
	
	/**
	 * Test som testar att inläsning från filen fungerar som det ska.
	 * Skapar först en ContactBook, vars konstruktor innehåller anrop till loadFromFile.
	 * Skapar sedan en separat Lista av kontakter som också laddar in från filen.
	 * Jämför sedan varje kontaktobjekt med varandra för att se om de stämmer överrens.
	 * @author Erik Blixt Dackhammar
	 */
	@Test
	public void loadFromFileTest() {
		cb = new ContactBook(); //Läser automatiskt in kontakter från filen när den instansieras. (loadFromFile-metoden anropas i ContactBook-konstruktorn
		ls = new Lasning(); //Instansierar Läsningsklassen.
		
		List<Contact> testList = ls.loadFromFile("contact.txt"); //Instansierar en annan lista som laddar in från filen genom loadmetod.
		
		
		for(int i = 0; i < cb.getContacts().size(); i++) {
			assertEquals(cb.getContacts().get(i).toString(), testList.get(i).toString()); //Jämför Contact-objekt från de olika listorna.
		}
		
	}
	
	/**
	 * Test för att se att addToFile-metoden fungerar som den skall.
	 * Konstruktorn till ContactBook innehåller ett anrop till loadFromFile
	 * som i sin tur tar en filepath som argument. För att inte påverka filen så 
	 * skapar jag först en ContactBook som sedan används för att återställa filen.
	 * På så sätt påverkas ej filen, fastän den används i detta test.
	 * 
	 * @author Erik Blixt Dackhammar
	 */
	
	@Test
	public void addToFileTest() {
		cb = new ContactBook(); 
		
		l = new Lagring();
		cb2 = new ContactBook(); 
		
		cb2.getContacts().clear(); // Rensar listan från kontakter.
		c = new Contact("Sara", "saar@mejl.se", "073 45 67 89"); 
		cb2.addContactToList(c); //Lägger till kontakt som skapas ovan på listan.
		
		l.addToFile(cb2, "contact.txt"); //Sparar listan på filen.
		cb3 = new ContactBook(); // En ny lista laddas från filen.
		
		for(int i = 0; i < cb2.getContacts().size(); i++) {
			assertEquals(cb2.getContacts().get(i).toString(), cb3.getContacts().get(i).toString()); //Jämför Contact-objekt från de olika listorna.
		}
		
		l.addToFile(cb, "contact.txt"); //Återställer textfilen.
		
	}
}
