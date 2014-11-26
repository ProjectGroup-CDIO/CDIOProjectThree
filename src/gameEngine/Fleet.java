package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fleet extends Ownable {
	
	/**
	 * Constructs a field of the type Fleet
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
	 * (non-Javadoc) A switch made over the value of RENT_1 to RENT_4.
	 * @see gameEngine.Ownable#getRent() 
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
	/*
	 * Lets the player buy a fleet that's not owned
	 */
	public void buyProperty(Player player){
		if (player.getAccount().getBalance()<super.getPrice()){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Insufficient funds", "Service message",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
			super.setOwner(player);//sets the owner to be the player which a landed.
			player.getAccount().withdraw(getPrice());//Withdraws the price for the field from the player which landed.
			super.getOwner().incrementFleetsOwned();//Adds one to the fleets owned under player.
		}
	}
	
	/*
	 *(non-Javadoc)
	 * @see gameEngine.Fields#landOnField(gameEngine.Player) Use the metod soo the money can withdraw from the player how landed on the Fleet field and diposit to the owner of the fleet
	 */
	
	@Override
	public void landOnField(Player player) {
		//Hvis der er en ejer af den fleet man lander p�, betaler man leje
		if (super.getOwner() != null){
			super.getOwner().getAccount().deposit(getRent());
			player.getAccount().withdraw(getRent());
		}
		else {//Hvis der ikke er nogen ejer at den fleet man har landet p�, k�ber man fleet'en
			Object[] options = {
					"Buy it now!",
                    "No, thank you",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"Do you wish to own this property? (Fleet-property)",
					"DECIDE NOW!",
					JOptionPane.WARNING_MESSAGE,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options, 
					options[0]);
			
			if(buttonPressed == 0){
				buyProperty(player);
			}	
			else if(buttonPressed == 1){
				return;
			}
		}
	}
}
