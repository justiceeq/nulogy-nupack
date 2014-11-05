package NuPack;
import java.util.Hashtable;


public class MarkupOptionList {
	
	private Hashtable<String, Double> MarkupOptions = 
			new Hashtable<String, Double>();
	
	public void addOption(String name, double price) throws Exception{
		if(price >= 0){
			MarkupOptions.put(name, price);
		}else{
			throw new Exception("Option prices should not be negative.");
		}
	}
	
	public Hashtable<String, Double> getOptionsList(){
		return MarkupOptions;
	}

}
