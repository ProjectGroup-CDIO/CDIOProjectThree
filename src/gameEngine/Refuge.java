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
	
//	public void landOnField(Player playerWhoLandedOnField){
//		if (fieldName.equals("Monastery")){
//			bonus= 500; //Monestery gives the player 500
//		}
//		else{
//			bonus = 5000; //The Only other refuge is the Walled City which gives 5000
//		}
//		playerWhoLandedOnField.getAccount().deposit(bonus); //Deposit the bonus to the player
	
}
