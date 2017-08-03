package com.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> itemlist = null;
		String item = request.getParameter("list");
		if (itemlist.isEmpty())

			itemlist = new ArrayList<String>();

		else {
			itemlist.add(item);
		
		PrintWriter writer = response.getWriter();
		writer.println("Added: "+item);
		}
		
		
	}

}
