package com.portal.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static  Connection connection;
	private static  Statement statement;

	public Statement setUp() { 
		String DB_URL = "jdbc:mysql://localhost:3306/user";
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, "root", "");
			statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
        	System.out.println(e.getMessage());
		} catch (SQLException e) {			
			System.out.println(e.getMessage());
		}
		return statement;
	}
}
