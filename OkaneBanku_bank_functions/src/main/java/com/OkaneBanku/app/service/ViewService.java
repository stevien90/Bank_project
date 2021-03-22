package com.OkaneBanku.app.service;

import java.util.List;

import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.account;
import com.OkaneBanku.app.model.customer;

public interface ViewService {

	public int viewSavingAcc(int savingBalance) throws BusinessException;
	public int viewCheckingAcc(int checkingBalance) throws BusinessException;
	public List<account> getAllAccounts()throws BusinessException;
}
