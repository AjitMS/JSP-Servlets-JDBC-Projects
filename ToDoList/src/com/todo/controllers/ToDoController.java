package com.todo.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.dao.ToDoDAO;
import com.todo.model.Task;
import com.todo.service.ToDoService;

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

	ToDoDAO serviceDB;

	@Override
	public void init() throws ServletException {

		serviceDB = new ToDoDAO();
		service = new ToDoService();

	}

	ToDoService service;

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
			} catch (Exception e) {
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
				System.out.println("Connection NOT WORKING !!!");
			else {
				if (action.equals("update")) {
					request.setAttribute("action", "update");
					request.setAttribute("task", task);
					dispatcher = request.getRequestDispatcher("ToDoUpdate.jsp");
					dispatcher.forward(request, response);
				}
				if (action.equals("delete")) {

					request.setAttribute("name", task.getName());
					service.deleteTask(request, response);
					
				}
			}
		}

	}

	List<Task> taskList;
	HttpSession session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		service = new ToDoService();
		String action = request.getParameter("action");
		System.out.println("action is: " + action);

		switch (action) {

		case "add":
			try {
				service.addTask(request, response);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
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

	}

}