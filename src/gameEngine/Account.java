package gameEngine;

public class Account {

	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}

	public Account() {
		balance = 1000;
	}

	public String deposit(int amount) {
		if(amount >= 0) {  
			balance += amount;
			return "Deposit succesful";
		} else return "Deposit unsuccesful. Please deposit positive amount";
	}

	public String withdraw(int amount) {
		if(amount<=balance) {
			balance -= amount;
			return "Withdrawal succesful";
		} else if(amount>balance){
			balance = 0;
			return "Withdrawal unsuccesful. Cannot withdraw amount larger than balance ";
		}
		return "";
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		if(balance >= 0) {
			this.balance = balance;
		} 
	}

	public String toString() {
		return "balance: " + balance;
	}

}
