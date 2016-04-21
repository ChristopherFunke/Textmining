package einl.test;


import java.util.List;


/**
 *
 * @author kai
 */
public class Monologue {
    private Speaker speaker;
    private List<String> path;
    private String text;

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Monologue{" + "speaker=" + speaker + ", path=" + path + ", text=" + text + "}\n";
    }
    
    

        
    
}
