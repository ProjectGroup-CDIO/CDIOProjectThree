package gameEngine;

public class Tax {

		private int baseTax;
		private int PercentTax;
		
		
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
		 * @param PlayerWholandedontheField
		 * @return
		 */
		int TakePercentTax(Player PlayerWholandedontheField){
			PlayerWholandedontheField.getAccount().withdraw(PlayerWholandedontheField.getAccount().getBalance()/PercentTax);
			
			return PlayerWholandedontheField.getAccount().getBalance()/PercentTax;
		}
	
}
