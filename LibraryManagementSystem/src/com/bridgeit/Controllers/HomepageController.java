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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgeit.DAO.DBBookService;
import com.bridgeit.DTO.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class HomepageController
 */
@WebServlet("/HomepageController")
public class HomepageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomepageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	static Logger logger = LoggerFactory.getLogger(HomepageController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String command = request.getParameter("command");
		System.out.println("Testing id as: " + id);
		System.out.println("commmand is: " + command);
		try {
			switch (command) {

			case "showList":
				showList(request, response);
				break;

			case "addBook":
				addBook(request, response);
				break;

			case "updateBook":
				updateBook(request, response);
				break;

			case "deleteBook":
				deleteBook(request, response);
				break;

			case "showBook":
				showBook(request, response);
				break;

			default:
				showList(request, response);
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static DBBookService bookService;
	static HttpSession session = null;
	static String category;

	public static void showList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException {

		Gson gson = null;
		String id = request.getParameter("id");
		session = request.getSession();
		String email = (String) session.getAttribute("email");
		logger.info("GOT THE ID AS: " + id);
		String category = request.getParameter("category");
		if (category == null) {
			category = (String) session.getAttribute("category");
		}
		category = category.toLowerCase();
		System.out.println("Get Category: " + category);
		logger.info("reached after caetgory");
		// httpSession.setAttribute("email", email);
		logger.info("reached after httpsesion");
		bookService = new DBBookService();
		logger.info("reached after boodservice");

		if (session != null) {
			System.out.println("Inside Session");
			// User user = (User) httpSession.getAttribute("user");
			// email = user.getEmail();
			List<Book> bookList = new ArrayList<>();
			logger.info("retrieving data...");
			bookList = bookService.getBooksByEmail(email, category);
			logger.info("Got data!");

			gson = new GsonBuilder().disableHtmlEscaping().create();
			JsonElement element = gson.toJsonTree(bookList, new TypeToken<List<Book>>() {
			}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);// print meaning
			logger.info("array is {} ", jsonArray);
			logger.info("Completed !");

		}

	}

	public static void addBook(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		// String bookName = request.getParameter("bookname");
		// String category = request.getParameter("category");
		// String author = request.getParameter("author"); //not working all of above

		session = request.getSession(true);
		String dataString = request.getParameter("dataString");
		// space is denoted as %20 in dataString from AJAX Call
		dataString = dataString.replaceAll("\\%20", " ");
		// two parameters are joined using & symbol
		String[] token = dataString.split("\\&");
		String bookName = null;
		String bookAuthor = null;
		String bookCategory = null;
		String bookDescription = null;

		for (String i : token) {
			String[] token1 = i.split("\\=");
			if (token1[0].equalsIgnoreCase("bookname"))
				bookName = token1[1];

			if (token1[0].equalsIgnoreCase("bookauthor"))
				bookAuthor = token1[1];

			if (token1[0].equalsIgnoreCase("bookCategory"))
				bookCategory = token1[1];

			if (token1[0].equalsIgnoreCase("bookDescription"))
				bookDescription = token1[1];
		}

		Book book = new Book(bookName, bookAuthor, bookCategory, bookDescription);
		// Gson gson = null;

		System.out.println("BookString: " + dataString);
		System.out.println("Book Name: " + book.getBookName());
		System.out.println("Book Details: " + book.getBookCategory() + " " + book.getBookAuthor() + " "
				+ book.getBookDescription());
		String testid = request.getParameter("id");
		session.setAttribute("category", book.getBookCategory());
		System.out.println("Set Category: " + book.getBookCategory());
		String email = (String) session.getAttribute("email");
		System.out.println("Email is: " + email);
		logger.info("GOT THE ID AS: " + testid);
		logger.info("reached after caetgory");
		// httpSession.setAttribute("email", email);
		logger.info("reached after httpsesion");
		bookService = new DBBookService();
		logger.info("reached after boodservice");

		if (session != null) {
			if (!(bookService.bookExists(email, book))) {
				bookService.addBook(email, book);

				System.out.println("Inside Session");
				response.setContentType("text/plain");
				response.getWriter().print("success adding book");// print meaning
				// User user = (User) httpSession.getAttribute("user");
				// email = user.getEmail();
				/*
				 * List<Book> bookList = new ArrayList<>(); logger.info("retrieving data...");
				 * bookList = bookService.getBooksByEmail(email, book.getBookCategory());
				 * logger.info("Got data!");
				 * 
				 * gson = new GsonBuilder().disableHtmlEscaping().create(); JsonElement element
				 * = gson.toJsonTree(bookList, new TypeToken<List<Book>>() { }.getType());
				 * JsonArray jsonArray = element.getAsJsonArray();
				 * response.setContentType("application/json");
				 * response.getWriter().print(jsonArray);// print meaning
				 * logger.info("array is {} ", jsonArray);
				 */

				logger.info("Completed !");
			} else {
				response.getWriter().print("failure adding book");
				return;
			}

		}
	}

	public static void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {

		session = request.getSession(true);
		Book book = new Book(request.getParameter("bookname"), request.getParameter("bookauthor"),
				request.getParameter("bookcategory"), request.getParameter("bookdescription"));
		// Gson gson = null;
		String testid = request.getParameter("id");
		String email = (String) session.getAttribute("email");
		logger.info("GOT THE ID AS: " + testid);
		// String category = request.getParameter("category").toLowerCase();
		logger.info("reached after caetgory");
		// httpSession.setAttribute("email", email);
		logger.info("reached after httpsesion");
		bookService = new DBBookService();
		logger.info("reached after boodservice");

		if (session != null) {
			if ((bookService.bookExists(email, book))) {
				bookService.deleteBook(email, book);

				System.out.println("Inside Session");
				// User user = (User) httpSession.getAttribute("user");
				// email = user.getEmail();
				/*
				 * List<Book> bookList = new ArrayList<>(); logger.info("retrieving data...");
				 * bookList = bookService.getBooksByEmail(email, category);
				 * logger.info("Got data!");
				 * 
				 * gson = new GsonBuilder().disableHtmlEscaping().create(); JsonElement element
				 * = gson.toJsonTree(bookList, new TypeToken<List<Book>>() { }.getType());
				 * JsonArray jsonArray = element.getAsJsonArray();
				 */
				response.setContentType("text/plain");
				response.getWriter().print("success deleting book");// print meaning
				// logger.info("array is {} ", jsonArray);
				logger.info("Completed !");

			} else {
				response.getWriter().print("success deleting book");
				return;
			}
		}

	}

	public static void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {

		session = request.getSession(true);
		Book book = new Book(request.getParameter("bookname"), request.getParameter("bookauthor"),
				request.getParameter("bookcategory"), request.getParameter("bookdescription"));
		// Gson gson = null;
		String testid = request.getParameter("id");
		String oldBookName = request.getParameter("oldbookname");
		String email = (String) session.getAttribute("email");
		logger.info("GOT THE ID AS: " + testid);
		// String category = request.getParameter("category").toLowerCase();
		logger.info("reached after caetgory");
		// httpSession.setAttribute("email", email);
		logger.info("reached after httpsesion");
		bookService = new DBBookService();
		logger.info("reached after boodservice");

		if (session != null) {
			if ((bookService.bookExists(email, book))) {
				bookService.updateBook(email, book, oldBookName);

				System.out.println("Inside Session");
				// User user = (User) httpSession.getAttribute("user");
				// email = user.getEmail();
				/*
				 * List<Book> bookList = new ArrayList<>(); logger.info("retrieving data...");
				 * bookList = bookService.getBooksByEmail(email, category);
				 * logger.info("Got data!");
				 * 
				 * gson = new GsonBuilder().disableHtmlEscaping().create(); JsonElement element
				 * = gson.toJsonTree(bookList, new TypeToken<List<Book>>() { }.getType());
				 * JsonArray jsonArray = element.getAsJsonArray();
				 */
				response.setContentType("text/plain");
				response.getWriter().print("update success");// print meaning
				// logger.info("array is {} ", jsonArray);
				logger.info("Completed !");
			}
		}
	}

	public static void showBook(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {

		String bookname = request.getParameter("bookname");
		String email = request.getParameter("email");
		Book book = bookService.getBook(bookname, email);
		List<String> bookDetails = new ArrayList<String>();
		bookDetails.add(book.getBookName());
		bookDetails.add(book.getBookAuthor());
		bookDetails.add(book.getBookCategory());
		bookDetails.add(book.getBookDescription());
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		JsonElement element = gson.toJsonTree(bookDetails, new TypeToken<List<String>>() {
		}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

}