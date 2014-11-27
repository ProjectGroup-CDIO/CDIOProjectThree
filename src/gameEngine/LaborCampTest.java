package gameEngine;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class LaborCampTest {

	//We're getting players from the player class, dice from Die class and the method Labor from LaberCamp class

	Player playerWhoLandedOnField;
	Die diceRoll;
	LaborCamp labor;	
	Ownable ownable;
	
	//Initializing the above
	@Before
	public void setup(){
		playerWhoLandedOnField = new Player("Lander-Guy");
		diceRoll = new Die();
		labor = new LaborCamp("ACB", 3, 1000);
	}
	
	//Tests if BaseRent is equal to what we expected: The facevalue of the dice*100,
	//example: value of dice is 9, getRent() is then = 900
	//Because of changes, the FaceValue is set to 30, resulting in getRent()=300
	@Test
	public void testLaborCamp() {
		Die testDie = new Die();
		testDie.setLastRoll(3);
		assertEquals(labor.getRent(), 300);		
	}

	//Tests if playerWhoLandedOnField actually buys the property he lands on
	//Using system.out.print to visualize it, getting playerWhoLandedOnField's balance aswell
	@Test
	public void testLandOnField() {
		
		labor.landOnField(playerWhoLandedOnField);; //imports the m
		assertTrue(playerWhoLandedOnField.getAccount().getBalance()<30000);
		System.out.println(playerWhoLandedOnField + " bought ACB!");
		
	}
	

}
