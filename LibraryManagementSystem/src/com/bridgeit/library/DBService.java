package com.bridgeit.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBService {

	DBConnection con = new DBConnection();
	Connection connection;

	public boolean authenticateUser(String email, String password) throws ClassNotFoundException, SQLException {

		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "select * from appuser";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Executing...");
		while (rs.next()) {
			System.out.println("iterating...");
			if (rs.getString(1).equals(email))
				if (rs.getString(2).equals(password))
					return true;
		}
		return false;
	}

	public void basicValidation() throws ClassNotFoundException, SQLException {
		
		
		
		
//		connection = con.getConnection();
//		System.out.println("Got connection...");
//		String sql = "select * from ";
//		PreparedStatement pstmt = connection.prepareStatement(sql);
	}
	
	public void addUser(User user) throws ClassNotFoundException, SQLException {

		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "insert into userlist values (?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getFullname());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getGender());
		pstmt.executeQuery();
	}

	public boolean alreadyRegistered(User user) throws ClassNotFoundException, SQLException {
		String email = user.getEmail();
		String phone = user.getPhone();
		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "select * from userlist";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			if (email.equalsIgnoreCase(rs.getString(2)) || phone.equals(rs.getString(4))) {
				return true;
			}
		return true;
	}
}