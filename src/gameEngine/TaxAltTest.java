package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaxAltTest {

	Player playerTestLand;
	TaxAlt tax1;
	
	@Before
	public void setUp() throws Exception {
		playerTestLand = new Player("test1");
		tax1 = new TaxAlt("Caravan", 2);
	}
	
	@Test
	public void test10percentLandOnField() {
		//playerTestLand.getAccount().setBalance(30000);
		tax1.landOnField(playerTestLand);
		System.out.println(playerTestLand.getAccount().getBalance());
		assertEquals(playerTestLand.getAccount().getBalance(),27000);
	} 
	
	@Test
	public void test4000LandOnField() {
		tax1.landOnField(playerTestLand);
		System.out.println(playerTestLand.getAccount().getBalance());
		assertEquals(playerTestLand.getAccount().getBalance(), 26000);
	}

}
