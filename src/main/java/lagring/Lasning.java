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


public class Lasning {

	
	
	public List<Contact> loadFromFile() {
		
		List<Contact> contacts = new ArrayList<>();
		try
        {
            FileInputStream fis = new FileInputStream("src\\main\\resources\\contact.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            contacts = (List<Contact>) ois.readObject();
 
            ois.close();
            fis.close();
        } 
		catch (FileNotFoundException fne) {
			try {
				FileInputStream fis = new FileInputStream("src//main//resources//contact.txt");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	 
	            contacts = (List<Contact>) ois.readObject();
	 
	            ois.close();
	            fis.close();
				
			}
			catch (FileNotFoundException fne2) {
				fne2.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException ce) {
				ce.printStackTrace();
			}
			
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
		return contacts;
	}
	

}
