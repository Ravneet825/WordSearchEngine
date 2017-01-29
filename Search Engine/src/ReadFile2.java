/**
 * 	 reads the data dictionary and returns a string
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile2 {

	
	Scanner s;
	public String readFile(String a) throws FileNotFoundException {
		
		String full = "";
		s = new Scanner( new File(a));
		while ( s.hasNext()) {
			full  = full + s.next();
			full = full + " ";
		}
		
		s.close();
		
		return full.replace("\"", ""); // replaces " " with a null
		
		
	}
	
	// reads the data dictionary and returns a array of strings
		public void reading() throws FileNotFoundException {
			
			String full[] = new String[11496];//14395
			s = new Scanner( new File("Re-Gen.txt"));
			
			int counter = 0;
			while (s.hasNext()) {
				String a = s.next();
				if (a.length() == 2)
					System.out.println(a);
				full[counter++] = a;
			}
		}
		
		
		public String[] read( String a) throws FileNotFoundException {
			
			String alpha = readFile(a);
			List <String> l = new ArrayList <String>();
			
			StringTokenizer st = new StringTokenizer(alpha, " (./;:,*){!@#$%^&}[_+-=|']");
			while ( st.hasMoreTokens()) {
				l.add(st.nextToken());
				
			}
			s.close();
			
			String[] full = l.toArray( new String[l.size()]);
			return full;
			
			
		}
}
