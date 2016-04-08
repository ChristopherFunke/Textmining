package einl.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Einlesen {

	public static void main(String[] args) {
		File myFile = new File(
				"C:\\Users\\Christopher\\Desktop\\TestOrdner\\ShakespearePlaysPlus\\TXT\\historical\\The First Part of King Henry VI.txt");
		if (myFile.exists()) {
			try {
				FileReader fR = new FileReader(myFile);
				BufferedReader bR = new BufferedReader(fR);
				String zeile = null;
				while ((zeile = bR.readLine()) != null) {
					System.out.println(zeile);
//
//					if (zeile.contains("<")) {
//						continue;
//					}
					
					String patternOpen = "^<(/?)([^/>a-z]+)>";
					String patternClose = "<(//[^<]+)>";
					
					Pattern r = Pattern.compile(patternOpen);
					Pattern r2 = Pattern.compile(patternClose);
					
					Matcher m = r.matcher(zeile);
					Matcher m2 = r2.matcher(zeile);
					
					if(m.find()){
						System.out.println("Found value " + m.group(1));
						}
					
					if(m2.find()){
						System.out.println("Found value"+ m2.group(0));
					}
						
					
				}
				bR.close();
			} catch (Exception ex) {
				// ;
			}
		} else {
			System.out.println("Textdatei nicht gefunden!");
		}
	}
}