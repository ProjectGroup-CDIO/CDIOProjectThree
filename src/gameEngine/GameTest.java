package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	GameBoard currentBoard;
	Player[] playerTurn = new Player[2];

	@Before
	public void setUp() throws Exception {
		currentBoard = new GameBoard();
		playerTurn[0] = new Player("1");
		playerTurn[1] = new Player("2");
		
		
	}

	@Test
	public void testResetOwner() {
		currentBoard.fields[2].landOnField(playerTurn[0]);
		System.out.println(currentBoard.ownables[1].getOwner());
		assertTrue(currentBoard.ownables[1].getOwner().getName().equals("1"));
		
		for(int is = 0; is < currentBoard.ownables.length; is++){
			System.out.println("--> "+(currentBoard.ownables[is].getOwner() == playerTurn[0]));
			if(currentBoard.ownables[is].getOwner() == playerTurn[0]) {
				currentBoard.ownables[is].setOwner(null);
				System.out.println("owner --> "+(currentBoard.ownables[is].getOwner()));
				System.out.println("current --> "+(playerTurn[0]));
			}
		}
		assertNull(currentBoard.ownables[1].getOwner());

	}
}
