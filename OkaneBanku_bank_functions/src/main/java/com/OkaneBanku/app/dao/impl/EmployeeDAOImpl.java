package com.OkaneBanku.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.OkaneBanku.app.dao.EmployeeDAO;
import com.OkaneBanku.app.dao.dbutil.PostgresConnection;
import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.main.Main;
import com.OkaneBanku.app.model.customer;
import com.OkaneBanku.app.model.employee;
import com.OkaneBanku.app.model.transaction;

public class EmployeeDAOImpl implements EmployeeDAO {
	PostgresConnection pc = new PostgresConnection();
	private static Logger daoerror = Logger.getLogger(Main.class);

	@Override
	public List<transaction> viewLogs(int customerid) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomer(customer customer) throws BusinessException {
		int c = 0;
		try {
			Connection connection = pc.getConnection();
			String sql = "insert into bank_schema.customer(firstname, lastname, username, password, pending) values (?????)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getLastname());
			preparedStatement.setString(3, customer.getCustomerUsername());
			preparedStatement.setString(4, customer.getCustomerPassword());
			preparedStatement.setBoolean(5, false);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			daoerror.error("Unable to reach database");
		}
	}

	@Override
	public void validateCustomer(int customerid, boolean verify) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<customer> getAllpendingaccounts() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<customer> getAllverifiedaccounts() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employee logincheck(String username) throws BusinessException {
		employee emp = new employee();
		try {
			Connection connection = pc.getConnection();
			String q = "select * from bank_schema.employee where username = " + username + "";
			Statement state = connection.createStatement();
			ResultSet rs = state.executeQuery(q);
			while(rs.next()) {
				String uname = rs.getString("username");
				String pw = rs.getString("password");
				int eid = rs.getInt("employeeid");
				emp = new employee(uname, pw, eid);
			}
		} catch (ClassNotFoundException | SQLException e) {
	
			daoerror.error("Unable to reach database");
			
		} 
		return emp;
	}

}
