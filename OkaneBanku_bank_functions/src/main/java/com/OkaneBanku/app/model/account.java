package com.OkaneBanku.app.model;

public class account {
private int accountid;


public account() {
}

public account(int accountid) {
	super();
	this.accountid = accountid;
}

public int getAccountid() {
	return accountid;
}

public void setAccountid(int accountid) {
	this.accountid = accountid;
}

@Override
public String toString() {
	return "account [accountid=" + accountid + "]";
}

}
