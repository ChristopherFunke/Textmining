package einl.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Einlesen {

   public static void main(String[] args) {
      File myFile = new File("C:\\Users\\Christopher\\Desktop\\TestOrdner\\test.txt");
      if (myFile.exists()) {
         try {
            FileReader fR = new FileReader(myFile);
             BufferedReader bR = new BufferedReader(fR);
             String zeile = null;
             while ((zeile = bR.readLine()) != null) {
                System.out.println(zeile);
             }
             bR.close();
         } catch(Exception ex) {
            //;
         }
      } else { 
         System.out.println("Textdatei nicht gefunden!");
      }
   }
}