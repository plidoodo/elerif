package lagring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domän.Contact;
import domän.ContactBook;	

public class Läsning {
	
	private void loadAllContactsFromFile() throws IOException {
		File file = new File("src\\main\\resources\\contacts.txt");
		ContactBook cb = new ContactBook();
		Contact c = new Contact();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String namn = null;
			while ((namn = reader.readLine()) != null) {
				cb.addContactToList(c.createContact(namn, reader.readLine(), reader.readLine()));
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
