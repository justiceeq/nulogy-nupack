package NuPack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MarkupCalculatorTest {
	
	private MarkupOptionList optionprices;
	private ArrayList<String> testalloptions;
	private ArrayList<String> testoneoption;
	private double epsilon = 0.001;
	
	@Before
	public void setUp() throws Exception{
		optionprices = new MarkupOptionList();
		optionprices.addOption("food", 0.13);
		optionprices.addOption("drugs", 0.075);
		optionprices.addOption("electronics", 0.02);
		
		testalloptions = 
				new ArrayList<String>(Arrays.asList(
						"food", "drugs", "electronics"));

		testoneoption = 
				new ArrayList<String>(Arrays.asList("food"));
	}


	@Test
	public void testCalculateOptionsMarkup() {
		MarkupCalculator noOptions = new MarkupCalculator(8.95, 4);
		assertEquals(0, noOptions.getOptionsMarkup(), epsilon);
		
		MarkupCalculator oneOption = new MarkupCalculator(
				8.95, 4, testoneoption, optionprices.getOptionsList());
		assertEquals(oneOption.getFlatPrice()*0.13, 
				oneOption.getOptionsMarkup(), epsilon);
		
		MarkupCalculator allOptions = new MarkupCalculator(
				8.95, 4, testalloptions, optionprices.getOptionsList());
		assertEquals(allOptions.getFlatPrice()*0.225, 
				allOptions.getOptionsMarkup(), epsilon);
	}

	@Test
	public void testCalculateFlatPrice() {
		double expected = 8.95 + (8.95*0.05);
		
		MarkupCalculator noOptions = new MarkupCalculator(8.95, 4);
		assertEquals(expected, noOptions.getFlatPrice(), epsilon);
		
		MarkupCalculator allOptions = new MarkupCalculator(
				8.95, 4, testalloptions, optionprices.getOptionsList());
		assertEquals(expected, allOptions.getFlatPrice(), epsilon);
	}

	@Test
	public void testCalculateLaborMarkup() {
		double expected = 0;
		
		MarkupCalculator noPeople = new MarkupCalculator(8.95, 0);
		assertEquals(expected, noPeople.getLaborMarkup(), epsilon);
		
		MarkupCalculator onePerson = new MarkupCalculator(8.95, 1);
		expected = onePerson.getFlatPrice()*0.012;
		assertEquals(expected, onePerson.getLaborMarkup(), epsilon);
		
		MarkupCalculator multiplePeople = new MarkupCalculator(
				8.95, 4, testalloptions, optionprices.getOptionsList());
		expected = multiplePeople.getFlatPrice()*(0.012*4);
		assertEquals(expected, multiplePeople.getLaborMarkup(), epsilon);
	}

	@Test
	public void testCalculateFinalPrice() {
		double expected = 9.62;
		
		MarkupCalculator noOptions = new MarkupCalculator(8.95, 2);
		assertEquals(expected, noOptions.getFinalPrice(), epsilon);
		
		expected = 1591.58;
		MarkupCalculator oneOption = new MarkupCalculator(
				1299.99, 3, testoneoption, optionprices.getOptionsList());
		assertEquals(expected, oneOption.getFinalPrice(), epsilon);
		
		expected = 1721.25;
		MarkupCalculator multipleOptions = new MarkupCalculator(
				1299.99, 3, testalloptions, optionprices.getOptionsList());
		assertEquals(expected, multipleOptions.getFinalPrice(), epsilon);
		
	}

}
