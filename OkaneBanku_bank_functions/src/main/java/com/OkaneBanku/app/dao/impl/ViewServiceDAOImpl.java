package com.OkaneBanku.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.OkaneBanku.app.dao.ViewServiceDao;
import com.OkaneBanku.app.dao.dbutil.PostgresConnection;
import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.account;


public class ViewServiceDAOImpl implements ViewServiceDao{

	@Override
	public int viewSavingAcc(int savingBalance) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int viewCheckingAcc(int checkingBalance) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<account> getAllaccounts() throws BusinessException{
		List<account> accountList=new ArrayList<>();
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "select accountid from customer_schema.account";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				account account = new account();
				account.setAccountid(resultSet.getInt("accountid"));
				accountList.add(account);
				
			}
			if(accountList.size()==0) {
				throw new BusinessException("No accounts has been created so far");
			}
		}catch(ClassNotFoundException | SQLException e){
			throw new BusinessException("Internal error Contact Sys Admin");
		}
		return accountList;
	}

}