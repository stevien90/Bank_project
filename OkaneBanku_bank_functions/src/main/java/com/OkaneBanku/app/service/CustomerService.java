package com.OkaneBanku.app.service;

import com.OkaneBanku.app.exception.BusinessException;

import com.OkaneBanku.app.model.customer;

public interface CustomerService {
	
	public void createCustomer(customer customer, double checkingbalance, double savingbalance) throws BusinessException;
	public double viewSavingAcc(int customerid ) throws BusinessException; 
	public double viewCheckingAcc(int customerid) throws BusinessException;
	public double withdrawChecking(int customerid, double withdraw) throws BusinessException;
	public double withdrawSaving(int customerid, double withdraw) throws BusinessException;
	public double depositChecking(int customerid, double deposit) throws BusinessException;
	public double depositSaving(int customerid, double deposit) throws BusinessException;
	public double transferChecking(int customerid, double transfer) throws BusinessException;
	public double transferSaving(int customerid, double transfer) throws BusinessException;
	public boolean logincheck(String username, String password) throws BusinessException; 
	public void addPendingTransfer(int customerid, double transfer) throws BusinessException;//NOT INITIALIZED DEBUGGING REQUIRED
	public double viewPendingTransfer(int customerid) throws BusinessException;//NOT INITIALIZED DEBUGGING REQUIRED
	public boolean approvePendingTransfer(int customerid) throws BusinessException;//NOT INITIALIZED DEBUGGING REQUIRED
	public boolean deleteTransfer(int customerid) throws BusinessException;//NOT INITIALIZED DEBUGGING REQUIRED
	public customer retrieveCustomer(String username) throws BusinessException;
	
}
