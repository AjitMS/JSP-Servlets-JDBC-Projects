package com.ToDoApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ToDoController
 */
@WebServlet("/ToDoController")
public class ToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// REMAINING ONLY GET METHOD FOR UPDATE : PENDING
		// Update
	}

	List<Task> taskList;
	HttpSession session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();

		ToDoService service = new ToDoService();
		String action = request.getParameter("action");
		try {
			service.loadList(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		switch (action) {

		case "add":
			try {
				service.addTask(request, response);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "delete":
			service.deleteTask(request, response);
			break;
		case "update":
			try {
				service.updateTask(request, response);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "load":
			try {
				service.loadList(request, response);
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
			break;
		default:
			try {
				service.loadList(request, response);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		try {
			System.out.println("Reacghed out of switch");
			service.loadList(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}