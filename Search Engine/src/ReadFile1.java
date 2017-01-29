/**
 *  Step 6 - reading from data dictionary and creating the new file which does not contain duplicate entries
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile1 {
	
	Scanner s;

	public String readFile() throws FileNotFoundException {
		
		String full = "";
		while ( s.hasNext()) {
			full  = full + s.next();
			full = full + " ";
		}
		
		s.close();
		
		return full;
		
		
	}
	
	public String[] reading() throws FileNotFoundException {
		
		String full[] = new String[11496];//11496
		s = new Scanner( new File("Re-Gen.txt"));//Re-Gen.txt
		int counter = 0;
		while (s.hasNext()) {
			full[counter++] = s.next();
		}
		s.close();
		return full;
	}
	
	
	public String[] read() throws FileNotFoundException {
		
		String[] full = new String[395];
		int count = 0;
		String alpha = readFile();
		
		StringTokenizer st = new StringTokenizer(alpha, " (./;:,*){!@#$%^&}[_+-=|']");
		while ( st.hasMoreTokens()) {
			full[count++]  = st.nextToken();
			
		}
		System.out.println(count);
		s.close();
		
		return full;
		
		
	}

}
