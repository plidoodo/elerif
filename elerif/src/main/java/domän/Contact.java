package domän;

public class Contact {
	
	ContactBook cb = new ContactBook();
	private String namn;
	private int telefonNr;
	private String mejl;
	
	public Contact(String namn, String mejl, int telefonNr) {
		this.namn = namn;
		this.mejl = mejl;
		this.telefonNr = telefonNr;
	}

	public String getNamn() {
		return namn;
	}

	public int getTelefonNr() {
		return telefonNr;
	}

	public String getMejl() {
		return mejl;
	}
	
    public Contact createContact(String namn, String mejl, int telefonNr){
    	return new Contact(namn, mejl, telefonNr);
    }

	@Override
	public String toString() {
		return "------------------------- \nnamn: " + namn + "\ntelnr: " + telefonNr + "\nmejl: " + mejl;
	}
    

}
