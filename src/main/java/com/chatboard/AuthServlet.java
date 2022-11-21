package com.chatboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		out.println("Auth type is: " + authType); // will not show due to redirect
		
		if ( authType != null && authType.equals("login") ) {
			// validate credentials
			// todo: this
			out.println("Username is: " + username); // will not show due to redirect
			out.println("Password is: " + password); // will not show due to redirect
			
			// set session vars
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect(request.getContextPath() + "/home.jsp");
		}
		else {
			// no auth type provided, send user back to auth page
			response.sendRedirect(request.getContextPath() + "/auth.jsp");
		}
		
		
	}

}
