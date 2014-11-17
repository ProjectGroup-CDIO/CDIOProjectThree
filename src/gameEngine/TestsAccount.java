package gameEngine;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestsAccount {
	
	Account acc1;
	
	@Before
	public void setUp() throws Exception {
		acc1 = new Account();
	}
	
	@Test
	public void testAccount() {
	assertEquals(1000, acc1.getBalance()); //test whether the account is instantiated with balanca = 1000

	}

	@Test
	public void testDeposit() {
		acc1.deposit(100);
		assertEquals(1100, acc1.getBalance());
	}

	@Test
	public void testWithdraw() {
		acc1.withdraw(100);
		assertEquals(900, acc1.getBalance());
	}

	@Test
	public void testSetBalance() {
		acc1.setBalance(10000);
		assertEquals(10000, acc1.getBalance());
	}

	@Test
	public void testToString() {
		acc1.setBalance(5500);
		System.out.println(acc1);
		assertTrue(acc1.toString().equals("balance: "+5500));
	}
	
	@Test
	public void testWithdrawLargerThanBalance() {
		acc1.setBalance(2000); 
		acc1.withdraw(2500);
		assertEquals(0, acc1.getBalance());
	}
	
	@Test
	public void testNegativeDeposit() {
		Account acc2 = new Account(1000);
		acc2.deposit(-1);
		assertEquals(1000, acc2.getBalance());
	}

}
