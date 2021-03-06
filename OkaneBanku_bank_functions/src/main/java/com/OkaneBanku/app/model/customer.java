package com.OkaneBanku.app.model;

public class customer {

	private String firstname;
	private String lastname;
	private String customerUsername;
	private String customerPassword;
	private double checkingbalance;
	private double savingbalance;
	private int accountid;
	private boolean pending;
	private int customerid;

	public customer() {

	}

	// for service
	public customer(String firstname, String lastname, String customerUsername, String customerPassword,
			double checkingbalance, double savingbalance, int accountid, boolean pending) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.checkingbalance = checkingbalance;
		this.savingbalance = savingbalance;
		this.accountid = accountid;
		this.pending = pending;
	}
	

	public customer(String firstname, String lastname, String customerUsername, String customerPassword) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
	}

	public customer(String firstname, String lastname, String customerUsername, String customerPassword,
			boolean pending, int customerid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.pending = pending;
		this.customerid = customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public double getCheckingbalance() {
		return checkingbalance;
	}

	public void setCheckingbalance(double checkingbalance) {
		this.checkingbalance = checkingbalance;
	}

	public double getSavingbalance() {
		return savingbalance;
	}

	public void setSavingbalance(double savingbalance) {
		this.savingbalance = savingbalance;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	

	@Override
	public String toString() {
		return "customer [firstname=" + firstname + ", lastname=" + lastname + ", customerUsername=" + customerUsername
				+ ", pending=" + pending + ", customerid=" + customerid
				+ "]";
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	
}
