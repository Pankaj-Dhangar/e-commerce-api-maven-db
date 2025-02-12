package org.dnyanyog.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
	private static String url ="jdbc:mysql://127.0.0.1:3306/e-commerce-api";
	private static String username ="root";
	private static String pass = "Pankaj@420";
	
	private static Connection connection;
	
	static 
	{
		try {
			connection = DriverManager.getConnection(url,username,pass);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Add user
	public static boolean executeQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.execute(query);
	}
	// Display user
	public static ResultSet executeSelectQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		return result;
	}
	
}
