import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FetchDocuments {

	static Scanner s;
	
	public static DocumentObject[][] read() throws FileNotFoundException {
		
		s= new Scanner( new File("Index.txt")); 
		DocumentObject[][] store = new DocumentObject[11496][100]; //11496

		while(s.hasNextLine()) {
			
			int count = 0;
			
			
			String second = "";
			String idx = s.nextLine();	// entire line
			
			String[] d2 = idx.split(" ");
			
		    int first = Integer.parseInt(d2[0]);	// index
		    		    
		    for (int i = 3; i< d2.length; i++) {
		    	
		    	second = second + d2[i];
		    	second = second + " ";
		    	
		    }

		    
		    while ( second.length() >= 4  ) {
		    	
		    	DocumentObject d = new DocumentObject();
		    	
		    	
		    	
		    	String third = "";
		    	String fourth = "";
		    	
		    	third = second.substring(0, second.indexOf(","));
		    	fourth = second.substring((second.indexOf(",") + 1), second.length());
		    			    	
		    	String[] d4 = third.split(" ");
		    	d.setDoc(d4[1]);				// rest of the doc details

		    	for( int k = 3; k < d4.length; k++) {

		    		int a = Integer.parseInt(d4[k]);
		    		d.setPos(a);		// setting positions
		    	}
		    	
		    	store[first][count] = d;					// storing positions
		    	count++;
		    	

		    	second = fourth;
		    }	    
		}
		/*
			for(int i = 0; i <9; i++) {
				System.out.println("Index: " +i);
				for( int j = 0; store[i][j] != null; j++) {
					
					System.out.println("p1: " +(store[i][j].getDoc()));
					System.out.println("p2: " +(store[i][j].getPos()));
				}
				
			}
		*/
		close();
		return store;
	}
	
	public static void close() {
		
		s.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {

		DocumentObject[][] a =read();
		
		for( int j = 0; a[14][j] != null; j++) {
			
			System.out.println("p1: " +(a[14][j].getDoc()));
			System.out.println("p2: " +(a[14][j].getPos()));
		}
		
		close();
	}

}
