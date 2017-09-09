package com.bridgeit.Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgeit.DAO.DBUserService;
import com.bridgeit.DTO.User;

/**
 * Servlet implementation class LibraryLogin
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Authenticion begins");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		DBUserService dbService = new DBUserService();
		RequestDispatcher dispatcher;
		try {
			if(dbService.authenticateUser(email, password)) {
				User user = dbService.getUserObject(email);
				System.out.println("Username in Controller is: "+user.getFullname());
				logger.info("Reached in successful...");
				request.setAttribute("message", "showlist");
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("email", user.getEmail());
				dispatcher = request.getRequestDispatcher("LibraryHomepage.jsp");
				dispatcher.forward(request, response);	
			}
				
			else {
				System.out.println("Reached in error...");
				request.setAttribute("message", "loginerror");
				logger.warn("Error in authentication");
				dispatcher = request.getRequestDispatcher("LibraryLogin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
