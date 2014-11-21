package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetTest {

	Player playerTest1;
	Player playerTest2;
	Fleet fl1;
	
	@Before
	public void setUp() throws Exception {
		playerTest1 = new Player("playerTest");
		fl1 = new  Fleet("Fleet", 5, 4000);
		fl1.setOwner(playerTest1);

	}

	@Test
	public void testGetFleetPrice() {
		playerTest1.setFleetsOwned(2);	
		assertEquals(fl1.getRent(),1000);

	}
	
	@Test
	public void testDipositAndWithdraw(){
		playerTest1.getAccount().deposit(1000);
		playerTest2.getAccount().withdraw(1000);
		assertEquals(playerTest2.getAccount().getBalance(),29000);
		
	}
	
}
