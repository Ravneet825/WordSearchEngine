/**
 * Step: 9 Generating index file which will store index of words along with documents and position in documents
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;


public class GenerateIndexFile {
	
	private static Formatter x;
	
	public static void open() {
		try {
			x = new Formatter("Index.txt");
				
		}
		catch (Exception e) {
			System.out.println(" Error ");
		}
	}
		
	public static void closeFile() {
		x.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ReadFile3 r3 = new ReadFile3();
		String[][] a = r3.reading();
		
		open();
		
		File dir = new File("Text/");
		File[] files = dir.listFiles();
		
		String [][] b = new String[101][2];
		int counter = 0;
		
		for ( File f : files) {
			
			ReadFile2 r2 = new ReadFile2();
			String param1 = f.getName();

			b[counter] = r2.read(param1);
			
			counter++;
		
		}
		
		for ( int j = 0; j < a.length; j++) {
			
			String c = a[j][1];

			x.format("%s", a[j][0]);
			x.format("%s", " .");
			x.format("%s", " ");
			x.format("%s", a[j][1]);
			x.format("%s", " /");
			x.format("%s", " ");
			
			int count =1;
				
			for ( int i = 0; i < 101; i++) { 
					
				List <String> l = new ArrayList <String>();
				String document = "D"+count;
				l.add(document);
				
				for ( int p = 0; p < b[i].length; p++) {
					//System.out.println(b[i][p]);
					if ( c.equalsIgnoreCase(b[i][p])) {
						
						// for keeping track of progress
						System.out.println("Searching:  " +c + "  In File:  " +document + "  Processing Currently:  "+b[i][p]);
							
						String add = p+"";
						l.add(add);
						
					}
				}
			
				
				String[] full = l.toArray( new String[l.size()]);
				
				if( full.length > 1) {
					
					x.format("%s", full[0]);
					x.format("%s", " : ");
					
					for( int q= 1; q < full.length; q++) {
						
						x.format("%s", full[q]);
						x.format("%s", " ");
						
					}
				
					x.format("%s", " , ");
					
				}
				
				count++;
				
			}
			x.format("%s", "\n");
			
		}
		
		closeFile();
	}
	
}
