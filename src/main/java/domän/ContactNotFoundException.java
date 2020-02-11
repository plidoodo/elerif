package domän;

public class ContactNotFoundException extends Exception	 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
