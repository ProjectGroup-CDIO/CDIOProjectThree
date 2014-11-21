package gameEngine;

public class Die {
	
	private final int MAX = 6; //max value of die
	private int faceValue1; //shows current value of roll 1
	private int faceValue2; //Shows current value of roll 2
	private int lastRoll;
	
	/**
	 * 
	 * @return returns the total roll of both dices
	 */
	public int rollDie(){
		
		faceValue1 = (int) (Math.random() * MAX) + 1;
		faceValue2 = (int) (Math.random() * MAX) + 1;	
		lastRoll = faceValue1+faceValue2;		
		return lastRoll;
		
	}

	public int getFaceValue1() {
		return faceValue1;
	}
	public int getFaceValue2(){
		return faceValue2;
	
	}

	public void setFaceValue1(int faceValue) {
		this.faceValue1 = faceValue;
	}
	public void setFaceValue2(int faceValue) {
		this.faceValue2 = faceValue;
	}
	
	public int getLastRoll(){
		return lastRoll;
	}
}


