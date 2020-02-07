package ui;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ui {
	
	private JFrame frame;
	private JLabel rubrik;
	private JLabel status;
	private JPanel panel;

	public static void main(String[] args) {
	

	}
	
	private void userInterface() {
		frame = new JFrame("Contacts");
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout());
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
				
			}
			
		});
		
	}
	
	public void buttons() {
		JButton addContact = new JButton("Add contact");
		JButton updateContact = new JButton("Update contact");
		JButton deleteContact = new JButton("Delete contact");
		JButton showList = new JButton("Show contacts");

		
		
	}
	

}
