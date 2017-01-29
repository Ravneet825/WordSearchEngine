import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class InputData {
	
	public static String[] entry() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your search!");
		String searched = s.nextLine();
		
		List <String> l = new ArrayList <String>();

		StringTokenizer st = new StringTokenizer(searched, " (./;:,*){!@#$%^&}[_+-=|']");
		while ( st.hasMoreTokens()) {
			String a = st.nextToken();
			if(!(a.equalsIgnoreCase("the")) && !(a.equalsIgnoreCase("a")) && !(a.equalsIgnoreCase("an")) && !(a.equalsIgnoreCase("of")) && !(a.equalsIgnoreCase("at")) && !(a.equalsIgnoreCase("to")) && !(a.equalsIgnoreCase("by")) && !(a.equalsIgnoreCase("or")) && !(a.equalsIgnoreCase("and")) && !(a.equalsIgnoreCase("from"))  && !(a.equalsIgnoreCase("is"))  && !(a.equalsIgnoreCase("are"))  && !(a.equalsIgnoreCase("on"))  && !(a.equalsIgnoreCase("but"))  && !(a.equalsIgnoreCase("0"))  && !(a.equalsIgnoreCase("1"))    && !(a.equalsIgnoreCase("2"))    && !(a.equalsIgnoreCase("3"))    && !(a.equalsIgnoreCase("4"))    && !(a.equalsIgnoreCase("5"))    && !(a.equalsIgnoreCase("6"))    && !(a.equalsIgnoreCase("7"))    && !(a.equalsIgnoreCase("8"))    && !(a.equalsIgnoreCase("9"))  ) {
				
				if(!(l.contains(a)))
					l.add(a);
			}
		}
		
		String[] full = l.toArray( new String[l.size()]);
		
		s.close();
		return full;
	}
	
	public static int[][] retriveData() throws FileNotFoundException {
		
		String[] full = entry();
		
		TrieST st = new TrieST();
		String[] a = full;
		for ( int i = 0; i < a.length; i++) {
			a[i] = a[i].toLowerCase();
		}
		String[][] suffix = new String[a.length][2];
		int[][] d = new int[a.length][2];

		for ( int i = 0; i < a.length; i++) {
			
			suffix[i] = st.passing(a[i]);
		}
		
		for ( int i = 0; i < suffix.length; i++) {

			TSTForInput t = new TSTForInput();
			String[] c = suffix[i];
				
			for ( int k = 0; k < c.length; k++) {
				c[k] = c[k].toLowerCase();
			}
					
			d[i] = t.storing(c);
				
		}
		
		return d;
	}

	public static void main(String[] args) throws FileNotFoundException {
		

		int[][] d= retriveData();
		for ( int l = 0; l < d.length; l++) {
			for(int m = 0; m < d[l].length; m++)
				System.out.print("word" +l +"	index:	"+d[l][m] +":");
		System.out.println("length"+d.length);
		}
	}
		
}


