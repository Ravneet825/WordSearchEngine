import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// read from pointer file
public class ReadFile3 {

	Scanner s;

	public String[][] reading() throws FileNotFoundException {
		
		String full[][] = new String[11496][2];//14395
		s = new Scanner( new File("D:\\eclipse\\workspace\\Search Engine\\Pointer.txt"));
		
		int counter = 0;
		while (s.hasNext()) {
			full[counter][0] = s.next();
			full[counter][1] = s.next();
			counter++;
			
		}

		return full;
	}
	
}
