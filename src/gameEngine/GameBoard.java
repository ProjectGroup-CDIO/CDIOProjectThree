package gameEngine;

public class GameBoard {
	
	Fields[] fields = new Fields[]{
		new Territory("Tribe Encampment", 1, 1000, 100),
		new Territory("Crater", 2, 1500, 300),
		new Territory("Mountain", 3, 2000, 500), 
		new Territory("Cold Desert", 4, 3000, 700),
		new Territory("Black Cave", 5, 4000, 1000),
		new Territory("The Werewall", 6, 4300, 1300),
		new Territory("Mountain Village", 7, 4750, 1600),
		new Territory("South Citadel", 8, 5000, 2000),
		new Territory("Palace Gates", 9, 5500, 2600),
		new Territory("Tower", 10, 6000, 3200),
		new Territory("Castle", 11, 8000, 4000),
		new Refuge("Walled City", 12, 5000), 
		new Refuge("Monastery", 13, 500),
		new LaborCamp("Huts in the Mountain", 14, 2500),
		new LaborCamp("The Pit", 15, 2500),
		new Tax("Goldmine", 16, 4000, 0), //Skal constructoren ændres? Der er ingen percent tax på Goldmine
		new Tax("Caravan", 17, 4000, 10),
		new Fleet("Second Sail", 18, 4000),
		new Fleet("Sea Grover", 19, 4000),
		new Fleet("The Buccaneers", 20, 4000),
		new Fleet("Privateer Armade", 21, 4000)
		};
	
}

