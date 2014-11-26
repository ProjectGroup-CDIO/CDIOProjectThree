package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LaborCamp extends Ownable {
	
	 /**
	 * @param fieldName Name of the field in "use"
	 * @param ownerOfCurrentField Name of the player who owns the currently used field
	 * @param faceValue The value of the dice
	 */
	
	private int baseRent = 100;
	
	/**
	 * Constructor to labor camp
	 * @param fieldName Name of field
	 * @param fieldNumber Number of field
	 * @param price Price of field
	 */
	public LaborCamp(String fieldName, int fieldNumber, int price){ //Har fjernet faceValue fra constructor
		super(fieldName, fieldNumber, price);
	}
	//Withdraws BaseRent from player who lands on the field, and deposits BaseRent to player who owns the field
	public void completeBaseRent(Player ownerOfCurrentField, Player playerWhoLandedOnCurrentField){
		playerWhoLandedOnCurrentField.getAccount().withdraw(getRent());
		ownerOfCurrentField.getAccount().deposit(getRent());
	}


	public int getRent() {
		return baseRent * Die.getLastRoll();
	}
	/**
	 * 
	 * @param playerWhoLandedOnField The first player which lands on the field buys the property.
	 * Missing so that if a player has insufficient funds he cant buy the field.
	 */
	public void buyProperty(Player playerWhoLandedOnField){
		if(playerWhoLandedOnField.getAccount().getBalance()<super.getPrice()){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Insufficient funds", "Service message",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
		super.setOwner(playerWhoLandedOnField);
		playerWhoLandedOnField.getAccount().withdraw(getPrice());
		System.out.println(playerWhoLandedOnField.getName()+" bought "+fieldName+" for "+getPrice());
		}
	}

	public void landOnField(Player playerWhoLandedOnField) { 
		if(super.getOwner() != null){
			playerWhoLandedOnField.getAccount().withdraw(getRent());
			super.getOwner().getAccount().deposit(getRent());
			System.out.println(playerWhoLandedOnField.getName()+" paid "+getRent()+" in rent to "+getOwnerName());
		}
		else{
			Object[] options = {
					"Buy it now!",
                    "No, thank you",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"Do you wish to own this property? (LaborCamp-property)",
					"DECIDE NOW!",
					JOptionPane.WARNING_MESSAGE,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options, 
					options[0]);
			
			if(buttonPressed == 0){
				buyProperty(playerWhoLandedOnField);
			}	
			else if(buttonPressed == 1){
				return;
			}	
		}
	}
}
