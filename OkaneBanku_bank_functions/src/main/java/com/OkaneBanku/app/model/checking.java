package com.OkaneBanku.app.model;

public class checking {
private int checkingBalance;
private int checkingwithdraw;
private int checkingdeposit;
private int checkingtransfer;

public checking() {
	// TODO Auto-generated constructor stub
}

public int getCheckingBalance() {
	return checkingBalance;
}

public void setCheckingBalance(int checkingBalance) {
	this.checkingBalance = checkingBalance;
}


public int getCheckingwithdraw() {
	return checkingwithdraw;
}

public void setCheckingwithdraw(int checkingwithdraw) {
	this.checkingwithdraw = checkingwithdraw;
}

public int getCheckingdeposit() {
	return checkingdeposit;
}

public void setCheckingdeposit(int checkingdeposit) {
	this.checkingdeposit = checkingdeposit;
}

public int getCheckingtransfer() {
	return checkingtransfer;
}

public void setCheckingtransfer(int checkingtransfer) {
	this.checkingtransfer = checkingtransfer;
}

@Override
public String toString() {
	return "checking [checkingBalance=" + checkingBalance + ", checkingwithdraw=" + checkingwithdraw
			+ ", checkingdeposit=" + checkingdeposit + ", checkingtransfer=" + checkingtransfer + "]";
}


}