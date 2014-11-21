package gameEngine;

public abstract class Ownable extends Fields {
	
	private Player owner;
	private int price;
	
	/**
	 * Creates ownable field 
	 * @param fieldName name of field
	 * @param fieldNumber number of field on the game board
	 * @param owner owner of the field
	 * @param price price of the field
	 */
	
//	public Ownable(String fieldName, int fieldNumber, Player owner, int price) {
//		super(fieldName, fieldNumber);
//		this.price = price;
//		this.owner = owner;
//	}
	
	/**
	 * Creates ownable field without owner
	 * @param fieldName name of field
	 * @param fieldNumber number of field on the game board
	 * @param price price of the field
	 */
	public Ownable(String fieldName, int fieldNumber, int price) {
		super(fieldName, fieldNumber); 
		this.price = price;
		this.owner = null;
	}
	
	public String getFieldName() {
		return fieldName; 
	}
	
	public int getFieldNumber() {
		return fieldNumber;
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
	
	public abstract int getRent();
}
