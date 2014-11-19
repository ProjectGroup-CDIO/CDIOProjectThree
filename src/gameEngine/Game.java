
package gameEngine;

import javax.swing.JOptionPane;

import boundaryToMatador.GUI;
import boundaryToMatador.Car; //in order to create a custom car

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
	private static String typeNames[] = {typeNameOne, typeNameTwo,typeNameThree,typeNameFour,typeNameFive,typeNameSix};
	
	private static String rollDice = "";
	private static String won = "";
	private static String isWinner = "";
	private static String draw = "";



	public void game(){
		//variables created for storing the users names for the game
		String playerNames[] = {"","","","","","",""};
		
		//The choice of amount of players
		String[] amount = { "2", "3", "4","5","6"};
		//Selection box in which amount of players
		String players = (String) JOptionPane.showInputDialog(null, "Choose amount of players:",
				"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
				amount, 
				amount[0]); 
		int NumberOfPlayers = Integer.parseInt(players);

		//language selection, changes variables and sets the game board language.
		language.languageSelection("English");


		//User names are prompted from the users, and store in previous variables
		int n = 1;
		while (n<=NumberOfPlayers){
			playerNames[n]= GUI.getUserString(typeNames[n]);
			n++;
		}

		//variable used to store the button pressed value
		String i = "";

		//Dices to be rolled are created.
		Die dieOne = new Die();
		Die dieTwo = new Die();

		//adds player cars to the game
		int k = 1;
		int color = 50;
		while (k<=NumberOfPlayers){
			Game.setTypeNameOne("Indtast navn for spiller 1");
			GUI.addPlayer(playerNames[k],playerTurn[k].getAccount().getBalance(),color,0,75);
			k++;
			color = color + 50;
		}
		
		int turn = 1;
		while(game) {
			//user prompted button, when pressed the value of rollDice is stored in i.
			i = GUI.getUserButtonPressed(null, rollDice);
			
			if(i.equals(rollDice)){
				dieOne.rollDie();
				dieTwo.rollDie();
				int trow=dieOne.getFaceValue()+dieTwo.getFaceValue();
				GUI.setDice(dieOne.getFaceValue(), dieTwo.getFaceValue());

				if(activePlayers[turn]) {
					GUI.removeAllCars(playerNames[turn]);//Removes the player from the board. Only used in case of trow == 10, as the car would have otherwise been removed on playerTwos turn
					GUI.setCar(1, playerNames[turn]);//Sets the player at Start (field1)
					GUI.removeCar(1, playerNames[turn]); //Removes the car from Start
					GUI.setCar(trow, playerNames[turn]); //sets car at field corresponding to sum of faceValues
					Fields.field(playerTurn[turn], trow, i);
					GUI.setBalance(playerNames[turn], playerTurn[turn].getAccount().getBalance());
					//Sets the player to lose in case of 0 points
					if(playerTurn[turn].getAccount().getBalance()==0){
						activePlayers[turn] = false;
						GUI.removeAllCars(playerNames[turn]);
						trow = 0; //In order for a player not to get an extra turn by trow==10, when player have reached 0 points
					}
					//Sets the player to win in case of >= 3000 points
					turn++;
					if (turn>NumberOfPlayers){
						turn=1;
					}
				}
				//The turn is not switched if a player rolls 10
				if(trow==10){
					continue;
				}
				else if(playerOne){
					playerOne = false;
					playerTwo = true;
				}
				else if(playerTwo){
					playerOne = true;
					playerTwo = false;
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

