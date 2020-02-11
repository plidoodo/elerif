package lagring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import doman.Contact;
import doman.ContactBook;	

public class Lasning {
	
	public void loadAllContactsFromFile(ContactBook cb) throws IOException {
		File file = new File("src\\main\\resources\\contacts.txt");
		Contact c = new Contact();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String namn = null;
			while ((namn = reader.readLine()) != null) {
				cb.addContactToList(c.createContact(namn, reader.readLine(), reader.readLine()));
				reader.readLine();
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
