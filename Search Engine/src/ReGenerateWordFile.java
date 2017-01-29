import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class ReGenerateWordFile {

	
	static Scanner s;
	static Formatter x;
	
	public static void write() {
		try {
			
			x = new Formatter("Re-Gen.txt");
			
		}
		catch (Exception e) {
			System.out.println(" Error ");
		}
	}
	
	public static ArrayList<String> read() throws FileNotFoundException {
		
		ArrayList<String> a = new ArrayList<String>();
		LinkedHashSet<String> h = new LinkedHashSet<String>();
		
		s = new Scanner( new File("D:\\eclipse\\workspace\\Search Engine\\New Data Dictionary.txt"));
		while (s.hasNext()) {
			
			String b = s.next();
				h.add(b.toLowerCase());
			
		}
		for ( String x : h )
			a.add(x);
		
		Collections.sort(a);

		s.close();
		return a;		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> l = new ArrayList<String>();
		 
		l = read();
		write();
		for (String a : l) {
			
			x.format("%s", a);
			x.format("%s", "\n");
			
		}
		x.close();
	}

}
