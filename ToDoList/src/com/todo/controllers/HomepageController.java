package com.todo.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.model.Task;
import com.todo.service.HomepageService;

@WebServlet("/HomepageController")
public class HomepageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomepageController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	List<Task> taskList;
	HttpSession session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();

		HomepageService service = new HomepageService();
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
		case "show":
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
			System.out.println("Reached out of switch");
			service.loadList(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
