package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestsFields {

	Player testPlay;
	
	@Before
	public void setup() throws Exception{
	testPlay = new Player("PlayerOne");
	}
	
	@Test //tower test
	public void testTower() {
	Fields.field(testPlay, 2, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),1250);
	}
	@Test //crater test
	public void testCrater() {
	Fields.field(testPlay, 3, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),800);
	}
	@Test //Palace gates test
	public void testPalaceGates() {
	Fields.field(testPlay, 4, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),900);
	}
	@Test //Cold Desert test
	public void testColdDesert() {
	Fields.field(testPlay, 5, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),980);
	}
	@Test //walled city test
	public void testWalledCity() {
	Fields.field(testPlay, 6, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),1180);
	}
	
	@Test //Monestary test
	public void testMonestary() {
	Fields.field(testPlay, 7, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),1000);
	}
	@Test //Black cave test
	public void testBlackCave() {
	Fields.field(testPlay, 8, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),930);
	}
	@Test //huts in the mountain
	public void testhuts() {
	Fields.field(testPlay, 9, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),940);
	}
	@Test //werewall test
	public void testWerewall() {
	Fields.field(testPlay, 10, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),920);
	}
	@Test //The pit test
	public void testThePit() {
	Fields.field(testPlay, 11, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),910);
	}
	@Test //The goldmine test
	public void testTheGoldmine() {
	Fields.field(testPlay, 12, "Roll Dice");
	assertEquals(testPlay.getAccount().getBalance(),1650);
	}
	@Test //fejl i input af string i
	public void testFejl() {
	assertEquals(Fields.field(testPlay, 12, "Roll D"),"Roll Dice not recieved properly");		
	}
}
