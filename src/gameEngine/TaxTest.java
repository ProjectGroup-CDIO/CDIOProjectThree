package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaxTest{

	
	Player lars;
	Tax penge;
	@Before
	public void setUp() throws Exception {
	lars = new Player("Lars");
	penge = new Tax("abc", 0, 2000, 10);
	}

	@Test
	public void testTakeBaseTax() {	
	assertEquals(penge.takeBaseTax(lars),2000);
	assertEquals(lars.getAccount().getBalance(),28000);
	
	}

	@Test
	public void testTakePercentTax() {
	
		assertEquals(penge.takePercentTax(lars), 3000);
		assertEquals(lars.getAccount().getBalance(),27000);
	}

}
