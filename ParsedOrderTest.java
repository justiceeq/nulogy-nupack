package NuPack;

import org.junit.Test;

import junit.framework.TestCase;

public class ParsedOrderTest extends TestCase {
	
	
	public void testValidateOrderOptions() throws Exception{
		String[] order1 = {"$1500", "3", "people", "option1", "option2"};
		ParsedOrder a = new ParsedOrder(order1);
		assertTrue(a.getHasOptions());
		
		String[] order2 = {"$1500", "3", "people"};
		ParsedOrder b = new ParsedOrder(order2);
		assertFalse(b.getHasOptions());
	}
	
	public void testValidateOrderExceptions() throws Exception{
		String[] order1 = {"$1413", "3"};
		try{
			ParsedOrder a = new ParsedOrder(order1);
		}catch(Exception e){
			System.out.println("passed");
		}
	}

	public void testSetBasePrice() throws Exception {
		String[] order1 = {"$1500", "3", "people"};
		ParsedOrder a = new ParsedOrder(order1);
		
		assertEquals(1500.0, a.getBasePrice());
	}
	
	public void testSetBasePriceExceptions() throws Exception{
		String[] order1 = {"$-1500", "3", "people"};
		try{
			ParsedOrder a = new ParsedOrder(order1);
		}catch(Exception e){
			System.out.println("asfa");
		}
	}

	public void testSetNumPeople() throws Exception {
		String[] order1 = {"$1500", "15", "people"};
		ParsedOrder a = new ParsedOrder(order1);
		
		assertEquals(15, a.getnumPeople());
	}
	
	public void testSetNumPeopleExceptions() throws Exception{
		String[] order1 = {"$1500", "-4", "people"};
		try{
			ParsedOrder a = new ParsedOrder(order1);
		}catch(Exception e){
			System.out.println("fuck");
		}
	}
	
	public void testCreateOptions() throws Exception{
		String[] order1 = {"1256125.22", "2", "people", "socks", "drugs",
				"dogs"};
		ParsedOrder a = new ParsedOrder(order1);
		assertEquals(3, a.getOptions().size());
		assertEquals("socks", a.getOptions().get(0));
		
		String[] order2 = {"1256125.22", "2", "people"};
		ParsedOrder b = new ParsedOrder(order2);
		assertEquals(0, b.getOptions().size());
	}

}