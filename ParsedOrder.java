package NuPack;
import java.util.ArrayList;


public class ParsedOrder {
	
	private double BasePrice;
	private int numPeople;
	private ArrayList<String> options = new ArrayList<String>();
	private boolean hasOptions = false;
	
	public ParsedOrder(String[] order) throws Exception{
		validateOrder(order);
		setBasePrice(order[0]);
		setnumPeople(order[1]);
		if(hasOptions){
			createOptions(order);
		}
	}
	
	public void validateOrder(String[] order) throws Exception{
		if(order.length < 3){
			throw new Exception("Please input the order in the format:"
					+ "[price] [#] people [options]");
		}
		if(order.length >= 3 && !(order[2].equals("people") || 
				order[2].equals("person"))){
			throw new Exception("Please input the order in the format:"
					+ "[price] [#] people [options]");
		}
		if(order.length > 3){
			hasOptions = true;
		}
	}
	
	public void createOptions(String[] order){
		for(int i = 3; i < order.length; i++){
			options.add(order[i]);
		}
	}
	
	public void setBasePrice(String s) throws Exception{
		String temp = s.replaceAll("\\$", "");
		double price = Double.parseDouble(temp);
		if(price >= 0){
			BasePrice = price;
		} else{
			throw new Exception("Price cannot be negative.");
		}
	}
	
	public void setnumPeople(String s) throws Exception{
		int ppl = Integer.parseInt(s);
		if(ppl >= 0){
			numPeople = ppl;
		} else{
			throw new Exception("People cannot be negative");
		}
	}
	
	public double getBasePrice(){
		return BasePrice;
	}
	
	public int getnumPeople(){
		return numPeople;
	}
	
	public boolean getHasOptions(){
		return hasOptions;
	}
	
	public ArrayList<String> getOptions(){
		return options;
	}
}
