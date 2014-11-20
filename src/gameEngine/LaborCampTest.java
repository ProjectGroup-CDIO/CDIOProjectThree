package gameEngine;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class LaborCampTest {

	//We're getting players from the player class, dice from Die class and the method Labor from LaberCamp class
	Player owner;
	Player guyWhoLandedonField;
	Die diceRoll;
	LaborCamp labor;
	
	//Initializing the above
	@Before
	public void setup(){
		owner = new Player("Owner");
		guyWhoLandedonField = new Player("Lander-Guy");
		diceRoll = new Die();
		labor = new LaborCamp("ACB", owner, diceRoll.rollDie());
	}
	
	//Tests if BaseRent is equal to what we expected: The facevalue of the dice*100,
	//example: value of dice is 9, BaseRent is then = 900
	@Test
	public void testLaborCamp() {
		assertEquals(labor.baseRent,diceRoll.getFaceValue()*100);		
	}

	//Tests if BaseRent withdraws and deposits as we want it to
	//Using system.out.print to visualize it
	@Test
	public void testCompleteBaseRent() {
		
		System.out.println("Før BaseRent Labor:");
		System.out.println("John, som ejer feltet, har: " + owner.getAccount().getBalance());
		System.out.println("Jens, som lander på feltet, har: " + guyWhoLandedonField.getAccount().getBalance());
		System.out.println();

		labor.completeBaseRent(owner, guyWhoLandedonField); //imports the m
		assertTrue(owner.getAccount().getBalance()>30000);
		assertTrue(guyWhoLandedonField.getAccount().getBalance()<30000);
		
		System.out.println("Efter BaseRent Labor:");
		System.out.println("John har nu: " + owner.getAccount().getBalance());
		System.out.println("Jens har nu: " + guyWhoLandedonField.getAccount().getBalance());	
		
	}

}
