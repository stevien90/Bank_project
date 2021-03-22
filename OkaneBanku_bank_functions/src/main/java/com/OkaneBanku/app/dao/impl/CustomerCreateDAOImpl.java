package com.OkaneBanku.app.dao.impl;

import java.sql.SQLException;



import java.sql.Connection;
import java.sql.PreparedStatement;

import com.OkaneBanku.app.dao.CustomerCreateDAO;
import com.OkaneBanku.app.dao.dbutil.PostgresConnection;
import com.OkaneBanku.app.exception.BusinessException;

import com.OkaneBanku.app.model.customer;

public class CustomerCreateDAOImpl implements CustomerCreateDAO {
	

	@Override
	public int createCustomer(customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into bank_schema.customer(firstname,lastname,city,phone,email) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getLastname());
			preparedStatement.setString(3, customer.getCity());
			preparedStatement.setString(4, customer.getPhone());
			preparedStatement.setString(5, customer.getEmail());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured... Please contact SyssAdmin");
			/// need file logj4
		}
		
		return c;
	}

}
