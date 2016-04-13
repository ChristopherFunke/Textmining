package einl.test;

/**
 *
 * @author kai
 * 
 */
public class tm {
    
    public static void main(String[] args) {
        Einlesen sp = new Einlesen();
        Work work = null;
        if (args.length==0) {
            work = sp.readfile("C:\\Users\\Christopher\\Desktop\\TestOrdner\\ShakespearePlaysPlus\\TXT\\historical\\The First Part of King Henry IV.txt");
        } else {
            work = sp.readfile(args[0]);
        }
        
        for (String name: work.getSpeakers()) {
            System.out.println(name + ": " + work.getNumberOfMonologuesBySpeaker(name) + " times, " + work.getWordsBySpeaker(name) + " words, " + work.getWordsBySpeaker(name)/work.getNumberOfMonologuesBySpeaker(name) + " words per monologue.");
        }
        
        
    }
    
}