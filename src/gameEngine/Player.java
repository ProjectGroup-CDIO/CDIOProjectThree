package gameEngine;

public class Player {
	
	private String name;
	private int fleetsOwned = 0;
	private int currentPos = 0;
	
	public int getCurrentPos() {
		if(currentPos > 22){
		currentPos = currentPos - 22;
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
	public void setFleetsOwned(){
		this.fleetsOwned = this.fleetsOwned + 1;
	}

}
