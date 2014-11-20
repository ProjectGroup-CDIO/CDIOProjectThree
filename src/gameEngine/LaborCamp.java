package gameEngine;

public class LaborCamp extends Ownable {
	
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
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}
}
