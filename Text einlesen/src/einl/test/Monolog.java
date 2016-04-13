package einl.test;


import java.util.List;
public class Monolog {
	
	private String sprecher;
	private String monologText;
	private List<String> pfad;
	
	
	
	public void setsprecher (String sprecher){
		this.sprecher = sprecher;
	}
	public String getsprecher(){
		return sprecher;
	}

	public void setmonologText(String monologText){
		this.monologText = monologText;
	}
	
	public String getmonologText(){
		return monologText;
	}
	
	public List<String> getPfad() {
		return pfad;
	}
	public void setPfad(List<String> pfad) {
		this.pfad = pfad;
	}
	
	@Override
    public String toString() {
        return "Monolog{" + "Sprecher= " + sprecher + ", path=" + pfad + ", text= " + monologText + "}\n";
    }
	
	
}


