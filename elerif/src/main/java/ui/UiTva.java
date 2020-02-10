package ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UiTva extends JFrame {
	
	JButton save = new JButton("Save changes");
	JButton updateContact = new JButton("Update contact");
	JButton deleteContact = new JButton("Delete contact");
	JButton searchContact = new JButton("Search contacts");
	JButton showList = new JButton("Show contact list");
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");
	JButton search = new JButton("Save");

	JLabel n = new JLabel("Name: ", SwingConstants.CENTER);
	JTextField namn = new JTextField();
	JLabel m = new JLabel("E-mail: ", SwingConstants.CENTER);
	JTextField mejl = new JTextField();
	JLabel t = new JLabel("Telefonnr: ", SwingConstants.CENTER);
	JTextField telNr = new JTextField();
	JLabel s = new JLabel("Sök: ", SwingConstants.CENTER);
	JTextField searchField = new JTextField();
	
	public void userInterface() {
		JTabbedPane tp = new JTabbedPane();
		add(tp);
		
		//Tab 1
		JPanel tabOne = new JPanel();
		tp.addTab("Add contact", tabOne);
		tabOne.add(n); tabOne.add(namn); tabOne.add(m); tabOne.add(mejl); tabOne.add(t); tabOne.add(telNr);
		tabOne.setLayout(new GridLayout(4, 4));
		tabOne.add(save); tabOne.add(cancel);
		
		//Tab2
		JPanel tabTwo = new JPanel();
		tp.addTab("Search contact", tabTwo);
		tabTwo.add(s); tabTwo.add(searchField);
		
		//Tab3
		JPanel tabThree = new JPanel();
		tp.addTab("Show contact list", tabThree);
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	

}
