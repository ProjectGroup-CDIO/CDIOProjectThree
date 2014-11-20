package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetTest {

	Player playerTest;
	Fleet fl1;
	
	@Before
	public void setUp() throws Exception {
		playerTest = new Player("playerTest");
		fl1 = new  Fleet("Fleet", 5, playerTest, 4000, 500);

	}

	@Test
	public void testGetFleetPrice() {
playerTest.setFleetsOwned(2);	
assertEquals(fl1.getFleetRent(playerTest),1000);

	}

}
