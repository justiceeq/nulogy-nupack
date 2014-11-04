package NuPack;
import java.util.ArrayList;
import java.util.Hashtable;

public class MarkupCalculator {
	
	private double basePrice;
	private double flatPrice;
	private double laborMarkup = 0;
	private double optionsMarkup = 0;
	public double finalPrice;
	private Hashtable<String, Double> optionsMarkuplist = 
			new Hashtable<String, Double>();
	
	public MarkupCalculator(double regPrice, int numpeople){
		
		setBasePrice(regPrice);
		calculateFlatPrice(regPrice);
		calculateLaborMarkup(numpeople);
		calculateFinalPrice();
	}
	
	public MarkupCalculator(double regPrice, int numpeople, 
			ArrayList<String> options, Hashtable<String, Double> optionprices){
		
		optionsMarkuplist = optionprices;

		setBasePrice(regPrice);
		calculateFlatPrice(regPrice);
		calculateLaborMarkup(numpeople);
		calculateOptionsMarkup(options);
		calculateFinalPrice();
	}
	
	public void setBasePrice(double BasePrice){
		this.basePrice = BasePrice;
	}
	
	public void calculateOptionsMarkup(ArrayList<String> options){
		double temp = 0;
		for(String e: options){
			if(optionsMarkuplist.containsKey(e)){
				temp += optionsMarkuplist.get(e);
			}
		}
		optionsMarkup = temp * flatPrice;
	}
	
	public void calculateFlatPrice(double regPrice){
		flatPrice = basePrice + (basePrice * 0.05);
	}
	
	public void calculateLaborMarkup(int numpeople){
		laborMarkup = (numpeople * 0.012) * flatPrice;
	}
	
	public void calculateFinalPrice(){
		double temp = flatPrice + laborMarkup + optionsMarkup;
		finalPrice = Math.round(temp * 100);
		finalPrice = finalPrice / 100;
	}
	
	public double getFlatPrice(){
		return flatPrice;
	}
	
	public double getLaborMarkup(){
		return laborMarkup;
	}
	
	public double getOptionsMarkup(){
		return optionsMarkup;
	}
	
	public double getFinalPrice(){
		return finalPrice;
	}
	
}
