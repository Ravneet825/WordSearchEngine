/**
* Step 3 - Generating Data DIctionary
 * main function to generate the files containing each word without duplicates for each text file
 */
// 
import java.io.File;

public class GeneratingWordDocFiles {

	public static void main(String[] args) {
		
		
		File dir = new File("Text/");
		File[] files = dir.listFiles();
		
		WriteFile wf = new WriteFile();
		
		int counter = 1;
		
		for ( File f : files) {
			
			String param1 = f.getName();
			String name = "D"+counter+".txt";
			counter++;
			wf.open(name);
			wf.write(param1);
			wf.closeFile();		

		}

	}
}
