import java.util.ArrayList;


public class DocumentObject {

	private String document;
	private ArrayList <Integer> position = new ArrayList <Integer>();
	
    public void DocumentObject() {
		
		document = "";
		position.add(null);
	}
	
	public void setDoc (String doc ) {
		
		document = doc;
		
	}
	
	public void setPos ( Integer pos ) {
		
		position.add(pos);
	}
	
	public String getDoc () {
		
		return document;
	}
	
	public ArrayList <Integer> getPos () {
		
		return position;
	}
	

	
}
