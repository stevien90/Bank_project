package com.OkaneBanku.app.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.OkaneBanku.app.dao.CustomerDAO;
import com.OkaneBanku.app.dao.dbutil.PostgresConnection;
import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.main.Main;
import com.OkaneBanku.app.model.customer;

public class CustomerDAOImpl implements CustomerDAO {
	private static Logger daoerror = Logger.getLogger(Main.class);
	PostgresConnection pc = new PostgresConnection();

	@Override
	public void createCustomer(customer customer) throws BusinessException {
		int c = 0;
		try(Connection connection = pc.getConnection()) {
			String sql = "insert into bank_schema.customer(firstname, lastname, username, pw, pending) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getLastname());
			preparedStatement.setString(3, customer.getCustomerUsername());
			preparedStatement.setString(4, customer.getCustomerPassword());
			preparedStatement.setBoolean(5, false);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			
			daoerror.error("Contact Sys Admin");
			
		}
	}

	@Override
	public double viewSavingAcc(int customerid) throws BusinessException {
		double balance = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "select savingbalance from bank_schema.account where customerid = "+customerid+"";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				balance = rs.getDouble("savingbalance");
			}
		} catch (ClassNotFoundException | SQLException e) {
	
			daoerror.error("Contact Sys Admin");
		}

		return balance;
	}

	@Override
	public double viewCheckingAcc(int customerid) throws BusinessException { // can use this for validations 
		double balance = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "select checkingbalance from bank_schema.account where customerid = "+customerid+"";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				balance = rs.getDouble("checkingbalance");
			}
		} catch (ClassNotFoundException | SQLException e) {
		
			daoerror.error("Contact Sys Admin");
		}

		return balance;
	}

	@Override
	public double withdrawChecking(int customerid, double withdraw) throws BusinessException {
		double checkingbalance = viewCheckingAcc(customerid);
		int c = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "update bank_schema.account set checkingbalance = ? where customerid = "+customerid+"";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setDouble(1, (checkingbalance - withdraw));
			c = preparestatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
		
			daoerror.error("Contact Sys Admin");
	
		}
		return (checkingbalance - withdraw);
	}

	@Override
	public double withdrawSaving(int customerid, double withdraw) throws BusinessException {
		double savingbalance = viewSavingAcc(customerid);
		int c = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "update bank_schema.account set savingbalance = ? where customerid = "+customerid+"";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setDouble(1, (savingbalance - withdraw));
			c = preparestatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			
			daoerror.error("Contact Sys Admin");
	
		}
		return (savingbalance - withdraw);
	}

	@Override
	public double depositChecking(int customerid, double deposit) throws BusinessException {
		double checkingbalance = viewCheckingAcc(customerid);
		int c = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "update bank_schema.account set checkingbalance = ? where customerid = "+customerid+"";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setDouble(1, (checkingbalance + deposit));
			c = preparestatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			
			daoerror.error("Contact Sys Admin");
	
		}
		return (checkingbalance + deposit);
	}

	@Override
	public double depositSaving(int customerid, double deposit) throws BusinessException {
		double savingbalance = viewSavingAcc(customerid);
		int c = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "update bank_schema.account set savingbalance = ? where customerid = "+customerid+"";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setDouble(1, (savingbalance + deposit));
			c = preparestatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
		
			daoerror.error("Contact Sys Admin");
	
		}
		return (savingbalance + deposit);
	}
	@Override
	public double transferChecking(int customerid, double transfer) throws BusinessException {
		double checkingbalance = viewCheckingAcc(customerid);
		double savingbalance  = viewSavingAcc(customerid);
		try (Connection connection = pc.getConnection()){
			
			String sql = "update bank_schema.account set checkingbalance = ? where customerid =" + customerid+"";
			String sql2 = "update bank_schema.account set savingbalance = ? where customerid = "+customerid+"";
			connection.setAutoCommit(false);
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setDouble(1, (checkingbalance - transfer));
			preparestatement.addBatch();
			PreparedStatement preparestatement2 = connection.prepareStatement(sql2);
			preparestatement2.setDouble(1, (savingbalance + transfer));
			preparestatement2.addBatch();
			preparestatement.executeUpdate();
			preparestatement2.executeUpdate();
			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			
	
			daoerror.error("Contact Sys Admin");
		}
		return (savingbalance + transfer);
	}

	@Override
	public double transferSaving(int customerid, double transfer) throws BusinessException {
		
		double checkingbalance = viewCheckingAcc(customerid);
		double savingbalance  = viewSavingAcc(customerid);
		try (Connection connection = pc.getConnection()){
			String sql = "update bank_schema.account set savingbalance = ? where customerid =" + customerid + "";
			String sql2 = "update bank_schema.account set checkingbalance = ? where customerid = "+customerid+"";
			connection.setAutoCommit(false);
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setDouble(1, (savingbalance - transfer));
			preparestatement.addBatch();
			PreparedStatement preparestatement2 = connection.prepareStatement(sql2);
			preparestatement2.setDouble(1, (checkingbalance + transfer));
			preparestatement2.addBatch();
			preparestatement.executeUpdate();
			preparestatement2.executeUpdate();
			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {		
			
			daoerror.error("Contact Sys Admin");
	
		}
		return (checkingbalance + transfer);
	}
	@Override
	public customer logincheck(String username) throws BusinessException {
		customer c = new customer();
		try (Connection connection = pc.getConnection()){
			String q = "select * from bank_schema.customer where username = '" + username + "'";
			Statement state = connection.createStatement();
			ResultSet rs = state.executeQuery(q);
			while(rs.next()) {
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String uname = rs.getString("username");
				String pw = rs.getString("pw");
				Boolean p = rs.getBoolean("pending");
				int cid = rs.getInt("customerid");
				c = new customer(fname, lname, uname, pw, p, cid);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			daoerror.error("Contact Sys Admin");
			
		} 
		return c;
	}

	@Override
	//NOT INITIALIZED DEBUGGING REQUIRED
	public void addPendingTransfer(int customerid, double amount) throws BusinessException {
		int c = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "insert into bank_schema.transfer(customerid, amount) values (?,?)";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, (customerid));
			preparestatement.setDouble(2, amount);
			c = preparestatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
			daoerror.error("Contact Sys Admin");
	
		}
	}

	@Override
	//NOT INITIALIZED DEBUGGING REQUIRED
	public double viewPendingTransfer(int customerid) throws BusinessException {
		double amount = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "select amount from bank_schema.transfer where customerid =" + customerid + "";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				amount = rs.getDouble("amount");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			daoerror.error("Contact Sys Admin");
		}

		return amount;
	}

	@Override
	//NOT INITIALIZED DEBUGGING REQUIRED
	public boolean approvePendingTransfer(int customerid) throws BusinessException {
		int c = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "update bank_schema.transfer set pendingtransaction = ? where customerid =" + customerid + "";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setBoolean(1, (true));
			c = preparestatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
			daoerror.error("Contact Sys Admin");
	
		}
		return true;
	}

	@Override
	//NOT INITIALIZED DEBUGGING REQUIRED
	public boolean deleteTransfer(int customerid) throws BusinessException { 
		int c = 0;
		try (Connection connection = pc.getConnection()){
			String sql = "delete bank_schema.transfer where customerid =" + customerid + "";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			c = preparedstatement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
			daoerror.error("Contact Sys Admin");
		}
		return true;
	}

	@Override
	public void createAccountBalance(double checking, double saving, int customerid) throws BusinessException {
		int c = 0;
		try(Connection connection = pc.getConnection()) {
			String sql = "insert into bank_schema.account(customerid, checkingbalance, savingbalance) values (?,?,?)";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, (customerid));
			preparestatement.setDouble(2, (checking));
			preparestatement.setDouble(3, (saving));
			c = preparestatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {			
			daoerror.error("Contact Sys Admin");
	
		}
	}

}
