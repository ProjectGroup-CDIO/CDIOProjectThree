package gameEngine;

public class Ownable extends Fields {
	
	private Player owner;
	private int price;
	
	public Ownable(String fieldName, Player owner, int price) {
		super(fieldName);
		this.price = price;
		this.owner = owner;
	}
	
	public Ownable(String fieldName, int price) {
		super(fieldName); 
		this.price = price;
	}
	public int getRent() {
		 
	}
	
	public Player getOwner() {
		return owner; 
	}
	
	public void setOwner(owner) {
		this.owner = owner; 
	}
	
	public boolean isBuyable() {
		return owner == null;
	}
}
