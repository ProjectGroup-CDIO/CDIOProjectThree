package gameEngine;

public class Territory extends Ownable {
	
	private int rent; 
	
	public Territory(String fieldName, Player owner, int price, int rent) {
		super(fieldName, rent, owner, price);
		this.rent = rent;
	}
		
	/*
	 * Withdraws the points from the lander and deposits them to the owner
	 */
	/**
	 * 
	 * @param owner is the player who owns the field
	 * @param lander is the player who lands on the field
	 */
	public void completeRent(Player owner, Player lander){
		lander.getAccount().withdraw(rent);
		owner.getAccount().deposit(rent);
	}
		@Override
		public int getRent() {
			// TODO Auto-generated method stub
			return rent;
		}
		@Override
		public void landOnField(Player player) {
			// TODO Auto-generated method stub
			
		}
	
}



