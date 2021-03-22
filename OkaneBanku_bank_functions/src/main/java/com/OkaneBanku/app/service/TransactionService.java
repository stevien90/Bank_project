package com.OkaneBanku.app.service;

import com.OkaneBanku.app.exception.BusinessException;

public interface TransactionService {
	public int withdrawChecking(int checkingwithdraw) throws BusinessException;
	public int withdrawSaving(int savingwithdraw) throws BusinessException;
	public int depositChecking(int checkingdeposit) throws BusinessException;
	public int depositSavinging(int savingdeposit) throws BusinessException;
	public int transferChecking(int checkingtransfer) throws BusinessException;
	public int transferSaving(int savingtransfer) throws BusinessException;
}
