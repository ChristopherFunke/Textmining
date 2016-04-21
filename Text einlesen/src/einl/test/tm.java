package einl.test;

/**
 *
 * @author kai
 */
public class tm {
    
    public static void main(String[] args) {
        ShakespeareParser sp = new ShakespeareParser();
        AllWorks works = null;
        if (args.length==0) {
            works = sp.readFiles("C:\\Users\\Christopher\\Desktop\\TestOrdner\\ShakespearePlaysPlus\\TXT");
        } else {
            works = sp.readFiles(args[0]);
        }
            for (Speaker speaker: works.getAllSpeakers()) {
                System.out.println(speaker.getName() + ": " + speaker.getNumberOfMonologues() + " times, " + speaker.getNumberOfWords() + " words, " + speaker.getNumberOfWords()/speaker.getNumberOfMonologues() + " words per monologue.");
            }
        	
//        	for (Speaker speaker: works.getAllSpeakers()){
//        		System.out.println(speaker.getName()+ ", says the word and: "+ speaker.getTimesOneWordIsSaid()+" times");
//        	}
//        
        
    }
    
}
