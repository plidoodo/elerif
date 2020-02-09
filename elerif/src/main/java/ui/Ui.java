package ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domän.Contact;
import domän.ContactBook;


public class Ui extends JFrame{
	
	private JFrame frame;
	private JLabel status;
	private JPanel panel;
	String name = Contact.getNamn();
	
	
	private void userInterface() {
		frame = new JFrame("Contact book");
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3, 1));
		
		status = new JLabel("", JLabel.CENTER);
		status.setSize(350, 100);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		frame.add(panel);
		frame.add(status);
		frame.setVisible(true);
		
		}
	
	public void showEvent() {
		
		JButton addContact = new JButton("Add contact");
		JButton updateContact = new JButton("Update contact");
		JButton deleteContact = new JButton("Delete contact");
		JButton searchContact = new JButton("Search contacts");
		JButton showList = new JButton("Show contact list");
		
		addContact.setActionCommand(null);
		updateContact.setActionCommand(null);
		deleteContact.setActionCommand(null);
		searchContact.setActionCommand(null);
		showList.setActionCommand(null);
		
		panel.add(addContact);
		panel.add(updateContact);
		panel.add(deleteContact);
		panel.add(showList);
		
	}
	public void buttonAction() {
		
	}
	
		
	
}

