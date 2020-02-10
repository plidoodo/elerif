package lagring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Läsning {
	
	private void readContactsFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\contacts.txt"))) {
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
