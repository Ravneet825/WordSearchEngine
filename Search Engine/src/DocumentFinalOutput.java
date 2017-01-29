import java.io.File;
import java.util.LinkedHashSet;


public class DocumentFinalOutput {

	public void dd( LinkedHashSet<String> lhs) {	
		
		File dir = new File("Text/");
		File[] files = dir.listFiles();
		String[][] doclist = new String [101][2];
		
		int counter =0;

		for ( File f : files) {
			String doc = "D";
			doclist[counter][1] = f.getName();
			doclist[counter][0] = doc + (counter+1);
			counter++;
			
		}
		int count = 1;
		System.out.println("List of Files containing words of your search");
		System.out.println("------------------------------------------------------------------------------------");
		
		for ( String a : lhs ) {
			for ( int i = 0; i < doclist.length; i++) {
				if ( a.equals(doclist[i][0])) {					
					System.out.println("File Number: "+count +",  "+doclist[i][1]);
					count++;
				}
			}
		}
		
	}

}
