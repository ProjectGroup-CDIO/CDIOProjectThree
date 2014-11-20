package gameEngine;

public class Refuge extends Fields{

	private int bonus;
	
	public Refuge(String fieldName, int fieldNumber, Player playerWhoLandedOnField, int bonus){
		super(fieldName, fieldNumber);
	}
	
	public void landOnField(Player playerWhoLandedOnField){
		if (fieldName.equals("Monastery")){
			bonus= 500; //Monestery gives the player 500
		}
		else{
			bonus = 5000; //The Only other refuge is the Walled City which gives 5000
		}
		playerWhoLandedOnField.getAccount().deposit(bonus); //Deposit the bonus to the player
	}
}
