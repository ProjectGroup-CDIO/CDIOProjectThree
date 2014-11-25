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
	 * This is the rent which is required when you land on the field.
	 * asdasd
	 * asd
	 * asd
	 * a
	 * sd
	 */
	@Test
	public void testTerritory(){
		assertEquals(territory.getRent(),100);
		
	}
	
	@Test
	public void testCompleteRent() {
		territory.completeRent(owner, lander);
		assertTrue(owner.getAccount().getBalance()>30000);
		assertTrue(lander.getAccount().getBalance()<30000);
	}

}

