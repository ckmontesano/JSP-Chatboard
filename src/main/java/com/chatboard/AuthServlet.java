package com.chatboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private boolean authenticateUser(MySQLConnector mysqlConnector, String username, String password) throws SQLException {
    	
    	// create query
    	String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
    	
    	// get result set
    	ResultSet rs = mysqlConnector.query(query);
    	
    	return rs.next(); // rs.next() returns true if 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String authType = request.getParameter("authType");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		out.println("Auth type is: " + authType + "\n");
		
		if ( authType != null && authType.equals("login") ) {
			// validate credentials
			// todo: this
			out.println("Username is: " + username);
			out.println("Password is: " + password);
			boolean loginResult = false;
			
			MySQLConnector mysqlConnector = new MySQLConnector();
			
			if( !mysqlConnector.connect() ) {
				out.println("SQL Connection failed.");
			}
			
			try {
				loginResult = authenticateUser(mysqlConnector, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if ( loginResult ) {
				// user is authenticated
				
				// set session vars
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				
				// redirect user (temp disabled)
				response.sendRedirect(request.getContextPath() + "/home.jsp");
			} else {
				// user authentication failed.
				out.println("\nUser authentication failed.");
			}
			
			// terminate sql connection
			//mysqlConnector.disconnect():
			
		}
		else {
			// no auth type provided, send user back to auth page
			response.sendRedirect(request.getContextPath() + "/auth.jsp");
		}
	}

}
