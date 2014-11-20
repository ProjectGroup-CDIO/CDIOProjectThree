package gameEngine;

public class Fields {
	
	String fieldName;
	
	
	public Fields(String fieldName) {
		this.fieldName = fieldName; 
	}
	
	public static void landOnField(Player player) {
		
	}
}

//	public static String field(Player player, int trow, String i){ 
//
//		if(i.equals(Game.getRollDice())){
//
//			if(trow==2){
//				player.getAccount().deposit(250);
//				return "Tower";
//			}else
//			if(trow==3){
//				player.getAccount().withdraw(200);
//				return "Crater";
//			}else
//			if(trow==4){
//				player.getAccount().withdraw(100);
//				return "Palace gates";
//			}else
//			if(trow==5){
//				player.getAccount().withdraw(20);
//				return "Cold Desert";
//			}else
//			if(trow==6){
//				player.getAccount().deposit(180);
//				return "Walled city";
//			}else
//			if(trow==7){
//				player.getAccount().withdraw(0);
//				return "Monastery";
//			}else
//			if(trow==8){
//				player.getAccount().withdraw(70);
//				return "Black cave";
//			}else
//			if(trow==9){
//				player.getAccount().withdraw(60);
//				return "Huts in the mountain";
//			}else
//			if(trow==10){
//				player.getAccount().withdraw(80);
//				return "The Werewall";
//			}else
//			if(trow==11){
//				player.getAccount().withdraw(90);
//				return "The pit";
//			}else
//			if(trow==12){
//				player.getAccount().deposit(650);
//				return "The Goldmine";
//			}
//			else return "There must be rolled a valid dice";
//
//		}else return "Roll Dice not recieved properly";
//	}
//}




