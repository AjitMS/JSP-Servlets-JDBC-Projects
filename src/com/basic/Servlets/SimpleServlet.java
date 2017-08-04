package com.basic.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(description = "A Simple servlet", urlPatterns = { "/SimpleServlet" },
initParams = {@WebInitParam (name="defaultuser", value="Ajit Shikalgar")})

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		String username = request.getParameter("name");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if (username != "" && username != null)// shouldn't be null
		{	session.setAttribute("SavedUserName", username);
			context.setAttribute("SavedUserName", username);
		}

		writer.println("Request Parameter has name " + username);
		writer.println("Session Parameter has name " + (String) session.getAttribute("SavedUserName"));
		writer.println("Context Parameter has name " + (String) context.getAttribute("SavedUserName"));
		//Session is used when single entry such as username is used multiple times again & again.
		//Session stores the common entry (username) by getAttribute() and can be used by setAttribute()
		writer.println("Init Parameter has name " +this.getServletConfig().getInitParameter("defaultuser"));
		
	}

}
