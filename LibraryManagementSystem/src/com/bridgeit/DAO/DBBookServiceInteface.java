package com.bridgeit.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bridgeit.DTO.Book;

public interface DBBookServiceInteface {

	public ArrayList<Book> getBooksByEmail(String email, String category) throws ClassNotFoundException, SQLException;
	public void deleteBook(String email, Book book) throws SQLException, ClassNotFoundException;
	public void addBook(String email, Book book) throws SQLException, ClassNotFoundException;
	public void updateBook(String email, Book book, String oldBook) throws SQLException, ClassNotFoundException;


}
