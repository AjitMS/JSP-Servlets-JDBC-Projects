package com.bridgeit.Controllers;

import com.bridgeit.DAO.*;
import com.bridgeit.DTO.*;
import com.bridgeit.Utilities.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
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
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String conf_password = request.getParameter("conf_password");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");

		DBUserService service = new DBUserService();
		MyUtility utilities = new MyUtility();
		RequestDispatcher dispatcher;
		User user = new User(email, fullname, phone, password, gender);
		String errorString;
		try {
			errorString = utilities.basicValidation(user, conf_password); //adding errors to a string
			if (utilities.noErrorExists(errorString)) {// basic validation

				if (!(service.alreadyRegistered(user))) { // not already registered. so add user to database.
					service.registerUser(user);
					System.out.println("Added !!");
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user);
					request.setAttribute("message", "registersuccess");
					request.setAttribute("command", "showhomepage");
					dispatcher = request.getRequestDispatcher("LibraryHomepage.jsp");
					dispatcher.forward(request, response);
				} else {
					System.out.println("already User");
					request.setAttribute("message", "alreadyregistered");
					request.setAttribute("command", "showregister");
					dispatcher = request.getRequestDispatcher("LibraryRegister.jsp");
					dispatcher.forward(request, response);
				}
			}

			else {
				System.out.println("syntax error !!");
				request.setAttribute("message", errorString);
				request.setAttribute("command", "showregister");
				dispatcher = request.getRequestDispatcher("LibraryRegister.jsp");
				dispatcher.forward(request, response);

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}