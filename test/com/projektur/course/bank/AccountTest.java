package com.projektur.course.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AccountTest {
	
	private Account account;
	@Before
	public void setUp() {
		account = new Account();
	}
	@Test
	public void testCanInstantiate() {
		assertNotNull(account);
	}
	@Test
	public void testCanSetBalance() {
		assertTrue(account.setBalance(500));
	}
	@Test
	public void testCanRetrieveBalance() {
		assertEquals(new Integer(0), account.getBalance());
	}
	
	@Test
	public void testCanSetAndRetrieveBalance() {
		account.setBalance(20);
		assertEquals(new Integer(20), account.getBalance());
	}
	
	@Test
	public void testCanWithdrawIfBalanceOk() {
		account.setBalance(40);
		assertTrue(account.withdraw(20));
		assertEquals(new Integer(20), account.getBalance());
	}
	
	@Test
	public void testCanNotWithdrawIfBalanceNotOk() {
		account.setBalance(30);
		assertFalse(account.withdraw(40));
		assertEquals(new Integer(30), account.getBalance());
	}
	
	public void testHasUser() {
		User mockUser = mock(User.class);
		account = new Account();
	
		
	}
}
