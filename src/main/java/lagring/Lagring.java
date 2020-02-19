package lagring;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import doman.ContactBook;

	/**
	 * @author Erik Blixt Dackhammar
	 */

public class Lagring {

	/**
	 * Metod som serialiserar object från en ArrayList 
	 * och lagrar dessa på en given fil.
	 * @param Tar en ContactBook samt en filnamns-String som parameter.
	 */

	public void addToFile(ContactBook cb, String filename) {

		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cb.getContacts());
			oos.close();
			fos.close();

		} catch (FileNotFoundException fne) {


			fne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
