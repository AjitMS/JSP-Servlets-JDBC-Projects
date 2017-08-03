package com.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();// we specified in form method = POST so,
		out.println("Hello, " + username + " from GET Method");// Its okay not to be changed/modified similar to POST
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");

		PrintWriter out = response.getWriter();
		out.println(
				"Hello, " + username + " from POST Method" + " We also know your full name is " + fullname + " Right?");
		//String location = request.getParameter("location");
		String[] location = request.getParameterValues("location");
		out.println("You've been at "+location.length+" places given below !");
		for(int i = 0; i< location.length; i++)
		out.println(location[i]);
	}
}
