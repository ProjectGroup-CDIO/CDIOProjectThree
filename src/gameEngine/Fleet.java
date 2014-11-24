package gameEngine;

public class Fleet extends Ownable {
/**
 * 
 * @param fieldName The name of the field.
 * @param fieldNumber Number of the field. 
 * @param price the price of the field.
 */
	public Fleet(String fieldName, int fieldNumber, int price) {
		super(fieldName, fieldNumber, price);
	}
	/*
	 * The Value of the amount of fleet you own. RENt_1 = you own 1 Fleet RENT_2 = you own 2 ect.
	 */
	final int RENT_1 = 500;
	final int RENT_2 = 1000;
	final int RENT_3 = 2000;
	final int RENT_4 = 4000;

	/*
	 * (non-Javadoc)
	 * @see gameEngine.Ownable#getRent() A switch made over the value of RENT_1 to RENT_4.
	 */
	
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
	//Her k�bes der en fleet
	public void buyProperty(Player player){
		super.setOwner(player);//S�tter spilleren til at v�re ejer at fleet'en
		player.getAccount().withdraw(getPrice());//Tr�kker penge fra spilleren. S� spilleren kan k�be fleet'en
		super.getOwner().incrementFleetsOwned();//Addere en til spillerens nuv�rende m�ngde af fleets
	}
	
	/*
	 *(non-Javadoc)
	 * @see gameEngine.Fields#landOnField(gameEngine.Player) Use the metod soo the money can withdraw from the player how landed on the Fleet field and diposit to the owner of the fleet
	 */
	
	@Override
	public void landOnField(Player player) {
		if (player != null){//Hvis der er en ejer af den fleet man lander p�, betaler man leje
			super.getOwner().getAccount().deposit(getRent());
			player.getAccount().withdraw(getRent());
		}
		else {//Hvis der ikke er nogen ejer at den fleet man har landet p�, k�ber man fleet'en
			buyProperty(player);
		}
	}

}

