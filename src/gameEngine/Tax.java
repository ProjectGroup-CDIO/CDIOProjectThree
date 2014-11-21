package gameEngine;

import javax.swing.JOptionPane;

public class Tax extends Fields{
	
	private int baseTax;
	private int percentTax;
	/**
	 * 	
	 * @param fieldName name of the field which is landed upon
	 * @param fieldNumber number of the field in the game board
	 * @param baseTaxInput The base tax amount 
	 * @param PercentTaxInput The percentage that is taxed, value of 10 is recommended, divides players current balance with the number.
	 */
	public Tax(String fieldName, int fieldNumber, int baseTaxInput, int PercentTaxInput) {
		super(fieldName, fieldNumber);
		baseTax = baseTaxInput;
		percentTax = PercentTaxInput;
	}
	
			
		/**
		 * 
		 * @param PlayerWholandedontheField is needed to withdraw the money from his account
		 * return Is used to show how much was removed from the players account
		 */
		int takeBaseTax(Player PlayerWholandedontheField){
	
			PlayerWholandedontheField.getAccount().withdraw(baseTax);
			
			return baseTax;
		}
		/**
		 * 
		 * @param PlayerWholandedontheField is needed to withdraw the money from his account
		 * @return Is used to show how much was removed from the players account
		 */
		int takePercentTax(Player PlayerWholandedontheField){
			int percentValueTaxed = PlayerWholandedontheField.getAccount().getBalance()/percentTax;
			PlayerWholandedontheField.getAccount().withdraw(PlayerWholandedontheField.getAccount().getBalance()/percentTax);
			
			return percentValueTaxed;
		}
		
		
		/*
		 * This is the method activated when a field is landed upon. The methods prompts the user 
		 * to make a choice, depending on the choice the player pays the given tax which is done by 
		 * above methods.
		 */
		@Override
		public void landOnField(Player player) {
			//player choice called. This makes the player choose between his tax options
			String[] amount = {"Pay the base tax" + baseTax ,"Pay the percent tax of " + percentTax};
			String taxChoice = (String) JOptionPane.showInputDialog(null, "Choose to pay base tax of " + baseTax + " or option 2 which is "+ percentTax,
					"Tax choose!!!", JOptionPane.QUESTION_MESSAGE, null,
					amount, 
					amount[0]); //Default choice is 1 which is pay baseTax;
			if(taxChoice.equals("Pay the base tax" + baseTax)){
				takeBaseTax(player);
			}else if(taxChoice.equals("Pay the percent tax of " + percentTax)){
				takePercentTax(player);
			}
			
		}
	
}
