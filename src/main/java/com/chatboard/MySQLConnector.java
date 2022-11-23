package com.chatboard;

import java.sql.*;

public class MySQLConnector {
	private static String host = "localhost";
	private static String username = "chatboard";
	private static String password = "pass";
	private static String database = "chatboard";
	private static String url = "jdbc:mysql://localhost:3306/" + database;
	
	public Connection conn = null;
	private Statement statement = null;
	
	public boolean connect() {
		try {
			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver");
			
			// get connection
			conn = DriverManager.getConnection(url, username, password);
			
			// return success
			System.out.println("MySQL connection success");
			return true;
		}
		catch( Exception e ) {
			// show error
			System.out.println("MySQL connection failure: " + e );
			return false;
		}
	}
	
	public ResultSet query( String query ) throws SQLException {
		// needed to query
		this.statement = this.conn.createStatement();
		
		ResultSet rs = statement.executeQuery(query);
		
		return rs;
	}
}
