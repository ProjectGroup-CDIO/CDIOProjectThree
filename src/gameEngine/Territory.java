package gameEngine;

public class Territory extends Ownable {
	
	private int rent; 
	
	public Territory(String fieldName, int fieldNumber, int price, int rent) {
		super(fieldName, fieldNumber, price);
		this.rent = rent;
	}
		

	/**
	 *Withdraws the points from the lander and deposits them to the owner
	 * @param lander is the player who lands on the field
	 */
	@Override
	public void landOnField( Player lander){
		lander.getAccount().withdraw(rent);
		super.getOwner().getAccount().deposit(rent);
	}
	@Override
	public int getRent() {
		return rent;
	}
		
	
}



