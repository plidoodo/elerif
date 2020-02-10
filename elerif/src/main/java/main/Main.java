package main;


import domän.Contact;
import domän.ContactBook;
import ui.Ui;

public class Main {

	public static void main(String[] args) {
		Contact c = new Contact();
		ContactBook cl = new ContactBook();
		cl.addContactToList(c.createContact("någon annan", "", "+31 63922880"));
		cl.addContactToList(c.createContact("Aoife", "aoife@mejl.se", "+46 123 456 78"));
		cl.addContactToList(c.createContact("Elske", "elske@mejl.se", "073 455 67 88"));
		System.out.println(cl.findContact("aoife"));
<<<<<<< HEAD
		
		Ui ui = new Ui();
		
		ui.userInterface();
		ui.showEvent();
		ui.show();
		

=======
>>>>>>> 72c1a3cbef87ff59f8faa719fa14570627498fa9
		
	}

}
