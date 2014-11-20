package gameEngine;

public class Player {
	
	private String name;
	private int fleetsOwned = 0;
	
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
	public void setFleetsOwned(int fleetsOwned){
		this.fleetsOwned = fleetsOwned;
	}

}
