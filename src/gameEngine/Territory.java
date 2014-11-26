package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Territory extends Ownable {
	
	private int rent; 
	
	/**
	 * @param fieldName is the name of the field the player lands on.
	 * @param fieldnumber is the number of the field the player lands on.
	 * @param price is the buy out price of the field.
	 * @param rent requried if a player lands on an owned field.  
	 */
	
	public Territory(String fieldName, int fieldnumber, int price, int rent) {
		super(fieldName, fieldnumber, price);
		this.rent = rent;
	}
	/**
	 * 
	 * @param lander Player who lands on the field.
	 */
	
	public void buyProperty(Player lander){
		if(lander.getAccount().getBalance()<super.getPrice()){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Insufficient funds", "Service message",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
		super.setOwner(lander);
		System.out.println(getPrice());
		lander.getAccount().withdraw(getPrice());
		System.out.println(lander.getName()+" bought "+fieldName+" for "+getPrice());
		}
	}
	
	/**
	 * @param owner is the owner of the field.
	 * @param lander is the player who lands on the field. 
	 * @param withdraw = amount of points withdrawn from the lander and deposits them to the owner.
	 */
	
	public void completeRent(Player owner, Player lander){
		
			lander.getAccount().withdraw(getRent());
			owner.getAccount().deposit(getRent());
		
	}

	@Override
	public void landOnField( Player lander){
		if (super.getOwner() != null){
			lander.getAccount().withdraw(rent);
			super.getOwner().getAccount().deposit(rent);
			System.out.println(lander.getName()+" paid "+rent+" in rent to "+getOwnerName());
		}
		else{				
			Object[] options = {
					"Buy it now!",
                    "No, thank you",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"Do you wish to own this property? (Territory-property)",
					"DECIDE NOW!",
					JOptionPane.WARNING_MESSAGE,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options, 
					options[0]);
			
			if(buttonPressed == 0){
				buyProperty(lander);
			}	
			else if(buttonPressed == 1){
				return;
			}
			
		}
		
	}
	@Override
	public int getRent() {
		return rent;
	}
		
	
}



