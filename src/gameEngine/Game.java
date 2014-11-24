
package gameEngine;

import javax.swing.JOptionPane;

import boundaryToMatador.GUI;
import boundaryToMatador.Car; //in order to create a custom car
import gameEngine.GameBoard;

import java.awt.Color; //in order to change color of the car 

public class Game {

	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");
	Player player3 = new Player("PlayerThree");
	Player player4 = new Player("PlayerFour");
	Player player5 = new Player("PlayerFive");
	Player player6 = new Player("PlayerSix");
	//All the players are placed in an array
	Player playerTurn[] = {player1,player2,player3,player4,player5,player6};
	Language language = new Language(); 
	

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
	
	GameBoard currentBoard = new GameBoard();
 

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

		//language selection, changes variables and sets the game board language.
		language.languageSelection("English");


		//User names are prompted from the users, and store in previous variables
		int n = 0; //Variable used to run through the array
		while (n<=NumberOfPlayers-1){
			playerNames[n]= GUI.getUserString(typeNames[n]);
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
				if (activePlayers[n]!=true){
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
					playerTurn[turn].setCurrentPos(trow);
					//sets car at field corresponding to the value of the players position
					GUI.setCar(playerTurn[turn].getCurrentPos(), playerNames[turn]);
					currentBoard.fields[playerTurn[turn].getCurrentPos()].landOnField(playerTurn[turn]);
					//Fields.field(playerTurn[turn], trow, i);
					GUI.setBalance(playerNames[turn], playerTurn[turn].getAccount().getBalance());
					//Sets the player to lose in case of 0 points
					if(playerTurn[turn].getAccount().getBalance()==0){
						activePlayers[turn] = false;
						GUI.removeAllCars(playerNames[turn]); //Player is removed from board
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
		/*
		if (game != true){
			Car car = new Car.Builder()
			.typeRacecar()
			.primaryColor(Color.BLACK)
			.secondaryColor(Color.WHITE)
			.patternDiagonalDualColor()
			.build();
			//If both player have reached >= 3000 points. The player with the most points win.
			if (playerOneVic && playerTwoVic){
				if (player1.getAccount().getBalance() > player2.getAccount().getBalance()){
					GUI.showMessage(playerOneName+won);
					GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), car);
				}
				else if (player1.getAccount().getBalance() < player2.getAccount().getBalance()){
					GUI.showMessage(playerTwoName+won);
					GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), car);
				}
				//The game will end in a draw if both players have won and their points are equal
				else if (player1.getAccount().getBalance() == player2.getAccount().getBalance()){
					GUI.showMessage(draw);
					GUI.addPlayer(draw, 0, car);
				}
			}
			else if (playerOneVic && !playerTwoVic){
				GUI.showMessage(playerOneName+won);
				GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), car);
			}
			else if (playerTwoVic && !playerOneVic){
				GUI.showMessage(playerTwoName+won);
				GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), car);
			}
			if (playerOneLoss && playerTwoLoss){
				GUI.showMessage(draw);
			}
			else if (playerOneLoss && !playerTwoLoss){
				GUI.showMessage(playerTwoName+won);
				GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), car);
			}
			else if (!playerOneLoss && playerTwoLoss){

				GUI.showMessage(playerOneName+won);
				GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), car);

			}
			
		}
		*/
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

