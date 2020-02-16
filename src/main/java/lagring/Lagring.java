package lagring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import doman.Contact;
import doman.ContactBook;

public class Lagring {

	public void addToFile(ContactBook cb) {

		try {
			FileOutputStream fos = new FileOutputStream("src\\main\\resources\\contact.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cb.getContacts());
			oos.close();
			fos.close();

		} catch (FileNotFoundException fne) {
			try {
				FileOutputStream fos = new FileOutputStream("src//main//resources//contact.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(cb.getContacts());
				oos.close();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			fne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
