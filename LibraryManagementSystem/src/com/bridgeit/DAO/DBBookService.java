package com.bridgeit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bridgeit.DTO.Book;

public class DBBookService {

	DBConnection con = new DBConnection();
	Connection connection;

	public ArrayList<Book> getBooksByEmail(String email, String category) throws ClassNotFoundException, SQLException {

		ArrayList<Book> bookList = new ArrayList<>();
		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "select * from userbooks where email=? and bookcategory=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, category);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Executing...");
		while (rs.next()) {
			Book book = new Book(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			bookList.add(book);
			System.out.println("BookList is: " + bookList);
		}
		return bookList;

	}

	public ArrayList<Book> getBooksById(String id, String category) throws ClassNotFoundException, SQLException {

		ArrayList<Book> bookList = new ArrayList<>();
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
