package com.OkaneBanku.app.service.impl;

import com.OkaneBanku.app.dao.CustomerDAO;

import com.OkaneBanku.app.dao.impl.CustomerDAOImpl;
import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.customer;
import com.OkaneBanku.app.service.CustomerService;

public class CustomerImpl implements CustomerService {

	CustomerDAO customerdao = new CustomerDAOImpl();

//finish validations
	@Override
	public void createCustomer(customer customer, double checkingbalance, double savingbalance)
			throws BusinessException {
		if(!CustomerValidations.isFirstNameValid(customer.getFirstname())) {
			throw new BusinessException("Entered firstname "+ customer.getFirstname()+" is invalid");
		}
		if(!CustomerValidations.isLastNameValid(customer.getLastname())) {
			throw new BusinessException("Entered lastname "+ customer.getLastname()+" is invalid");
		}
		if(!CustomerValidations.isUsernameValid(customer.getCustomerUsername())) {
			throw new BusinessException("Entered usernamename "+ customer.getCustomerUsername()+" is invalid");
		}
		if(!CustomerValidations.isPasswordValid(customer.getCustomerPassword())) {
			throw new BusinessException("Entered password "+ customer.getCustomerPassword()+" is invalid");
		}
		customerdao.createCustomer(customer);
		customer customerusername = customerdao.logincheck(customer.getCustomerUsername());
		customerdao.createAccountBalance(checkingbalance, savingbalance, customerusername.getCustomerid());
	}

	@Override
	public double viewSavingAcc(int customerid) throws BusinessException {
		
		
		return customerdao.viewSavingAcc(customerid);
	}

	@Override
	public double viewCheckingAcc(int customerid) throws BusinessException {
		
		return customerdao.viewCheckingAcc(customerid);
	}

	@Override
	public double withdrawChecking(int customerid, double withdraw) throws BusinessException {
		
		if (withdraw > customerdao.viewCheckingAcc(customerid)) {
			throw new BusinessException("Entered amount: " + withdraw + " is invalid");
		}
		return customerdao.withdrawChecking(customerid, withdraw);
	}

	@Override
	public double withdrawSaving(int customerid, double withdraw) throws BusinessException {
		
		if (withdraw > customerdao.viewSavingAcc(customerid)) {
			throw new BusinessException("Entered amount: " + withdraw + " is invalid");
		}
		return customerdao.withdrawSaving(customerid, withdraw);
	}

	@Override
	public double depositChecking(int customerid, double deposit) throws BusinessException {
	
		if (deposit <= 0) {
			throw new BusinessException("Entered amount: " + deposit + " is invalid");
		}
		return customerdao.depositChecking(customerid, deposit);
	}

	@Override
	public double depositSaving(int customerid, double deposit) throws BusinessException {
		
		if (deposit <= 0) {
			throw new BusinessException("Entered amount: " + deposit + " is invalid");
		}

		return customerdao.depositSaving(customerid, deposit);
	}

	@Override
	public double transferSaving(int customerid, double transfer) throws BusinessException {
		if (transfer <= 0) {
			throw new BusinessException("Entered amount: " + transfer + " is invalid");
		}
		if (transfer > customerdao.viewCheckingAcc(customerid)) {
			throw new BusinessException("Entered amount: " + transfer + " is invalid");
		}
		return customerdao.transferSaving(customerid, transfer);
	}

	@Override
	public double transferChecking(int customerid, double transfer) throws BusinessException {
		if (transfer <= 0) {
			throw new BusinessException("Entered amount: " + transfer + " is invalid");
		}
		if (transfer > customerdao.viewCheckingAcc(customerid)) {
			throw new BusinessException("Entered amount: " + transfer + " is invalid");
		}
		return customerdao.transferChecking(customerid, transfer);
	}

	@Override
	public boolean logincheck(String username, String password) throws BusinessException {
		if (customerdao.logincheck(username).getCustomerUsername() == null) {
			return false;
		}
		if (customerdao.logincheck(username).getCustomerUsername().equals(username)
				&& customerdao.logincheck(username).getCustomerPassword().equals(password)) {
			return true;
		}
		return false;

	}

	// NOT INITIALIZED DEBUGGING REQUIRED
	@Override
	public void addPendingTransfer(int customerid, double transfer) throws BusinessException {
		if (transfer <= 0) {
			throw new BusinessException("Entered amount: " + transfer + " is invalid");
		}
		customerdao.addPendingTransfer(customerid, transfer);
	}

	// NOT INITIALIZED DEBUGGING REQUIRED
	@Override
	public double viewPendingTransfer(int customerid) throws BusinessException {

		return customerdao.viewPendingTransfer(customerid);
	}

	// NOT INITIALIZED DEBUGGING REQUIRED
	@Override
	public boolean approvePendingTransfer(int customerid) throws BusinessException {

		return customerdao.approvePendingTransfer(customerid);
	}

	// NOT INITIALIZED DEBUGGING REQUIRED
	@Override
	public boolean deleteTransfer(int customerid) throws BusinessException {

		return customerdao.deleteTransfer(customerid);
	}

	@Override
	public customer retrieveCustomer(String username) throws BusinessException {

		return customerdao.logincheck(username);
	}

}
