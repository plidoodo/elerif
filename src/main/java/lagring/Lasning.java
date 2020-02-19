package lagring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import doman.Contact;

	/**
	 * @author Erik Blixt Dackhammar
	 */

public class Lasning {

	/**
	 * Laddar in en serialiserade objekt och returnerar en Lista
	 * av kontakter.
	 * @param Tar ett filnamn som parameter.
	 * @return Returnerar en Lista  av deserialiserade Contact-objekt.
	 */
	
	public List<Contact> loadFromFile(String filename) {
		
		List<Contact> contacts = new ArrayList<>();
		try
        {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            contacts = (List<Contact>) ois.readObject();
 
            ois.close();
            fis.close();
        } 
		catch (FileNotFoundException fne) {
			
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
