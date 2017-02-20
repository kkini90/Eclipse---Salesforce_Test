import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CoffeeShopFinderTestCase {

	private CoffeeShopFinder finder;
	
	@Before
	public void init() {
		finder = new CoffeeShopFinder();
	}
	
	@Test
	public void malformedCSVIsHandled() {
		boolean thrown = false;
		String [] args = {"43=6.7", "-122.4", "MalformedCoffeeShops.csv"};
		try {
			finder.find(args);
		} catch (Exception exception) {
			thrown = true;
		}
		
		assertTrue(thrown);
	} 
	
	
	@Test
	public void lessThan3EntriesInCsvAreHandled () {
		boolean thrown = false;
		String [] args = {"47.6", "-122.4", "CoffeeShopsNotMoreThan3.csv"};
		try {
			List list = finder.find(args);
			assertTrue(list.size() < 3);
		} catch (Exception exception) {
			thrown = true;
		}
		
		assertEquals(thrown, false);
	}
}
