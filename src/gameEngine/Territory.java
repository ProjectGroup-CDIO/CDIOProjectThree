package gameEngine;

public class Territory extends Ownable {
	
	private int rent; 
	
	public Territory(String fieldName, Player owner, int price, int rent) {
		super(fieldName, owner, price);
		this.rent = rent;
	}

}
