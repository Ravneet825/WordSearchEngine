/**
 * Step 2 - creating  files to store the words for each file
 */
import java.util.Formatter;

public class WriteFile {

private Formatter x;
	
		public void open( String a) {
			try {
				x = new Formatter(a);
				
			}
			catch (Exception e) {
				System.out.println(" Error ");
			}
		}
		
		// to write the content in the file
		public void write( String b)  {
			
			
			ReadFile rf = new ReadFile();
			rf.openFile(b);
			String[] store = rf.readFile();
			rf.closeFile();
			
			for ( int i = 0; i < store.length; i++) {
				x.format("%s", store[i]);
				x.format("%s", "\n");
			
			}
			closeFile();
		}
		
		public void closeFile() {
			x.close();
		}
}
