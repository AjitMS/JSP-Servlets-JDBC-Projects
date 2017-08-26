package com.ToDoApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToDoService {
	ToDoDBService serviceDB;
	HttpSession session;
	RequestDispatcher dispatcher;

	public void loadList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		session = request.getSession();
		serviceDB = new ToDoDBService();
		List<Task> taskList = (List<Task>) serviceDB.loadListDB(); // session.getAttribute("taskList");
		if (taskList == null)
			taskList = new ArrayList<>();
		request.getServletContext().setAttribute("taskList", taskList);
		// session.setAttribute("taskList", taskList);
		dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
		dispatcher.forward(request, response);
	}

	public void addTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		session = request.getSession();
		serviceDB = new ToDoDBService();
		String name, priority, date;
		List<Task> taskList = (List<Task>) serviceDB.loadListDB();
		if (taskList == null)
			taskList = new ArrayList<>();
		request.getServletContext().setAttribute("taskList", taskList);
		// session.setAttribute("taskList", taskList);
		name = request.getParameter("name");
		priority = request.getParameter("priority");
		date = request.getParameter("date");
		Task task = new Task(name, priority, date);

		if (serviceDB.isProper(task)) {
			try {
				if (serviceDB.saveListDB(task)) {
					request.getServletContext().setAttribute("taskList", taskList);// set new list
					// session.setAttribute("taskList", taskList);
					dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
					dispatcher.forward(request, response);
				} else {
					request.getServletContext().setAttribute("taskList", taskList);// set old list
					request.setAttribute("error", "error");// send error indicator
					// session.setAttribute("taskList", taskList);
					dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
					dispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String taskName = request.getParameter("name");
		serviceDB = new ToDoDBService();

		try {
			serviceDB.delete(taskName);
			List<Task> taskList = serviceDB.loadListDB();
			request.getServletContext().setAttribute("taskList", taskList);
			// session.setAttribute("taskList", taskList);
			dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void updateTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String old_taskName = request.getParameter("old_taskname"); //Old task name
		String taskName = request.getParameter("name"); //new modified name
		System.out.println("new name: " + taskName);
		String priority = request.getParameter("priority");//modified priority
		String date = request.getParameter("date");//modified date
		System.out.println("new Date: " + date);
		
		Task task = new Task(taskName, date, priority);
		serviceDB = new ToDoDBService();

		try {
			serviceDB.update(task, old_taskName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		List<Task> taskList = serviceDB.loadListDB();
		request.getServletContext().setAttribute("taskList", taskList);
		// session.setAttribute("taskList", taskList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ToDoHomepage.jsp");
		dispatcher.forward(request, response);

	}

}
