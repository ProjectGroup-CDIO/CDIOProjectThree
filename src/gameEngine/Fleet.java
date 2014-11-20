package gameEngine;

public class Fleet extends Ownable {
/**
 * 
 * @param fieldName The name of the field.
 * @param fieldNumber Number of the field. 
 * @param owner The owner of the field.
 * @param price the price of the field.
 * @param whoLandOnField who landed on the field.
 */
	public Fleet(String fieldName, int fieldNumber, Player owner, int price, Player whoLandOnField) {
		super(fieldName, fieldNumber, owner, price);
	}
	
	final int RENT_1 = 500;
	final int RENT_2 = 1000;
	final int RENT_3 = 2000;
	final int RENT_4 = 4000;

	@Override
	public int getRent(){
		switch (super.getOwner().getFleetsOwned()){
	
		case 1: 
			return RENT_1;
		case 2:
			return RENT_2;
		case 3:
			return RENT_3;
		case 4:
			return RENT_4;
		default:
			return 0;
				
		}
	}

	@Override
	public void landOnField(Player player) {
		super.getOwner().getAccount().deposit(getRent());
		player.getAccount().withdraw(getRent());
	
	}

}

