package einl.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kai
 */
public class Work {
    private List<Monologue> monologues = new ArrayList<>();
    private Map<Speaker, List<Monologue>> bySpeaker = new HashMap<>();
    
    public Work() {
    }
    
    public List<Speaker> getSpeakers() {
        List<Speaker> res = new ArrayList<>();
        res.addAll(bySpeaker.keySet());
        Collections.sort(res, 
                (name1, name2) -> bySpeaker.get(name2).size() - bySpeaker.get(name1).size()
        );
        return res;
    }
    
    public void add(Monologue m) {
        monologues.add(m);
        bySpeaker.putIfAbsent(m.getSpeaker(), new ArrayList<Monologue>());
        bySpeaker.get(   m.getSpeaker()   )     .add(m);
    }
    
    public int getWordsBySpeaker(Speaker speaker) {
        int sum = 0;
        for (Monologue m: bySpeaker.get(speaker)) {
            sum += m.getText().split(" ").length;
        }
        return sum;
    }
    
    public int getTimesOneWordIsSaid(Speaker speaker){
    	int summe = 0;
    	String word;
    	for(Monologue m: bySpeaker.get(speaker)){
    		word = m.getText().split(" ").toString();
    		if(word=="and"){
    			summe++;
    		}
    		
    	}
    	
		return summe;
    	
    }
    
    public int getNumberOfMonologuesBySpeaker(Speaker speaker) {
        return bySpeaker.get(speaker).size();
    }

}
