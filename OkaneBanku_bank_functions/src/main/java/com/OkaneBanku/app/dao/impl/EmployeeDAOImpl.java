package com.OkaneBanku.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

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
	public void validateCustomer(int customerid) throws BusinessException {
		int c = 0;
		String sql = "update bank_schema.customer set pending = true where customerid = "+customerid+"";
		try(Connection connection = pc.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			c= preparedStatement.executeUpdate();
		
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			daoerror.error("Contact Sys Admin");
		}
	}

	public customer makecustomer(ResultSet c) throws SQLException{
		customer cust = new customer(c.getString("firstname"), c.getString("lastname"), c.getString("username"), c.getString("pw"), c.getBoolean("pending"), c.getInt("customerid"));
		return cust;
		
	}
	@Override
	public List<customer> getAllpendingaccounts() throws BusinessException {
		List<customer> pending = new ArrayList<>();
		String l = "select * from bank_schema.customer where pending = false";
		try (Connection connection = pc.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(l);
			ResultSet p = preparedStatement.executeQuery();
			while(p.next()) {
				pending.add(makecustomer(p));
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoerror.error("Contact Sys Admin");
		}
		return pending;
	}

	@Override
	public List<customer> getAllverifiedaccounts() throws BusinessException {
		List<customer> pending = new ArrayList<>();
		String l = "select * from bank_schema.customer where pending = true";
		try (Connection connection = pc.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(l);
			ResultSet p = preparedStatement.executeQuery();
			while(p.next()) {
				pending.add(makecustomer(p));
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoerror.error("Contact Sys Admin");
		}
		return pending;
	}
	
	@Override
	public employee logincheck(String username) throws BusinessException {
		employee emp = new employee();
		try (Connection connection = pc.getConnection()){
			String q = "select * from bank_schema.employee where username = '" + username + "'";
			Statement state = connection.createStatement();
			ResultSet rs = state.executeQuery(q);
			while(rs.next()) {
				String uname = rs.getString("username");
				String pw = rs.getString("pw");
				int eid = rs.getInt("employeeid");
				emp = new employee(uname, pw, eid);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			daoerror.error("Unable to reach database");
			
		} 
		return emp;
	}

}
