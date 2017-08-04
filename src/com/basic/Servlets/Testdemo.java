package com.basic.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet("/testpath")
public class Testdemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter writer = response.getWriter();
		List<String> itemlist=null;
		String item = request.getParameter("list");
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(20*60);
		
		if (itemlist == null)

			itemlist = new ArrayList<String>();

	
		if (itemlist.contains(item)) {
			writer.println(item + " Already Exists !");
		}
		
		else {
			itemlist.add(item);

			writer.println("Added: " + item);
		}
		
		

		

	}

	}

