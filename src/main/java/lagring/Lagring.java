package lagring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import doman.Contact;
import doman.ContactBook;

public class Lagring {
	

	public void addContactToFile(ContactBook cb) {

		File file = new File("src\\main\\resources\\contacts.txt");
		try  {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < cb.getContacts().size(); i++) {
				pw.println(cb.getContacts().get(i).toString());
				pw.println();
			}
			pw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
