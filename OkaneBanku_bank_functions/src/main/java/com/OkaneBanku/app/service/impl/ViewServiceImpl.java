package com.OkaneBanku.app.service.impl;

import java.util.List;

import com.OkaneBanku.app.dao.ViewServiceDao;
import com.OkaneBanku.app.dao.impl.ViewServiceDAOImpl;
import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.account;

import com.OkaneBanku.app.service.ViewService;

public class ViewServiceImpl implements ViewService{
	private ViewServiceDao viewDAO = new ViewServiceDAOImpl();
	@Override
	public int viewSavingAcc(int savingBalance) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<account> getAllAccounts() throws BusinessException {
		// TODO Auto-generated method stub
		return viewDAO.getAllaccounts();
	}



	@Override
	public int viewCheckingAcc(int checkingBalance) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
