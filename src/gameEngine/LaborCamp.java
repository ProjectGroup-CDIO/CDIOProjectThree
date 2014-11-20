package gameEngine;

public class LaborCamp extends Ownable {
	
	 /**
	 * @param fieldName Name of the field in "use"
	 * @param ownerOfCurrentField Name of the player who owns the currently used field
	 * @param faceValue The value of the dice
	 */
	
	int baseRent = 100;
	
	//BaseRent defined 
	public LaborCamp(String fieldName, int fieldNumber, int price){ //Har fjernet faceValue fra constructor
		super(fieldName, fieldNumber, price);
	}
	//Withdraws BaseRent from player who lands on the field, and deposits BaseRent to player who owns the field
	public void completeBaseRent(Player ownerOfCurrentField, Player playerWhoLandedOnCurrentField){
		playerWhoLandedOnCurrentField.getAccount().withdraw(baseRent);
		ownerOfCurrentField.getAccount().deposit(baseRent);
	}
	
	public int getRent(int faceValue) {
		return baseRent * faceValue; 
	}
	
	@Override
	public int getRent() {
		
	}

	@Override
	public void landOnField(Player playerWhoLandedOnField) { //Hvordan får man implementeret terningkastet i en abstract method, når der ikke må ændres på parameterne?
		
		playerWhoLandedOnField.getAccount().withdraw(baseRent);
		super.getOwner().getAccount().deposit(baseRent);
		
		
	}
}
