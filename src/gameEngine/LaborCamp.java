package gameEngine;

public class LaborCamp extends Ownable {
	
	 /**
	 * @param fieldName Name of the field in "use"
	 * @param ownerOfCurrentField Name of the player who owns the currently used field
	 * @param faceValue The value of the dice
	 */
	
	int baseRent;
	
	//BaseRent defined 
	public LaborCamp(String fieldName, Player ownerOfCurrentField, int faceValue){
		super(fieldName, faceValue, ownerOfCurrentField, faceValue);
		this.baseRent = faceValue*100;
	}
	//Withdraws BaseRent from player who lands on the field, and deposits BaseRent to player who owns the field
	public void completeBaseRent(Player ownerOfCurrentField, Player playerWhoLandedOnCurrentField){
		playerWhoLandedOnCurrentField.getAccount().withdraw(baseRent);
		ownerOfCurrentField.getAccount().deposit(baseRent);
	}
	@Override
	public int getRent() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void landOnField(Player playerWhoLandedOnField) {
		playerWhoLandedOnField.getAccount().withdraw(baseRent);
		super.getOwner().getAccount().deposit(baseRent);
		
		
	}
}
