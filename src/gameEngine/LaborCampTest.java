package gameEngine;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class LaborCampTest {

	Player owner;
	Player guyWhoLandedonField;
	Die diceRoll;
	LaborCamp labor;
	
	@Before
	public void setup(){
		owner = new Player("Owner");
		guyWhoLandedonField = new Player("Lander-Guy");
		diceRoll = new Die();
		labor = new LaborCamp("ACB", owner, diceRoll.rollDie());
	}
	
	@Test
	public void testLaborCamp() {
		assertEquals(labor.baseRent,diceRoll.getFaceValue()*100);		
	}

	@Test
	public void testCompleteBaseRent() {
		
		System.out.println("Før BaseRent Labor:");
		System.out.println("John, som ejer feltet, har: " + owner.getAccount().getBalance());
		System.out.println("Jens, som lander på feltet, har: " + guyWhoLandedonField.getAccount().getBalance());
		System.out.println();

		labor.completeBaseRent(owner, guyWhoLandedonField);
		assertTrue(owner.getAccount().getBalance()>30000);
		assertTrue(guyWhoLandedonField.getAccount().getBalance()<30000);
		
		System.out.println("Efter BaseRent Labor:");
		System.out.println("John har nu: " + owner.getAccount().getBalance());
		System.out.println("Jens har nu: " + guyWhoLandedonField.getAccount().getBalance());	
		
	}

}
