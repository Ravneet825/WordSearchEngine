import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;


public class Generate {

	private static Formatter x;
	
	// creating  file to store inverted index
	public static void open() {
		try {
			x = new Formatter("Ref.txt");
				
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
		
		for ( int j = 0; j < a.length; j++) {
			
			String c = a[j][1];
			System.out.println(c);
			x.format("%s", a[j][0]);
			x.format("%s", " ");
			x.format("%s", a[j][1]);
			x.format("%s", " ");
			
			int counter =1;
			
			for ( File f : files) {
				
				
				
				ReadFile2 r2 = new ReadFile2();
				String param1 = f.getName();
								
				String[] b = r2.read(param1);
				
				List <String> l = new ArrayList <String>();
				String document = "D"+counter;
				l.add(document);
				
				for ( int i = 0; i < b.length; i++) {
					
					if ( c.equalsIgnoreCase(b[i])) {
						String add = i+"";
						l.add(add);
						
					}
				}
				
				String[] full = l.toArray( new String[l.size()]);
				if( full.length > 1) {
					
					x.format("%s", full[0]);
					x.format("%s", " : ");
					
					for( int k = 1; k < full.length; k++) {
						
						x.format("%s", full[k]);
						x.format("%s", " ");
						
					}
				
					x.format("%s", " , ");
					
				}
				
				
				counter++;
				
			}
			x.format("%s", "\n");
			
		}
			
			
			
		
		closeFile();
	}

}
