package lagring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import domän.Contact;
import domän.ContactBook;

public class Lagring {
	

	public void addContactToFile() {

		File file = new File("src\\main\\resources\\contacts.txt");
		ContactBook cb = new ContactBook();
		try  {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < cb.getContacts().size(); i++) {
				writer.write(cb.getContacts().get(i).getNamn() + "\r\n" + cb.getContacts().get(i).getMejl() + "\r\n"
						+ cb.getContacts().get(i).getTelefonNr() + "\r\n\r\n");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
