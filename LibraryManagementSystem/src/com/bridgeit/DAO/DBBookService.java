package com.bridgeit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bridgeit.DTO.Book;

public class DBBookService implements DBBookServiceInteface {

	DBConnection con = new DBConnection();
	Connection connection;
	ArrayList<Book> bookList;

	public ArrayList<Book> getBooksByEmail(String email, String category) throws ClassNotFoundException, SQLException {

		bookList = new ArrayList<>();
		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "select * from userbooks where email=? and bookcategory=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, category);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Executing...");
		while (rs.next()) {
			Book book = new Book(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			bookList.add(book);
			System.out.println("BookList is: " + bookList);
		}
		return bookList;

	}

	public Book getBook(String bookName, String email) throws ClassNotFoundException, SQLException {

		connection = con.getConnection();
		Book book = null;
		System.out.println("Got connection...");
		String sql = "select * from userbooks where email=? and bookname=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, bookName);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Executing...");
		if (rs.next()) // obvious that resultSet has only one entry or none
			book = new Book(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		return book;

	}

	public void deleteBook(String email, Book book) throws SQLException, ClassNotFoundException {

		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "delete from userbooks where email=? and bookname=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, book.getBookName());
		pstmt.executeUpdate();
		return;
	}

	public boolean bookExists(String email, Book book) throws ClassNotFoundException, SQLException {

		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "select * from userbooks";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("resultset execute successfully !");
		while (rs.next()) {
			if (email.equalsIgnoreCase(rs.getString(2)) && book.getBookName().equalsIgnoreCase(rs.getString(3))
					&& book.getBookCategory().equalsIgnoreCase(rs.getString(5)))
				return true;
		}
		return false;
	}

	public void addBook(String email, Book book) throws SQLException, ClassNotFoundException {

		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "insert into userbooks(email, bookname, bookauthor, bookcategory, bookdescription) value(?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, book.getBookName());
		pstmt.setString(3, book.getBookAuthor());
		pstmt.setString(4, book.getBookCategory());
		pstmt.setString(5, book.getBookDescription());

		pstmt.executeUpdate();
		return;
	}

	public void updateBook(String email, Book book, String oldBook) throws SQLException, ClassNotFoundException {

		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "update userbooks set bookname=?, bookauthor=?, bookcategory=?, bookdescription=? where bookname=? and email=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getBookAuthor());
		pstmt.setString(3, book.getBookCategory());
		pstmt.setString(4, book.getBookDescription());
		pstmt.setString(5, oldBook);
		pstmt.setString(6, email);
		pstmt.executeUpdate();
		return;
	}

	public ArrayList<Book> getBooksById(String id, String category) throws ClassNotFoundException, SQLException {

		bookList = new ArrayList<>();
		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "select * from userbooks where uid=? and bookcategory=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, category);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Executing...");
		while (rs.next()) {
			Book book = new Book(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			bookList.add(book);
			System.out.println("BookList is: " + bookList);
		}
		return bookList;

	}

}
