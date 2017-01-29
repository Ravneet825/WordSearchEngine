/**Step 5 - Merging and building dictionary 
 */
public class Execute {

	
	public static void main(String[] args) {

		WriteFile wf = new WriteFile();
		String a = "New Data Dictionary.txt";
		String b = "Data Dictionary.txt";

		wf.open(a);
		wf.write(b);
		wf.closeFile();
				
	}

}
