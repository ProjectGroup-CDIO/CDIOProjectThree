package gameEngine;

public class Fleet extends Ownable {
		
	public Fleet(String fieldName, int fieldNumber, Player owner, int price, int fleetValue, Player howLandOnField) {
		super(fieldName, fieldNumber, owner, price);
	}
	
	final int RENT_1 = 500;
	final int RENT_2 = 1000;
	final int RENT_3 = 2000;
	final int RENT_4 = 4000;

	public int getFleetRent(){
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
//		public void landOnField(Player playerWhoLandedOnField) {
//			super.getOwner().getAccount().deposit(getFleetRent());
//			playerWhoLandedOnField.getAccount().withdraw(getFleetRent());
//		}
	}

	@Override
	public int getRent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void landOnField(Player player) {
		super.
		// TODO Auto-generated method stub
		
	}
	
	
//	
//	public getFleetPrice(Player owner){
//		if (owner.getFleetsOwned()==1){
//			return RENT_1;
//		}
//	}
//	
//	public void landOnFleet();
//	
	
}

