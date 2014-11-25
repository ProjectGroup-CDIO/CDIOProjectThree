
package gameEngine;

import javax.swing.JOptionPane;

import boundaryToMatador.GUI;
import boundaryToMatador.Car; //in order to create a custom car
import gameEngine.GameBoard;

import java.awt.Color; //in order to change color of the car and not use RGB-codes

public class Game {

	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");
	Player player3 = new Player("PlayerThree");
	Player player4 = new Player("PlayerFour");
	Player player5 = new Player("PlayerFive");
	Player player6 = new Player("PlayerSix");
	//All the players are placed in an array
	Player playerTurn[] = {player1,player2,player3,player4,player5,player6}; 

	GameBoard currentBoard = new GameBoard();

	private boolean playerOne = true;
	private boolean playerTwo = true;
	private boolean playerThree = true;
	private boolean playerFour = true;
	private boolean playerFive = true;
	private boolean playerSix = true;
	private boolean activePlayers[]={playerOne,playerTwo,playerThree,playerFour,playerFive,playerSix};

	private boolean game = true;

	//Language used in the code, will be changed by the language setting.
	private static String typeNameOne = ""; 
	private static String typeNameTwo = "";
	private static String typeNameThree = ""; 
	private static String typeNameFour = "";
	private static String typeNameFive = ""; 
	private static String typeNameSix = "";
	//All typeNames have been placed in an array
	private static String typeNames[] = {typeNameOne, typeNameTwo,typeNameThree,typeNameFour,typeNameFive,typeNameSix};

	private static String rollDice = "";
	private static String won = "";
	private static String isWinner = "";
	private static String draw = "";


	public void game(){

		//variables created for storing the users names for the game in an array
		//With only a Max amount of 6 players, the len of the array is only 6
		String playerNames[] = {"","","","","",""};



		//The choice of amount of players
		String[] amount = { "2", "3", "4","5","6"};
		//Selection box in which amount of players
		String players = (String) JOptionPane.showInputDialog(null, "Choose amount of players:",
				"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
				amount, 
				amount[0]); //Default choice is 2 players
		int NumberOfPlayers = Integer.parseInt(players);


		//Game Window initialization
		GUI.create("fieldstext-cdio3.txt");
		Game.setTypeNameOne("Enter name for player 1");
		Game.setTypeNameTwo("Enter name for player 2");
		Game.setRollDice("Roll Dice");
		Game.setWon(" WON!!!");
		Game.setIsWinner(" IS THE WINNER!!!");
		Game.setDraw("THE GAME WAS A DRAW");

		//User names are prompted from the users, and store in previous variables
		int n = 0; //Variable used to run through the array
		while (n<=NumberOfPlayers-1){
			playerNames[n] = GUI.getUserString(typeNames[n]);
			n++;
		}

		//variable used to store the button pressed value
		String i = "";

		//Dices to be rolled are created.
		Die dieOne = new Die();

		int turn = 0; //Variable used to determine which players turn it is.
		int inactivePlayers  = 0; //Variable to check amount of inactive player


		n = 0; //Resest the variable used to run through the array
		int color1 = 0;
		int color2 = 0;
		//adds player cars to the game
		while (n<=NumberOfPlayers-1){
			Game.setTypeNameOne("Indtast navn for spiller 1");
			GUI.addPlayer(playerNames[n],playerTurn[n].getAccount().getBalance(),color1,0,color2);
			n++;
			color1 = color1 + 50;
			color2 = color2 + 10;
		}


		n = 0; //Resest the variable used to run through the array
		//Maximum amount of players that can be inactive
		int MaxInactive = NumberOfPlayers - 1;
		while(game) {
			//Checks how many players have lost
			while (n <= NumberOfPlayers - 1){
				if (activePlayers[n]!= true){
					inactivePlayers++;//Increments in case of a player who have lost
				}
				n++;
			}
			//Checks if the players have already lost. If so, next players turn
			if (activePlayers[turn]!=true){
				turn++;
				if (turn>NumberOfPlayers-1){
					turn=0;
				}
				continue;
			}
			//Terminates the game if all except one have lost
			if (inactivePlayers==MaxInactive){
				game=false;
				GUI.addPlayer(playerNames[turn]+" is the winner!",playerTurn[turn].getAccount().getBalance(), 0, 0, 0);
				break;
			}
			//Resets in case of new turn
			else if(inactivePlayers!=MaxInactive){
				inactivePlayers  = 0;
				n = 0;
			}

			//user prompted button, when pressed the value of rollDice is stored in i.
			i = GUI.getUserButtonPressed(null, rollDice);

			if(i.equals(rollDice)){
				int trow=dieOne.rollDie();
				GUI.setDice(dieOne.getFaceValue1(), dieOne.getFaceValue2());

				if(activePlayers[turn]) {
					GUI.removeAllCars(playerNames[turn]);//Removes the player from the board.
					playerTurn[turn].updateCurrentPos(trow);
					//sets car at field corresponding to the value of the players position
					GUI.setCar(playerTurn[turn].getCurrentPos()+1, playerNames[turn]);
					System.out.println(playerTurn[turn].getCurrentPos());

					currentBoard.fields[playerTurn[turn].getCurrentPos()].landOnField(playerTurn[turn]);
					//Fields.field(playerTurn[turn], trow, i);
					GUI.setBalance(playerNames[turn], playerTurn[turn].getAccount().getBalance());
					//Sets the player to lose in case of 0 points
					if(playerTurn[turn].getAccount().getBalance()==0){
						activePlayers[turn] = false;
						GUI.removeAllCars(playerNames[turn]); //Player is removed from board

						//removes bankrupt player as owner of his fields
						/*
						 for(int is = 0; is < currentBoard.ownables.length; is++){
							if(currentBoard.ownables[is].getOwner() == playerTurn[turn]) {
								currentBoard.ownables[is].setOwner(null);
							}	
						*/
						}
						 
						//Next players turn
						turn++;
						//If turn is out of bounds. It is reset to 0
						if (turn>NumberOfPlayers-1){
							turn=0;
						}

					}

				}

			}

		}

	

	//Language Strings getters and setters
	public static void setTypeNameOne(String typeNameOne) {
		Game.typeNameOne = typeNameOne;
	}
	public static void setTypeNameTwo(String typeNameTwo) {
		Game.typeNameTwo = typeNameTwo;
	}
	public static String getRollDice() {
		return rollDice;
	}
	public static void setRollDice(String rollDice) {
		Game.rollDice = rollDice;
	}
	public static void setWon(String won) {
		Game.won = won;
	}
	public static void setIsWinner(String isWinner) {
		Game.isWinner = isWinner;
	}
	public static void setDraw(String draw) {
		Game.draw = draw;
	}

}

