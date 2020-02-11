package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import doman.ContactBook;

public class UiTva extends JFrame {
	JFrame frame = new JFrame("Contactbook");
	JButton save = new JButton("Save changes");
	JButton updateContact = new JButton("Update contact");
	JButton deleteContact = new JButton("Delete contact");
	JButton searchContact = new JButton("Search contacts");
	JButton showList = new JButton("Show contact list");
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");
	JButton search = new JButton("Save");
	
	JTextArea textArea = new JTextArea(40, 60);
	
	JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	JLabel n = new JLabel("Name: ", SwingConstants.CENTER);
	JTextField namn = new JTextField(15);
	JLabel m = new JLabel("E-mail: ", SwingConstants.CENTER);
	JTextField mejl = new JTextField(15);
	JLabel t = new JLabel("Telefonnr: ", SwingConstants.CENTER);
	JTextField telNr = new JTextField("+46 ");
	JLabel s = new JLabel("Search: ", SwingConstants.CENTER);
	JTextField searchField = new JTextField(15);
	JLabel contacts = new JLabel("Hejsan hoppas jag heter ife och alla Ã¤r mina vÃ¤nner loL");
	
	ContactBook contactbook = new ContactBook();
	
	public void userInterface() {
		JTabbedPane tp = new JTabbedPane();
		add(tp);
		
		//Tab 1
		JPanel tabOne = new JPanel();
		tp.addTab("Add contact", tabOne);
		tabOne.add(n); tabOne.add(namn); tabOne.add(m); tabOne.add(mejl); tabOne.add(t); 
		tabOne.add(telNr);
		tabOne.setLayout(new GridLayout(4, 4));
		tabOne.add(save); tabOne.add(cancel);
		
		//Tab2
		JPanel tabTwo = new JPanel();
		tp.addTab("Search contact", tabTwo);
		tabTwo.add(s); tabTwo.add(searchField);
		
		//Tab3
		JPanel tabThree = new JPanel();
		tp.addTab("Show contact list", tabThree);
		tabThree.add(updateContact); tabThree.add(deleteContact); tabThree.add(scrollPane); 
		tabThree.add(textArea);
		
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
