package gameEngine;

import javax.swing.JOptionPane;

public class Tax extends Fields{
	
	private int baseTax;
	private int percentTax; //Hvad med double = 0.1?
		
	public Tax(String fieldName, int fieldNumber, int baseTaxInput, int PercentTaxInput) {
		super(fieldName, fieldNumber);
		baseTax = baseTaxInput;
		percentTax = PercentTaxInput;
	}
		
		
	
		
		/*
		if(taxChoice =="Pay the base tax"){
			takeBaseTax();
			
		}else if(){
			
		}
		*/
		
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
