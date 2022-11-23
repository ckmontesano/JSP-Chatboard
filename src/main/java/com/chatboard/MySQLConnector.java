package com.chatboard;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnector {
	private static String host = "localhost";
	private static String username = "chatboard";
	private static String password = "pass";
	private static String database = "chatboard";
	private static String url = "jdbc:mysql://localhost:3306/" + database;
	public Connection conn = null;
	
	public boolean connect() {
		try {
			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver");
			
			// get connection
			DriverManager.getConnection(url, username, password);
			
			// return success
			System.out.println("Connection success");
			return true;
		}
		catch( Exception e ) {
			// show error
			System.out.println("Connection failure: " + e );
			return false;
		}
	}
}
