package gameEngine;

public class Territory extends Ownable {
	
	private int rent; 
	
	public Territory(String fieldName, Player owner, int price, int rent) {
		super(fieldName, owner, price);
		this.rent = rent;
	}
	private String name = "Tribe Encampent";
		public void completeRent(Player owner, Player lander){
		lander.getAccount().withdraw(rent);
		owner.getAccount().deposit(rent);
	
	}
	
}



