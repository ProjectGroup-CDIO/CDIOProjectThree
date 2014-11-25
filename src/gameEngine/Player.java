package gameEngine;

public class Player {
	
	private String name;
	private int fleetsOwned = 0;
	private int currentPos = 0;
	
	/*
	 * returns an integer with the players current position. 
	 * If the players position is more than 21 (the 21 fields + START at 0)
	 * 21 is subtracted when the currentPos i needed
	 */
	
	public int getCurrentPos() {
		if(currentPos > 21){
		currentPos = currentPos - 21;
		}		
			return currentPos;
		}

	public void setCurrentPos(int throwValue) {
		this.currentPos = currentPos + throwValue;
	}
	private Account playerAcc = new Account(); 
	
	public Player(String name) {
		this.name = name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return name; 
	}
	
	public String toString() {
		return name + "'s " + playerAcc.toString();
	}
	public Account getAccount() {
		return playerAcc;
	}
	public int getFleetsOwned(){
		return fleetsOwned;
	}
	public void incrementFleetsOwned(){
		this.fleetsOwned = this.fleetsOwned + 1;
	}

}
