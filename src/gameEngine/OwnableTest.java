package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OwnableTest {

	Player player1;
	Ownable own3;
	
	@Before
	public void setUp() throws Exception {
		player1 = new Player("player1"); 
		own3 = new Ownable("Castle", 20, 8000);
	}

	@Test
	public void testOwnableStringIntPlayerInt() {
		Ownable own1 = new Ownable("Tribe Encampment", 11, player1, 1000);
		assertTrue(own1.getFieldName() == "Tribe Encampment");
		assertEquals(own1.getFieldNumber(), 11);
		assertTrue(own1.getOwner() == player1);
		assertEquals(own1.getPrice(), 1000);
	}

	@Test
	public void testOwnableStringIntInt() {
		Ownable own2 = new Ownable("Mountain", 15, 2000);
		assertTrue(own2.getFieldName() == "Mountain");
		assertEquals(own2.getFieldNumber(), 15); 
		assertEquals(own2.getPrice(), 2000);
	}

	@Test
	public void testSetPrice() {
		own3.setPrice(2000);
		assertEquals(own3.getPrice(), 2000); 
	}

	@Test
	public void testSetOwner() {
		own3.setOwner(player1);
		assertTrue(own3.getOwner() == player1); 
	}

	@Test
	public void testIsBuyable() {
		assertTrue(own3.isBuyable());
	}
	
	@Test
	public void testIsNotBuyable() {
		Ownable own4 = new Ownable("The Pit", 19, player1, 2500);
		assertFalse(own4.isBuyable());
	}

}
