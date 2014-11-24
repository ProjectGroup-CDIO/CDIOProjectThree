package gameEngine;

public class LaborCamp extends Ownable {
	
	 /**
	 * @param fieldName Name of the field in "use"
	 * @param ownerOfCurrentField Name of the player who owns the currently used field
	 * @param faceValue The value of the dice
	 */
	
	private int baseRent = 100;
	
	/**
	 * Constructor to labor camp
	 * @param fieldName Name of field
	 * @param fieldNumber Number of field
	 * @param price Price of field
	 */
	public LaborCamp(String fieldName, int fieldNumber, int price){ //Har fjernet faceValue fra constructor
		super(fieldName, fieldNumber, price);
	}
	//Withdraws BaseRent from player who lands on the field, and deposits BaseRent to player who owns the field
	public void completeBaseRent(Player ownerOfCurrentField, Player playerWhoLandedOnCurrentField){
		playerWhoLandedOnCurrentField.getAccount().withdraw(getRent());
		ownerOfCurrentField.getAccount().deposit(getRent());
	}
	
	public int getRent(int faceValue) {
		return baseRent * faceValue; 
	}
	
	
	public int getRent() {
		return baseRent * Die.getLastRoll();
	}


	public void landOnField(Player playerWhoLandedOnField) { 
		
		playerWhoLandedOnField.getAccount().withdraw(getRent());
		super.getOwner().getAccount().deposit(getRent());
			
	}
}
