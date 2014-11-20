package gameEngine;

public class GameBoard {
	
	Fields[] field = new Fields[21];
	for(int i = 0; i < field.length(); i++){
		field[i] = new Territory();
	}
	
	field[0] = terr1;
	terr1 = new Territory("Tribe Encampment", 1, 1000, 100);
	
}






//public Territory(String fieldName, int fieldNumber, int price, int rent) {
//	super(fieldName, fieldNumber, owner, price);
//	this.rent = rent;
//}
//	