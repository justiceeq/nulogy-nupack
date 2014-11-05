package NuPack;

public class npmain {

	public static void main(String[] args) throws Exception {

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
			System.out.println("$" + markup.getFinalPrice());
		}else{
			MarkupCalculator markup = new MarkupCalculator(
					neworder.getBasePrice(),
					neworder.getnumPeople());
			System.out.println("$" + markup.getFinalPrice());
		}
	}
}
