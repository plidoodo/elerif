package doman;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact implements Comparable<Contact> {

	private String regExM = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private String regExTM = "^\\+?(?:\\s*\\d){10}\\s*$";
	private String regExIT = "^\\+(?:[0-9] ?){6,14}[0-9]$";

	private String namn;
	private String telefonNr;
	private String mejl;

	// Tom konstruktorn
	public Contact() {

	}

	// Konstruktorn med setters för namn, mejl och telefon
	public Contact(String namn, String mejl, String telefonNr) {
		this.namn = namn;
		if (validator(mejl, regExM) == true || mejl.equals("")) {
			this.mejl = mejl;
		}
		if (validator(telefonNr, regExIT) == true
				|| validator(telefonNr, regExTM) == true || telefonNr.equals("")) {
			this.telefonNr = telefonNr;
		}
	}

	// Getters
	public String getNamn() {
		return namn;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public String getMejl() {
		return mejl;
	}

	// Metod för att skapa nya kontakten.
	// Metoden anropas när man ska lägga till nya kontakter i ContactBook
	// Arraylistan
	public Contact createContact(String namn, String mejl, String telefonNr) {

		return new Contact(namn, mejl, telefonNr);
	}

	//Hjälpmetod för att kontrolera om mejl och telefonnummer har korrekta format
	//Metoden fugerar mha regular expressions, och pattern & matcher
	public boolean validator(String s, String regEx) {

		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher;
		matcher = pattern.matcher(s);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	// To String metod för kontakten
	// Anropas när man vill skriva ut en viss kontakt
	@Override
	public String toString() {
		return namn + "\n" + telefonNr + "\n" + mejl;
	}

	// Metod som gjor möjligt att jämföra kontakten med varandra
	@Override
	public int compareTo(Contact b) {
		Contact a = (Contact) b;
		return getNamn().compareTo(a.getNamn());
	}
}
