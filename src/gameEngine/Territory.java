package gameEngine;

public class Territory extends Ownable {
	
	private int rent; 
	
	public Territory(String fieldName, int fieldnumber, int price, int rent) {
		super(fieldName, fieldnumber, price);
		this.rent = rent;
	}
	public void buyProperty(Player lander){
		super.setOwner(lander);
		lander.getAccount().withdraw(getPrice());
	}
	public void completeRent(Player owner, Player lander){
		if (super.getOwner() != null){
			lander.getAccount().withdraw(getRent());
			owner.getAccount().deposit(getRent());
		}
		else{
			buyProperty(lander);
		}
		
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



