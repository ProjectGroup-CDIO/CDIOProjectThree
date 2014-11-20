package gameEngine;

public class Die 
{
	int lastRoll;
	private final int MAX = 6; //max value of die
	private int faceValue; //shows current value of die
	
	public int rollDie()
	{
		
		faceValue = (int) (Math.random() * MAX) + 1 + (int) (Math.random() * MAX) + 1;
		
		return faceValue;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public int lastRoll(){
		lastRoll = faceValue;
		return lastRoll;
	}
}


