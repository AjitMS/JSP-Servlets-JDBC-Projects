package com.ToDoApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
		ToDoDAO dao = new ToDoDAO();
		String email, password;
		List <Task>taskList = new ArrayList<>();
		RequestDispatcher dispatcher = null;
		email = request.getParameter("email");
		password = request.getParameter("password");
		ToDoDAO service = new ToDoDAO();
		try {
			if (service.authenticateUser(email, password)) {
				taskList = dao.loadListDB();
				request.setAttribute("taskList", taskList);
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
