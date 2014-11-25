package gameEngine;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class TerritoryTest {
	
	Player owner;
	Player lander;
	Territory territory;
	
	@Before
	public void setup(){
		owner = new Player("owner");
		lander = new Player("lander");
		territory = new Territory("Tribal Encampment",1,1000,100);
	}
	
	/*
	 * Test of the  rent required when a player lands on a field.
	 * In this case the rent of field 1 (Tribal Encampment) is 100 points. 
	 */
	@Test
	public void testTerritory(){
		assertEquals(territory.getRent(),100);
	
	}
	
	/*
	 * This test is able to check if completeRent deposits and withdraws as implemented in the code.
	 */
	
	@Test
	public void testCompleteRent() {
		territory.completeRent(owner, lander);
		assertTrue(owner.getAccount().getBalance()>30000);
		assertTrue(lander.getAccount().getBalance()<30000);
	}

}

