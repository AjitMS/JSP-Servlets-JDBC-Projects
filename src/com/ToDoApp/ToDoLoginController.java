package com.ToDoApp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToDoLoginController
 */
@WebServlet("/ToDoLoginController")
public class ToDoLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email, password;
		RequestDispatcher dispatcher = null;
		email = request.getParameter("email");
		password = request.getParameter("password");
		ToDoDBService service = new ToDoDBService();
		try {
			if (service.authenticateUser(email, password)) {
				dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("error", "error");
				dispatcher = request.getRequestDispatcher("ToDoLogin.jsp");
				dispatcher.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
