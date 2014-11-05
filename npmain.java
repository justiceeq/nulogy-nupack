package NuPack;

public class npmain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < args.length; i++){
			System.out.print(args[i] + " ");
		}
		MarkupOptionList markups = new MarkupOptionList();
		markups.addOption("food", 0.13);
		markups.addOption("drugs", 0.075);
		markups.addOption("electronics", 0.02);
		
		ParsedOrder neworder = new ParsedOrder(args);
		
		if(neworder.getHasOptions()){
			MarkupCalculator markup = new MarkupCalculator(
					neworder.getBasePrice(),
					neworder.getnumPeople(), 
					neworder.getOptions(), 
					markups.getOptionsList());
			System.out.println("");
			System.out.println("Base Price: " + neworder.getBasePrice());
			System.out.println("Marked up price: " + markup.getFlatPrice());
			System.out.println("Labor markup: " + markup.getLaborMarkup());
			System.out.println("Options markup: " + markup.getOptionsMarkup());
			System.out.println("Number of people: " + neworder.getnumPeople());
			System.out.println("Has options? " + neworder.getHasOptions());
			System.out.println("Options: " + neworder.getOptions());
			System.out.println("Final Price: $" + markup.getFinalPrice());
		}else{
			MarkupCalculator markup = new MarkupCalculator(
					neworder.getBasePrice(),
					neworder.getnumPeople());
			System.out.println("");
			System.out.println("Base Price: " + neworder.getBasePrice());
			System.out.println("Marked up price: " + markup.getFlatPrice());
			System.out.println("Labor markup: " + markup.getLaborMarkup());
			System.out.println("Options markup: " + markup.getOptionsMarkup());
			System.out.println("Number of people: " + neworder.getnumPeople());
			System.out.println("Has options? " + neworder.getHasOptions());
			System.out.println("Options: " + neworder.getOptions());
			System.out.println("Final Price: $" + markup.getFinalPrice());
		}
	}
}
