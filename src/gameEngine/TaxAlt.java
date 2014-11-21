package gameEngine;

import javax.swing.JOptionPane; 

public class TaxAlt extends Fields {
	
	private int baseTax = 4000;
	private double percentTax = 0.1;  
	
	public TaxAlt(String fieldName, int fieldNumber) {
		super(fieldName, fieldNumber);
	}

	public int getBaseTax() {
		return baseTax;
	}

	public double getPercentTax() {
		return percentTax;
	}
	
	public void landOnField(Player playerWhoLanded) {
		if(fieldName == "Goldmine") {
			playerWhoLanded.getAccount().withdraw(baseTax);
		}
		else {
			Object[] options = {
					"10% of your fortune",
                    "4000 straight",};
			int n = JOptionPane.showOptionDialog(null,
    "Do you want to pay 10% of your fortune or 4000?",
    "DECIDE NOW!",
    JOptionPane.WARNING_MESSAGE,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options, 
    options[0]);
			if(n == 0){
				playerWhoLanded.getAccount().withdraw((int) (percentTax * playerWhoLanded
						.getAccount().getBalance()));
			}
			if(n == 1) {
				playerWhoLanded.getAccount().withdraw(4000);
			}
		}
	}

}
