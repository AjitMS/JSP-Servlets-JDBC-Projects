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
 * Servlet implementation class ToDoUpdateController
 */
@WebServlet("/ToDoUpdateController")
public class ToDoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if(!(action==null))
		System.out.println("Came HERE!!!!"+action);
		if (action.equals("update")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ToDoUpdate.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("delete")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ToDoDelete.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String taskName = request.getParameter("taskName");
		String action = request.getParameter("action");
		ToDoService service = new ToDoService();
		if (action.equals("update")) {
			try {

				String priority = request.getParameter("priority");
				String name = request.getParameter("name");
				String date = request.getParameter("date");
				Task task = new Task(name, date, priority);
				service.update(task, taskName);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (action.equals("delete")) {
			service.delete(taskName);
		}

		// String uri = request.getRequestURI();
		// if (uri.endsWith("/update")) {
		// service.update(response, request);
		// } else if (uri.endsWith("/delete")) {
		// service.delete(response, request);
		// }
	}

}
