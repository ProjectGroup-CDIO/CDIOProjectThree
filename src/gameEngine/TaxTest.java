package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaxTest{

	Player Lars;
	@Before
	public void setUp() throws Exception {
	Lars = new Player("Lars");
	}

	@Test
	public void testTakeBaseTax() {
	
	}

	@Test
	public void testTakePercentTax() {
		fail("Not yet implemented");
	}

}
