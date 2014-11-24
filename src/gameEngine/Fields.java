package gameEngine;

public abstract class Fields {
	

	
	String fieldName;
	int fieldNumber;
	
	/**
	 * 
	 * @param fieldName Name of field
	 * @param fieldNumber Number of field
	 */
	
	public Fields(String fieldName, int fieldNumber) {
		this.fieldName = fieldName; 
		this.fieldNumber = fieldNumber; 
	}
	
	public abstract void landOnField(Player player);
}






