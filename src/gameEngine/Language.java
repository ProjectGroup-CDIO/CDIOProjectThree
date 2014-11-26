
package gameEngine;

import boundaryToMatador.GUI;

public class Language {

	
	public void languageSelection(String input) {
		if(input.equals("English")){
			GUI.create("fieldstext-cdio3.txt");
			Game.setTypeNameOne("Enter name for player 1");
			Game.setTypeNameTwo("Enter name for player 2");
			Game.setRollDice("Roll Dice");
		}
	}
}