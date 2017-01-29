/**
 * Step 8 - Generating Pointers file
 */
import java.io.FileNotFoundException;
import java.util.Formatter;


public class Pointer {

	private static Formatter x;

	public static void open() {
		try {
			x = new Formatter("Pointer.txt");
			
			
		}
		catch (Exception e) {
			System.out.println(" Error ");
		}
	}
	
	public static void closeFile() {
		x.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		TST tst = new TST();
		String [][] storing = tst.storing();

		open();
		for ( int i = 0; i < 11496; i++) {
			
			x.format("%s", storing[i][0]);
			x.format("%s", "	");
			x.format("%s", storing[i][1]);
			x.format("%s", "\n");
		}
			
		closeFile();
	}

}
