package gameEngine;

public class Ownable extends Fields {
	
	private Player owner;
	private int price;
	
	public Ownable(String fieldName, int fieldNumber, Player owner, int price) {
		super(fieldName, fieldNumber);
		this.price = price;
		this.owner = owner;
	}
	
	public Ownable(String fieldName, int fieldNumber, int price) {
		super(fieldName, fieldNumber); 
		this.price = price;
		this.owner = null;
	}
	
	public void setPrice(int price) {
		this.price = price; 
	}
	
	public int getPrice() {
		return price; 
	}
	
	public Player getOwner() {
		return owner; 
	}
	
	public void setOwner(Player owner) {
		this.owner = owner; 
	}
	
	public boolean isBuyable() {
		return owner == null;
	}
}
