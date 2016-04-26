package com.portal.controller;

import java.sql.SQLException;
import java.sql.Statement;

import com.portal.model.*;

public class Create {
	private static int id = 0;
	public int createOperation(User user) { 
		DatabaseConnection databaseConnection = new DatabaseConnection();
		user.setId(id++);
		Statement statement = databaseConnection.setUp();	  
	    try {  
			statement.executeUpdate("INSERT INTO user_info VALUES " +
					 "('" + user.getId() + "', '"
							+ user.getFirstName() + "', '"
							+ user.getLastName() + "', '"
							+ user.getAddress() + "', '"
							+ user.getDob() + "', '"
							+ user.getBloodGroup() + "', '"
							+ user.getPhoneNumber() + "', '"
							+ user.getUserName() + "', '"
							+ user.getPassword() + "');");
	      } catch (SQLException e) {
			System.out.println(e.getMessage());
	      } catch (Exception e) {
	    	  System.out.println(e.getMessage() + "Exception generated");  
	      }
		return id;
	}
}
