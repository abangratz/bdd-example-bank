package com.projektur.course.bank;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;


public class AccountTest {
	
	private Account account;
	private User mockUser;
	@Before
	public void setUp() {
		mockUser = mock(User.class);
		stub(mockUser.overdraftOk()).toReturn(false);
		account = new Account(mockUser);;
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
	
	@Test
	public void testHasUser() {
		assertSame(mockUser, account.getUser());
	}
	
	@Test
	public void testCanOverdraftIfOk() {
		mockUser = mock(User.class);
		stub(mockUser.overdraftOk()).toReturn(true);
		account = new Account(mockUser);
		account.setBalance(50);
		assertTrue(account.withdraw(100));
		assertEquals(new Integer(-50), account.getBalance());
	}
}
