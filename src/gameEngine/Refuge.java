package gameEngine;

public class Refuge extends Fields{

	private int bonus;
	
	public Refuge(String fieldName, int fieldNumber, int bonus){
		super(fieldName, fieldNumber);
		this.bonus = bonus;
	}
	
	@Override
	public void landOnField(Player playerWhoLandedOnField) {
		playerWhoLandedOnField.getAccount().deposit(bonus);
	}
	
}
