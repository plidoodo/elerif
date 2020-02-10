package lagring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import domän.Contact;
import domän.ContactBook;

public class Lagring {

	ContactBook cb = new ContactBook();

	private static File contacts = new File("src\\main\\resources\\contacts.txt");

	private void addContactToFile(Contact contact) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(contacts, true))) {
			writer.write(contact.getNamn() + "\r\n" + contact.getMejl() + "\r\n" + contact.getTelefonNr() + "\r\n\r\n");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
