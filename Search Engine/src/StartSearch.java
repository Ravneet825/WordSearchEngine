import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;


public class StartSearch {

	public static void main(String[] args) throws IOException {


			System.out.println("Welcome....");
			System.out.println("Loading data......");
		
			FetchDocuments r = new FetchDocuments();
			DocumentObject[][] a =r.read();

			InputData inputData = new InputData();
			int[][] d= inputData.retriveData();
			
			DocumentObject[][] docStock = new DocumentObject[d.length*2][100];
			
			LinkedHashSet <String> positionMatch = new LinkedHashSet<String>();
			LinkedHashSet <String> documentMatch = new LinkedHashSet <String>();
			LinkedHashSet<String> dataFrequency = new LinkedHashSet<String>();
	
			int count = 0;
			
			for ( int l = 0; l < d.length; l++) {
				for(int m = 0; m < d[l].length; m++) {
	
					docStock[count++] = a[d[l][m]];
					
					
				}
			}

			//For single word search two matching words will be retrieved  and add document with better match
			if (docStock.length == 2) {
				
				ArrayList <Integer> ar = new ArrayList <Integer>();
				
				ArrayList <String> br = new ArrayList <String>();
				
				for( int i = 0; i < docStock.length; i++) {
					for( int j = 0; docStock[i][j] != null; j++) {
						
						ArrayList <Integer> p = new ArrayList <Integer>();
						p = docStock[i][j].getPos();
						ar.add(p.size());
						br.add(docStock[i][j].getDoc());
					}
					
				}
				int n = ar.size();
				int arr[] = new int[n];
				String brr[] = new String[n];
		
				int c =0;
				for ( int z : ar) {
					arr[c++] = z;
				}
				
				c =0;
				for ( String z : br) {
					brr[c++] = z;
				}
		
				
				int temp;
				String temp1;
				for(int i = 0; i < arr.length; i++) {
		    		for ( int j = 0; j < (arr.length)-1; j++) {
		    			if (arr[j] < arr[j+1] ) {
							
							temp = arr[j+1];
							temp1=brr[j+1];
							arr[j+1] = arr[j];
							brr[j+1] = brr[j];
							arr[j] = temp;
							brr[j] = temp1;
		
						}
		    			
		    		}
		    	}
				
				List<String> Freq = Arrays.asList(brr);
				for ( String z : Freq) {
					
					dataFrequency.add(z);		
				}
				
			}
			
			//For multiple words or sentence, retrieve 2 words for each word of sentence and add document with better match
			if (docStock.length > 2) {
				for ( int i = 0; i < (docStock.length - 2); i+=2) {	// depends on number of words
					
					for ( int j = i; j < i+2; j++) {				// comparing 2x2 indices
					
						for( int k = 0; docStock[j][k] != null; k++) {
							//System.out.println("	doc	"+store[j][k].getDoc());
							
							for( int z = j+2 ; z < i+4; z++) {

								for( int x = 0; docStock[z][x] != null; x++) {		
									//System.out.print("	doc	"+store[z][x].getDoc());
									
									if(docStock[j][k].getDoc().equals(docStock[z][x].getDoc())) {
										//doc
										ArrayList <Integer> position = new ArrayList <Integer>();
										ArrayList <Integer> position2 = new ArrayList <Integer>();
										position = docStock[j][k].getPos();
										position2 = docStock[z][x].getPos();
										
										for( int pos : position) {
											int pos2 = pos+1;
										
											if ( (position2.contains(pos2))) {
												//System.out.println("	Pos Check!"+x+"	K	"+k);
												positionMatch.add(docStock[j][k].getDoc());
											}
											else 
												documentMatch.add(docStock[j][k].getDoc());
											
										}
										
									}
								}
							}
						}
		
					}
				
				}
		
				ArrayList <Integer> ar = new ArrayList <Integer>();
		
				ArrayList <String> br = new ArrayList <String>();
				
				for( int i = 0; i < docStock.length; i++) {
					for( int j = 0; docStock[i][j] != null; j++) {
						
						ArrayList <Integer> p = new ArrayList <Integer>();
						p = docStock[i][j].getPos();
						ar.add(p.size());
						br.add(docStock[i][j].getDoc());
					}
					
				}
				int n = ar.size();
				int arr[] = new int[n];
				String brr[] = new String[n];
		
				int c =0;
				for ( int z : ar) {
					arr[c++] = z;
				}
				
				c =0;
				for ( String z : br) {
					brr[c++] = z;
				}
		
				
				int temp;
				String temp1;
				for(int i = 0; i < arr.length; i++) {
		    		for ( int j = 0; j < (arr.length)-1; j++) {
		    			if (arr[j] < arr[j+1] ) {
							
							temp = arr[j+1];
							temp1=brr[j+1];
							arr[j+1] = arr[j];
							brr[j+1] = brr[j];
							arr[j] = temp;
							brr[j] = temp1;
		
						}
		    			
		    		}
		    	}
				
				List<String> Freq = Arrays.asList(brr);
				for ( String z : Freq) {
					
					dataFrequency.add(z);		
				}
			}
		
			System.out.println();
			
			LinkedHashSet <String> demo = new LinkedHashSet<String>();
			
			for ( String check : positionMatch) {
				demo.add(check); 
			}
			for ( String check : documentMatch) {
				demo.add(check); 
			}
			for ( String check : dataFrequency) {
				demo.add(check); 
			}
			
			DocumentFinalOutput de = new DocumentFinalOutput();
			de.dd(demo);
 
		System.out.println("Thank You. Have a Great Day!");
	}
}