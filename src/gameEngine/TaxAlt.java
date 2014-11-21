package gameEngine;

public class TaxAlt extends Fields {
	
	private int baseTax = 4000;
	private double percentTax = 0.1; 
	
	public TaxAlt(String fieldName, int fieldNumber) {
		super(fieldName, fieldNumber);
	}

	public int getBaseTax() {
		return baseTax;
	}

	public double getPercentTax() {
		return percentTax;
	}
	
	public void landOnField(Player playerWhoLanded) {
		if(fieldName == "")
	}

}
