package gameEngine;

public class LaborCamp extends Ownable {
	
	private int baseRent;
	
	public LaborCamp(String fieldName, Player owner, int price, int baseRent) {
		super(fieldName, owner, price);
		this.baseRent = baseRent; 
	}

}
