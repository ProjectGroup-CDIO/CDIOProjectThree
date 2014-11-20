package gameEngine;

public class Ownable extends Fields {
	
	private Player owner;
	private int price;
	
	public Ownable(String fieldName, Player owner, int price) {
		super(fieldName);
		this.price = price;
		this.owner = owner;
	}
	public int getRent() {
		 
	}
}
