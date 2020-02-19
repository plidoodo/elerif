package ui;


// UI-author = Aoife

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import doman.Contact;
import doman.ContactBook;
import lagring.Lagring;

public class Ui extends JFrame {

	ContactBook contactbook = new ContactBook();
	Contact c = new Contact();
	Lagring lagring = new Lagring();

	JFrame frame = new JFrame("Contactbook");
	JDialog update = new JDialog();
	JPanel update2 = new JPanel();
	JPanel panel = new JPanel();
	JPanel tabOne = new JPanel();
	JPanel tabTwo = new JPanel();
	JPanel tabThree = new JPanel();
	JButton save = new JButton("Save changes");
	JButton save2 = new JButton("Save changes");
	JButton updateContact = new JButton("Update contact");
	JButton deleteContact = new JButton("Delete contact");
	JButton searchContact = new JButton("Search contacts");
	JButton showList = new JButton("Show contact list");
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");
	JButton cancel2 = new JButton("Cancel");
	JButton search = new JButton("Search");

	DefaultListModel<Contact> listModel = new DefaultListModel<Contact>();
	JList<Contact> list = new JList<Contact>(listModel);
	JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	JLabel n = new JLabel("Name: ", SwingConstants.CENTER);
	JLabel n2 = new JLabel("Name: ", SwingConstants.CENTER);
	JLabel kontakt = new JLabel();
	JLabel s = new JLabel("Search: ", SwingConstants.CENTER);
	JLabel t2 = new JLabel("Telefonnr: ", SwingConstants.CENTER);
	JLabel t = new JLabel("Telefonnr: ", SwingConstants.CENTER);
	JLabel m = new JLabel("E-mail: ", SwingConstants.CENTER);
	JLabel m2 = new JLabel("E-mail: ", SwingConstants.CENTER);
	JLabel varning = new JLabel("Please enter the exact name, e-mail or phonenumber!", SwingConstants.CENTER);
	JLabel error = new JLabel("The contact cannot be found");
	JLabel incorrect = new JLabel("* couldn't be updated because of incorrect format!");	
	JTextField namn = new JTextField(15);
	JTextField namn2 = new JTextField(15);
	JTextField mejl = new JTextField(15);
	JTextField mejl2 = new JTextField(15);
	JTextField telNr = new JTextField(15);
	JTextField telNr2 = new JTextField();
	JTextField searchField = new JTextField(15);
	JTabbedPane tp = new JTabbedPane();

	public void userInterface() {
		listModel.addAll(contactbook.getContacts());
		add(tp);

		// Tab 1

		tp.addTab("Add contact", tabOne);
		tabOne.add(n2);
		tabOne.add(namn2);
		tabOne.add(m2);
		tabOne.add(mejl2);
		tabOne.add(t2);
		tabOne.add(telNr2);
		tabOne.setLayout(new GridLayout(4, 4));

		tabOne.add(save2);
		tabOne.add(cancel2);
		
//		Sparar kontakt
		save2.addActionListener(e -> {
			if (contactbook.addContactToList(c.createContact(namn2.getText(), mejl2.getText(), telNr2.getText()))) {
				lagring.addToFile(contactbook);
				listModel.clear();
				listModel.addAll(contactbook.getContacts());
				JOptionPane.showMessageDialog(null, "Contact added");
			} else {
				JOptionPane.showMessageDialog(null, "Tyvärr, någonting gick fel");
			}
		});
		cancel2.addActionListener(e -> {
			dispose();
		});

		// Tab2
		tp.addTab("Search contact", tabTwo);
		tabTwo.add(varning);
		tabTwo.add(s);
		tabTwo.add(searchField);
		tabTwo.add(search);
		tabTwo.add(kontakt);

//		sök efter kontakter
		search.addActionListener(e -> {
			if (searchField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error: please enter exact name, e-mail or phonenumber!");
			} else {
				try {
					Contact trupp = contactbook.findContact(searchField.getText());
					kontakt.setText(trupp.toString());
				} catch (Exception ContactNotFoundException) {
					JOptionPane.showMessageDialog(null, "Kontakt hittades inte!");
					ContactNotFoundException.printStackTrace();
				}
			}

		});
		// Tab3
		tabThree.setLayout(new FlowLayout());
		tp.addTab("Show contact list", tabThree);
		tabThree.add(updateContact);
		tabThree.add(deleteContact);
		tabThree.add(scroll);
		tabThree.add(incorrect);

//		Detta är rutan som kommer upp när man trycker på update
		update.setContentPane(update2);
		update2.setLayout(new GridLayout(4, 4));

		update2.add(n);
		update2.add(namn);
		update2.add(m);
		update2.add(mejl);
		update2.add(t);
		update2.add(telNr);
		update2.add(save);
		update2.add(cancel);

//		visar rutan där man kan uppdatera kontakter
		updateContact.addActionListener(e -> {
			if (list.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Error: please select a contact to update!");

			} else {
				update.pack();
				update.setVisible(true);
			}
		});
//		Sparar uppdaterad kontakt och sparar dem till fil
		save.addActionListener(e -> {
			Contact con = (Contact) list.getSelectedValue();
			Contact tact = c.createContact(namn.getText(), mejl.getText(), telNr.getText());

			try {
				contactbook.updateContact(con, tact);
			} catch (Exception ContactNotFoundException) {

				ContactNotFoundException.printStackTrace();
			} finally {
				update.dispose();
				lagring.addToFile(contactbook);
			}

			listModel.clear();
			listModel.addAll(contactbook.getContacts());
		});

//		tar bort kontakt
		deleteContact.addActionListener(e -> {
			if (list.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Error, please select contact to delete!");
			} else {
				Contact con = (Contact) list.getSelectedValue();
				contactbook.deleteContact(con);
				lagring.addToFile(contactbook);
				listModel.clear();
				listModel.addAll(contactbook.getContacts());
			}
		});
//		avslutar utan att spara ändringar
		cancel.addActionListener(e -> {
			update.dispose();
		});

		list.toString();
		pack();
		setSize(350, 350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			e.getActionCommand();
		}
	}
}