package com.OkaneBanku.app.model;

public class transaction {
	private int customerid;
	private double withdraw;
	private double deposit;
	private double balance;
	
	public transaction() {
	
	}
	
	public transaction(int customerid, double withdraw, double deposit, double balance) {
		super();
		this.customerid = customerid;
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.balance = balance;
	}

	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "transaction [customerid=" + customerid + ", withdraw=" + withdraw + ", deposit=" + deposit
				+ ", balance=" + balance + "]";
	}
	
	
}
