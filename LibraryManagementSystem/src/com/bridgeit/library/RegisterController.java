package com.bridgeit.library;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String email, fullname, password, conf_password, phone, gender;
		DBService service = new DBService();
		RequestDispatcher dispatcher;
		User user = new User(email, fullname, password, phone, gender);
		if (service.basicValidation()) {// basic validation

			if (!(service.alreadyRegistered(user))) { // not already registered. so add user to database.
				service.addUser(user);
				request.setAttribute("message", "registersuccess");
				dispatcher = request.getRequestDispatcher("LibraryHomepage.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("message", "alreadyregistered");
				dispatcher = request.getRequestDispatcher("LibraryRegister.jsp");
				dispatcher.forward(request, response);
			}
		}

		else {
			request.setAttribute("message", "syntaxerror");
			dispatcher = request.getRequestDispatcher("LibraryRegister.jsp");
			dispatcher.forward(request, response);
		}

	}

}
