package NuPack;

import org.junit.Test;

import junit.framework.TestCase;

public class ParsedOrderTest extends TestCase {
	
	private double epsilon = 0.001;
	
	@Test
	public void testValidateOrderOptions() throws Exception{
		String[] order1 = {"$1500", "3", "people", "option1", "option2"};
		ParsedOrder a = new ParsedOrder(order1);
		assertTrue(a.getHasOptions());
		
		String[] order2 = {"$1500", "3", "people"};
		ParsedOrder b = new ParsedOrder(order2);
		assertFalse(b.getHasOptions());
	}
	
	@Test
	public void testValidateOrderExceptions() throws Exception{
		String[] order1 = {"$1413", "3"};
		boolean caughtException = false;
		try{
			ParsedOrder a = new ParsedOrder(order1);
		}catch(Exception e){
			caughtException = true;
		}
		assertTrue(caughtException);
	}

	@Test
	public void testSetBasePrice() throws Exception {
		String[] order1 = {"$1500", "3", "people"};
		ParsedOrder a = new ParsedOrder(order1);
		
		assertEquals(1500.0, a.getBasePrice(), epsilon);
	}
	
	@Test
	public void testSetBasePriceExceptions() throws Exception{
		String[] order1 = {"$-1500", "3", "people"};
		boolean caughtException = false;
		try{
			ParsedOrder a = new ParsedOrder(order1);
		}catch(Exception e){
			caughtException = true;
		}
		assertTrue(caughtException);
	}

	@Test
	public void testSetNumPeople() throws Exception {
		String[] order1 = {"$1500", "15", "people"};
		ParsedOrder a = new ParsedOrder(order1);
		
		assertEquals(15, a.getnumPeople());
	}
	
	@Test
	public void testSetNumPeopleExceptions() throws Exception{
		String[] order1 = {"$1500", "-4", "people"};
		boolean caughtException = false;
		try{
			ParsedOrder a = new ParsedOrder(order1);
		}catch(Exception e){
			caughtException = true;
		}
		assertTrue(caughtException);
	}
	
	@Test
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
