package gameEngine;

import javax.swing.JOptionPane; 

public class Tax extends Fields {
	
	
	private int baseTax;
	private double percentTax;  
	
	/**
	 * Constructs a field of type Tax
	 * @param fieldName name of field
	 * @param fieldNumber number of field on the game board
	 * @param baseTax Base tax
	 * @param percentTax Percent tax in whole numbers. i.e. 10% is 10.
	 */
	
	public Tax(String fieldName, int fieldNumber, int baseTax, int percentTax) {
		super(fieldName, fieldNumber);
		this.baseTax = baseTax;
		this.percentTax = percentTax; 
	}

	public int getBaseTax() {
		return baseTax;
	}

	public double getPercentTax() {
		return percentTax;
	}
	
	/**
	 * Withdraws the amount corresponding to the Labor Camp field.
	 * On the Caravan Labor Camp field, the player is prompted whether he wants to pay 10% or 4000
	 * @param playerWhoLanded The player who landed on the field
	 */
	@Override
	public void landOnField(Player playerWhoLanded) {
		if(percentTax == 0) {
			playerWhoLanded.getAccount().withdraw(baseTax);
		}
		else {
			Object[] options = {
					"10% of your fortune",
                    "4000 straight",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
    "Do you want to pay 10% of your fortune or 4000?",
    "DECIDE NOW!",
    JOptionPane.WARNING_MESSAGE,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options, 
    options[0]);
			if(buttonPressed == 0){
				playerWhoLanded.getAccount().withdraw((int) ((percentTax/100.0) * playerWhoLanded
						.getAccount().getBalance()));
			}
			if(buttonPressed == 1) {
				playerWhoLanded.getAccount().withdraw(baseTax);
			}
		}
	}

}
