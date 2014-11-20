package gameEngine;

public class LaborCamp extends Ownable {
	
	int baseRent;
	
	public LaborCamp(String fieldName, Player owner, int price, int baseRent, int lastRoll) {
		super(fieldName, owner, price);
		this.baseRent = baseRent;	
		
	
	}
}
