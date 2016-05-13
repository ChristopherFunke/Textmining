package einl.test;

import vectorspace.DocumentPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import vectorspace.VectorSpace;

/**
 *
 * @author kai
 */
public class tm {

    public static void main(String[] args) {
        ShakespeareParser sp = new ShakespeareParser();
        AllWorks works = null;
        NLPWrapper nlp = new NLPWrapper();
        VectorSpace vs = new VectorSpace();

        if (args.length == 0) {
            works = sp.readFiles("C:\\Users\\Christopher\\Desktop\\TestOrdner\\ShakespearePlaysPlus\\TXT");
        } else {
            works = sp.readFiles(args[0]);
        }

        // Kleine Rollen rauswerfen...
        int minLength = 0;
        
        List<Speaker> speakers = works.getAllSpeakers();

        
        for(Speaker s: speakers){
        	String text = s.getAllText();
        	String[] sentences = nlp.splitSentence(text);
        	
        	for(String sentence : sentences){
        		String[] tokens = nlp.tokenize(sentence);
        		
        		 List<String> tList = Arrays.asList(tokens);
        		
        		List<String> locations = nlp.findLocation(tList);
        		
        		for(String l: locations){
        			System.out.println(l);
        		}
        		
        		
        	}
        	
        	
        	
        	
        }
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

//        // Vector Space erzeugen
//        for (Speaker speaker : works.getAllSpeakers()) {
//            if (speaker.getAllText().length() < minLength) {
//                continue;
//            }
//            vs.addDocument(speaker.toString(), nlp.tokenize(speaker.getAllText()));
//        }
//
//        System.out.println("Calculating pairs:");
//
//        List<DocumentPair> pairs = new ArrayList<>();
//        for (Speaker speaker : works.getAllSpeakers()) {
//            if (speaker.getAllText().length() < minLength) {
//                continue;
//            }
//            pairs.add(vs.getNearestNeighbour(vs.getDocument(speaker.toString())));
//            System.out.print(".");
//        }
//
//        System.out.println();
//        System.out.println("Done.");
//
//        Collections.sort(pairs);
//        for (DocumentPair p : pairs) {
//        	try{
//        		
//        		System.out.println(p.dv1.getId() + " ---> " + p.dv2.getId() + " (" + p.similarity + ")");
//        	}
//        	catch(Exception e){
//        		
//        	}
        }

    }


