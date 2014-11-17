package gameEngine;

public class Die 
{
	
	
	private final int MAX = 6; //maximal v�rdi p� terningen
	
	private int faceValue; // viser ternigens aktuelle v�rdi
	
	public int rollDie()
	{
		
		faceValue = (int) (Math.random() * MAX) + 1;
		
		return faceValue;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	

}


