package gameEngine;

public class Die {
	
	private final int MAX = 6; //max value of die
	private int faceValue; //shows current value of die
	private static int lastRoll;
	
	public int rollDie(){
		
		faceValue = (int) (Math.random() * MAX) + 1 + (int) (Math.random() * MAX) + 1;	
		lastRoll = faceValue;		
		return faceValue;
		
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public static int getLastRoll(){
		return lastRoll;
	}
}


