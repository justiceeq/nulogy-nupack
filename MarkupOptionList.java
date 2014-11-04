package NuPack;
import java.util.Hashtable;


public class MarkupOptionList {
	
	private Hashtable<String, Double> MarkupOptions = 
			new Hashtable<String, Double>();
	
	public void addOption(String name, double price){
		MarkupOptions.put(name, price);
	}
	
	public Hashtable<String, Double> getOptionsList(){
		return MarkupOptions;
	}

}
