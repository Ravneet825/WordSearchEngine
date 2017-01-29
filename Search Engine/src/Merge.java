/**
 * Step 4: Merging the Files and creating a file Data Dictionary.txt 
 */
import java.io.File;
import java.util.Formatter;

public class Merge {
	
	private Formatter x;
	
	public void oFile() {
		try {
			x = new Formatter("Data Dictionary.txt");
				
		}
		catch (Exception e) {
			System.out.println(" Error ");
		}
	}

	// used to merge by comparing the sorted files
	private void merge(In[] streams) { 
		
        int N = streams.length; 
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N); 
        
        for (int i = 0; i < N; i++) 
            if (!streams[i].isEmpty()) 
                pq.insert(i, streams[i].readString()); 

        while (!pq.isEmpty()) {
        
        	x.format("%s", pq.minKey());
			x.format("%s", "\n");
			 
            int i = pq.delMin(); 
            if (!streams[i].isEmpty()) 
                pq.insert(i, streams[i].readString()); 
        
        }
        StdOut.println();
    } 

	// reads the files and implements merge algorithm
	public void gen() { 
    	
		String[] fnames = new String[101];
		
		File dir = new File("WordDocs/");
		File[] files = dir.listFiles();
		
		int counter = 0;
		
		//reading all the files from the splits folder
		for ( File f : files) {
			
			fnames[counter++] = f.getName();
		}
		
		int N = fnames.length; 
        
        In[] streams = new In[N]; 
        
        for (int i = 0; i < N; i++) {
            streams[i] = new In(fnames[i]); 
            System.out.println(fnames[i]);
        }
        
        merge(streams); 
    } 
	
	public void cFile() {
		x.close();
	}
}
