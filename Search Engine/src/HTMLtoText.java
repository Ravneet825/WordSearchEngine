
/**
 * Step 0: Convert html files in web folder to txt files
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class HTMLtoText extends HTMLEditorKit.ParserCallback {
 StringBuffer s;

 public HTMLtoText() {}

 public void parse(Reader in) throws IOException {
   s = new StringBuffer();
   ParserDelegator delegator = new ParserDelegator();
   delegator.parse(in, this, Boolean.TRUE);
 }

 public void handleText(char[] text, int pos) {
   s.append(text);
 }

 public String getText() {
   return s.toString();
 }

 // converts  html document to  text document
 public static void convert( String a ) throws IOException  {
	 
	 FileReader in = new FileReader(a);
     HTMLtoText parser = new HTMLtoText();
     parser.parse(in);
     in.close();
     String textHTML = parser.getText();
     
     String b = a.substring(0,a.indexOf(".")); 	
     // Write the text to a file  
     BufferedWriter writerTxt = new BufferedWriter(new FileWriter(b+".txt"));	 
     writerTxt.write(textHTML);
     writerTxt.close();
 }
 
 public static void main (String[] args) {
   try {
	 File dir = new File("C://Users//upraj singh bhullar//Documents//Ravneet//Courses- Sem1//ACC-Lab//W3C Web Pages (1)/");	// reads files from the Web folder
	 File[] files = dir.listFiles();  
	 
	 for ( File f : files) {
		 
		 String param1 = f.getName();
		 convert(param1);			
		 System.out.println("Processing: "+param1);
	 }
     
   }
   catch (Exception e) {
     e.printStackTrace();
   }
 }
}