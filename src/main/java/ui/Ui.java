package ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import doman.Contact;
import doman.ContactBook;


public class Ui extends JFrame {
	
	
	private JLabel status;
	private JPanel panel;
	private JFrame frame = new JFrame("Contact book");
	
	Contact namn;
	
	ContactBook contactbook = new ContactBook();
	
	
	public void userInterface() {
		frame.setSize(400, 400);
		frame.getContentPane().setLayout(new GridLayout(3, 1));
		
		status = new JLabel("", JLabel.CENTER);
//		status.setSize();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		frame.getContentPane().add(panel);
		frame.getContentPane().add(status);
//		frame.pack();
//		frame.setVisible(true);
		
		}
	
	public void show() {
		frame.pack();
		frame.setVisible(true);
	}
	
	public void showEvent() {
		
		
		JButton addContact = new JButton("Add contact");
		JButton updateContact = new JButton("Update contact");
		JButton deleteContact = new JButton("Delete contact");
		JButton searchContact = new JButton("Search contacts");
		JButton showList = new JButton("Show contact list");
		
		
		addContact.addActionListener(e -> {
			pressAddContact();
		});
		updateContact.addActionListener(e -> {
			pressUpdateContact();
		});
		deleteContact.addActionListener(e -> {
			pressDeleteContact();
		});
		searchContact.addActionListener(e -> {
			pressSearchContact();
		});
		showList.addActionListener(e -> {
			pressShowList();
		});
		
		
		
		panel.add(addContact);
		panel.add(updateContact);
		panel.add(deleteContact);
		panel.add(showList);
		
	}
	public void pressAddContact() {
		
		frame.setSize(400, 400);
		frame.getContentPane().setLayout(new GridLayout(2, 5));
		
		JLabel n = new JLabel("Name: ", SwingConstants.CENTER);
		JTextField namn = new JTextField();
		namn.setSize(100, 50);
		JLabel m = new JLabel("E-mail: ", SwingConstants.CENTER);
		JTextField mejl = new JTextField();
		JLabel t = new JLabel("Telefonnr: ", SwingConstants.CENTER);
		JTextField telnr = new JTextField();
		
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		
		
		ok.setActionCommand("OK");
		cancel.setActionCommand("Cancel");
		
		ok.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		
		
		panel.add(n);
		panel.add(namn);
		panel.add(m);
		panel.add(mejl);
		panel.add(t);
		panel.add(telnr);
		panel.add(ok);
		panel.add(cancel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	private class ButtonListener implements ActionListener {

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String cmd = e.getActionCommand();

	        if (cmd.equals("Cancel")) {
	            dispose();
	            
	        }
	        else {
	        	contactbook.addContactToList(namn);
	        }
	    }
	
	}	
	public void pressUpdateContact() {
		
	}
	public void pressDeleteContact() {
		
	}
	public void pressSearchContact() {
		panel.setLayout(new FlowLayout());
		
		frame.setSize(400, 400);
		frame.getContentPane().setLayout(new GridLayout(1, 2));
		
		JLabel s = new JLabel("Sök: ", SwingConstants.CENTER);
		JTextField searchField = new JTextField();
		
		JButton search = new JButton("Save");
		JButton cancel = new JButton("Cancel");
		
		search.addActionListener(e -> {
			pressAddContact();
		});
		
		cancel.addActionListener(e -> {
			pressAddContact();
		});
		
		
		panel.add(s);
		panel.add(searchField);
		panel.add(s);
		panel.add(search);
		frame.setVisible(true);
		
		
		
		
		
		
	}
	public void pressShowList() {
		
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		frame = new JFrame("Contacts");
		frame.setSize(400, 400);
		frame.getContentPane().setLayout(new GridLayout());
		
		JTextArea k = new JTextArea();
		contactbook.sortContacts();
		for (Contact next:contactbook.getContacts()) {
		k.setText(next.toString());
		}
		
		k.setSize(200, 200);
		
		
		
		
	}
	
	
}

//Ui ui = new Ui();
//
//ui.userInterface();
//ui.showEvent();
//ui.show();


//public String printContactBook() {
//
//StringBuilder coolstring = new StringBuilder();
//for (int i = 0; i < contacts.size(); i++) {
//coolstring.append("Namn: " + getContacts().get(i).getNamn());
//coolstring.append("Telnr: " + getContacts().get(i).getTelefonNr());
//coolstring.append("Mail: " + getContacts().get(i).getMejl());
//
//}
//return coolstring.toString();
//}