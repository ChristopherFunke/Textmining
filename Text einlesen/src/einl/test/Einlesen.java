package einl.test;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Einlesen {

	public Work readfile(String filename) {
		Work work = new Work();
		String ganzertext ="";
		

		
			try {

				BufferedReader bR = new BufferedReader(
						new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_16LE));
				String zeile = null;
				StringBuilder builder = new StringBuilder();

				while ((zeile = bR.readLine()) != null) {

					builder.append(zeile).append("\n");

				}

				 ganzertext = builder.toString();

				// Hier wird STAGE DIR entfernt
				String stagedir = "<STAGE DIR>[\\n\\w\\W\\s]*?</STAGE DIR>";
				Pattern p1 = Pattern.compile(stagedir);
				Matcher m1 = p1.matcher(ganzertext);
				ganzertext = m1.replaceAll("\t");

				
				
				 StringBuffer tmp = new StringBuffer();
				 List<String> path = new ArrayList<>();
				 
			        for (String aktuelleZeile : ganzertext.split("\n")) {
			           
			            Pattern r = Pattern.compile("^<(/?)([^/>a-z]+)>");
			            Matcher m = r.matcher(aktuelleZeile);
			            
			            if(m.find()){
			            	boolean starttag = !m.group(1).equals("/");
			            	
			            	String tagname = m.group(2);
			            	
			            	if(starttag){
			            		
			            		path.add(tagname);
			            	}
			            	else if(path.size() > 0 && tagname.equals(path.get(path.size() - 1))){
			            		
			            		Monolog monolog = new Monolog();
			            		monolog.setmonologText(tmp.toString().trim());
			            		monolog.setsprecher(tagname);
			            		monolog.setPfad(new ArrayList<String>());
			            		tmp.setLength(0);
			            		path.remove(path.size()-1);
			            		
			            		if(monolog.getmonologText().length()>0){
			            			work.add(monolog);
			            		}
			            		
			            		}
			            		
			            		
			            		
			            		//System.out.println(tmp.toString());
			            }
			            else{
			            	if(aktuelleZeile.startsWith("\t") ){
			            		tmp.append(aktuelleZeile.replaceFirst("\t"," "));
			            		
			            	}
			            }
			            
			            
			            
				
			        }
				
			      
				
				
							
				bR.close();
			} catch (Exception ex) {

			}
			return work;
			
			
			

		

		

	}
}

// String patternClose = "</([^>]+)>";
// Pattern r2 = Pattern.compile(patternClose);
// Matcher m2 = r2.matcher(zeile);
// if(m2.find()){
// System.out.println("Found value"+ m2.group(0));
// }
//
//				String patternOpen = "<([^/>a-z]+)>";
//				Pattern r = Pattern.compile(patternOpen);
//				Matcher m = r.matcher(ganzertext);
//			
//				if (m.find()) {
//					System.out.println("Found value " + m.group(0));
//				}