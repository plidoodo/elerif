package domän;

public class Contact implements Comparable<Contact> {
	
	ContactBook cb = new ContactBook();
	private String namn;
	private String telefonNr;
	private String mejl;
	
	public Contact() {
		
	}
	
	public Contact(String namn, String mejl, String telefonNr) {
		this.namn = namn;
		this.mejl = mejl;
		this.telefonNr = telefonNr;
		
	}

	public String getNamn() {
		return namn;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public String getMejl() {
		return mejl;
	}
	
    public Contact createContact(String namn, String mejl, String telefonNr){
    	return new Contact(namn, mejl, telefonNr);
    }

	@Override
	public String toString() {
		return "namn: " + namn + "\ntelnr: " + telefonNr + "\nmejl: " + mejl;
	}

	@Override
	public int compareTo(Contact b) {
		Contact a = (Contact) b;
		return getNamn().compareTo(a.getNamn());
	}
}
