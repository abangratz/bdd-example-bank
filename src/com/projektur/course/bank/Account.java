package com.projektur.course.bank;

public class Account {

	private Integer balance;
	private User user;
	
	public Account(User the_user) {
		balance = new Integer(0);
		user = the_user;
	}
	public boolean setBalance(int i) {
		balance = i;
		return true;
	}

	public Integer getBalance() {
		return balance;
	}
	public boolean withdraw(int i) {
		if (user.overdraftOk() || balance - i > 0) {
			balance -= i;
			return true;
		} else {
			return false;
		}
	}
	
	public User getUser() {
		return user;
	}

}
