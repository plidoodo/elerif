package lagring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import doman.Contact;
import doman.ContactBook;

public class Lasning {

	public void loadAllContactsFromFile(ContactBook cb) throws IOException {
		File file = new File("src\\main\\resources\\contacts.txt");
		Contact c = new Contact();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String namn = null;
			while ((namn = reader.readLine()) != null) {
				cb.addContactToList(c.createContact(namn.trim(), reader.readLine().trim(), reader.readLine().trim()));
				reader.readLine();
			}
			reader.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	
	public void loadFromFile(List<Contact> contacts) {
		
		
		try
        {
            FileInputStream fis = new FileInputStream("src\\\\main\\\\resources\\\\contact.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            contacts = (ArrayList<Contact>) ois.readObject();
 
            ois.close();
            fis.close();
        } 
		catch (FileNotFoundException fne) {
			fne.printStackTrace();
		}
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
        }
	}
	

}
