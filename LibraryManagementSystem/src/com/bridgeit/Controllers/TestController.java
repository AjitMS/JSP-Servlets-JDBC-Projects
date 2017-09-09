package com.bridgeit.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.DAO.DBBookService;
import com.bridgeit.DTO.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = null;
		String id = request.getParameter("id");
		System.out.println("GOT THE ID AS: "+id);
//		/String category = request.getParameter("category").toLowerCase();
		System.out.println("reached after caetgory");
		HttpSession httpSession = request.getSession();
		System.out.println("reached after httpsesion");
		DBBookService bookService = new DBBookService();
		System.out.println("reached after boodservice");
		//String email = null;

		if (httpSession != null) {
			System.out.println("Inside Session");
			//User user = (User) httpSession.getAttribute("user");
			//email = user.getEmail();
			List<Book> bookList = new ArrayList<>();
			try {
				System.out.println("before data");
				bookList = bookService.getBooksById("2", "Science");
				System.out.println("after data");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gson = new GsonBuilder().disableHtmlEscaping().create();
			JsonElement element = gson.toJsonTree(bookList, new TypeToken<List<Book>>() {
			}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);// print meaning
			System.out.println("array is: "+jsonArray);	
			System.out.println("Completed !");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
