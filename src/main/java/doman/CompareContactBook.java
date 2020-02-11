package doman;

import java.util.Comparator;

public class CompareContactBook implements Comparator<Contact>{

	//Metod för att jämföra objekten Contact
	//Används i sort metoden
	@Override
	public int compare(Contact a, Contact b) {
		
		return a.getNamn().compareTo(b.getNamn());
	}

}
