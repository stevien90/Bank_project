package com.OkaneBanku.app.dao;

import java.util.List;

import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.account;


public interface ViewServiceDao {

	public int viewSavingAcc(int savingBalance) throws BusinessException;
	public int viewCheckingAcc(int checkingBalance) throws BusinessException;
	public List<account> getAllaccounts() throws BusinessException;
}
