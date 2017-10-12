package com.ToDoApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

	ToDoDAO serviceDB;

	@Override
	public void init() throws ServletException {

		serviceDB = new ToDoDAO();

	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;
		Task task = null;

		String taskName = (String) request.getParameter("taskname");
		if (taskName == null) {
			System.out.println("Task found is null");
		} else {
			System.out.println("Task found is " + taskName + " ");

			String action = request.getParameter("action");
			System.out.println("action in controller is: " + action);
			try {
				task = serviceDB.getTask(taskName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				System.out.println("Task Name: " + task.getName());
				System.out.println("Priority: " + task.getPriority());
				System.out.println("Date: " + task.getDate());
			} catch (Exception E) {
				System.out.println("NullPointer Exception");
			}
			if (action == null)
				System.out.println("NOT WORKING !!!");
			else {
				if (action.equals("update")) {
					request.setAttribute("action", "update");
					request.setAttribute("task", task);
					dispatcher = request.getRequestDispatcher("ToDoUpdate.jsp");
					dispatcher.forward(request, response);
				}
				if (action.equals("delete")) {
					request.setAttribute("task", task);
					request.setAttribute("action", "delete");
					dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String taskName = request.getParameter("name");

		System.out.println("new name: " + taskName);
		String priority = request.getParameter("priority");
		String date = request.getParameter("date");

		System.out.println("new Date: " + date);
		String old_taskName = (String) request.getParameter("old_taskname");
		String action = (String) request.getParameter("command");
		Task task = new Task(taskName, date, priority);
		serviceDB = new ToDoDAO();
		try {
			if (action != null) {
				switch (action) {
				case "delete":
					try {
						serviceDB.delete(taskName);
						List<Task> taskList = serviceDB.loadListDB();
						request.getServletContext().setAttribute("taskList", taskList);
						//session.setAttribute("taskList", taskList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
						dispatcher.forward(request, response);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case "update":
					try {
						serviceDB.update(task, old_taskName);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					List<Task> taskList = serviceDB.loadListDB();
					request.getServletContext().setAttribute("taskList", taskList);
					//session.setAttribute("taskList", taskList);
					RequestDispatcher dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
					dispatcher.forward(request, response);
					break;
				default:
					throw new IllegalArgumentException("Invalid Command: " + action);
				}
			}
		} catch (Exception e) {
			System.out.println("Naacho");
		}

	}

}
