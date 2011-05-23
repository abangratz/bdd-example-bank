package com.projektur.course.bank;

public class Account {

	private Integer balance;
	
	public Account() {
		balance = new Integer(0);
	}
	public boolean setBalance(int i) {
		balance = i;
		return true;
	}

	public Integer getBalance() {
		return balance;
	}
	public boolean withdraw(int i) {
		if (balance - i > 0) {
			balance -= i;
			return true;
		} else {
			return false;
		}
	}

}
