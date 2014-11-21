package gameEngine;

public class GameBoard {
	
	Fields[] fields = new Fields[]{
		new Territory("Crater", 2, 1500, 300),
		new Fleet("Second Sail", 3, 4000),
		new Territory("Tower", 4, 6000, 3200),
		new Tax("Goldmine", 5, 4000, 0), //Skal constructoren ændres (kommentar fjernes senere)?
		new Territory("Cold Desert", 6, 3000, 700),
		new LaborCamp("Huts in the Mountain", 7, 2500),
		new Territory("The Werewall", 8, 4300, 1300),
		new Fleet("Sea Grover", 9, 4000),
		new Refuge("Walled City", 10, 5000), 
		new Territory("Black Cave", 11, 4000, 1000),
		new Territory("Tribe Encampment", 12, 1000, 100),
		new Fleet("The Buccaneers", 13, 4000),
		new Territory("South Citadel", 14, 5000, 2000),
		new Tax("Caravan", 15, 4000, 10),
		new Territory("Mountain", 16, 2000, 500), 
		new Territory("Palace Gates", 17, 5500, 2600),
		new Fleet("Privateer Armade", 18, 4000),
		new Territory("Mountain Village", 19, 4750, 1600),
		new LaborCamp("The Pit", 20, 2500),
		new Territory("Castle", 21, 8000, 4000),
		new Refuge("Monastery", 22, 500)};
}

