package lagring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import domän.Contact;
import domän.ContactBook;

public class Lagring {
	
	ContactBook cb = new ContactBook();
	

	
	static File contacts = new File("src\\main\\resources\\contacts.txt");
	
	private static void addContactToFile(Contact contact) {
			
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(contacts))) {
			writer.write(contact.getNamn() + "\r\n" + contact.getMejl() + "\r\n" + contact.getTelefonNr() + "\r\n\r\n");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		}
	
	public static void main(String[] args) {
		
		ContactBook cb = new ContactBook();
		Contact erik = new Contact("Erik", "erblida@gmail.com", "070 497 57 59");
		cb.addContactToList(erik);
		
		
	}
	
}
