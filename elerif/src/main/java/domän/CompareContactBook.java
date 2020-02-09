package domän;

import java.util.Comparator;

public class CompareContactBook implements Comparator<Contact>{

	@Override
	public int compare(Contact a, Contact b) {
		
		return a.getNamn().compareTo(b.getNamn());
	}

}
