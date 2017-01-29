/**
 * Step 1 - Reading the txt files
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ReadFile {
	
	private static Scanner x;
	
	// checks if the file exists or not
	public void openFile( String a ) {
			
		try	{
			
			x = new Scanner( new File(a));

		}
		
		catch (Exception e) {
			
			System.out.println(" File does not exist");
		}
		
	}
	
	// if file exists, reads the content of the file and returns an array of non repeated words
	public String[] readFile() {
		
		// to store the content of the file as a string
		String t = "";
		List <String> l = new ArrayList <String>();
		
		while(x.hasNext()) {
			
			t = t + x.next();
			t = t + " ";
		}
		
		// Stringtokenizer to separate the words
		StringTokenizer st = new StringTokenizer(t, " (./;:,*){!@#$%^&}[_+-=|']");
		while (st.hasMoreTokens()) {
			String b = st.nextToken();
			if(!(l.contains(b)))
				l.add(b);
		}
		
		// sorts the words lexicographically
		Collections.sort(l);
		String[] array = l.toArray( new String[l.size()]);

		return array;
		
	}
	
	public void closeFile() {
		
		x.close();
	}

}
