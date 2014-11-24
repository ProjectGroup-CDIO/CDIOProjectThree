package gameEngine;

public class Territory extends Ownable {
	
	private int rent; 
	
	/**
	 * @param fieldName is the name of the field the player lands on.
	 * @param fieldnumber is the number of the field the player lands on.
	 * @param price is the buy out price of the field.
	 * @param rent requried if a player lands on an owned field.  
	 */
	
	public Territory(String fieldName, int fieldnumber, int price, int rent) {
		super(fieldName, fieldnumber, price);
		this.rent = rent;
	}
	/**
	 * 
	 * @param lander Player who lands on the field.
	 */
	
	public void buyProperty(Player lander){
		super.setOwner(lander);
		lander.getAccount().withdraw(getPrice());
	}
	
	/**
	 * @param owner is the owner of the field.
	 * @param lander is the player who lands on the field. 
	 * @param withdraw = amount of points withdrawn from the lander and deposits them to the owner.
	 */
	
	public void completeRent(Player owner, Player lander){
		
			lander.getAccount().withdraw(getRent());
			owner.getAccount().deposit(getRent());
		
	}

	@Override
	public void landOnField( Player lander){
		if (super.getOwner() != null){
			lander.getAccount().withdraw(rent);
			super.getOwner().getAccount().deposit(rent);	
		}
		else{
			buyProperty(lander);
		}
		
	}
	@Override
	public int getRent() {
		return rent;
	}
		
	
}



