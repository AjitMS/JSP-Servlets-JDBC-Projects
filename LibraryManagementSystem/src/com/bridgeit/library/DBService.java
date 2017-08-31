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

	@SuppressWarnings("null")
	public String basicValidation(User user, String conf_password) throws ClassNotFoundException, SQLException {
		String errorString = "Error/s: ";

		if (!(user.getPassword().equals(conf_password)))
			errorString = errorString.concat(" passwordunmatch ");

		if (user.getFullname() == null)
			errorString = errorString.concat(" fullnameempty ");

		if (user.getEmail() == null)
			errorString = errorString.concat(" emailempty ");

		if (user.getGender() == null)
			errorString = errorString.concat(" genderempty ");

		if (user.getPassword() == null)
			errorString = errorString.concat(" passwordempty ");
		if (conf_password == null)
			errorString = errorString.concat(" confpasswordempty ");

		if (user.getFullname().matches(".*\\d.*"))
			errorString = errorString.concat(" fullnamedigit ");

		if (user.getPhone().matches(".*\\D.*"))
			errorString = errorString.concat(" phonechar ");

		if (user.getPassword().length() < 4)
			errorString = errorString.concat(" passwordshort ");
	

		System.out.println("username: " + user.getFullname() + " phone: " + user.getPhone() + " password: "
				+ user.getPassword() + " conf_password: " + conf_password + " gender: " + user.getGender());
		System.out.println("some sysntax incorrect !!");

		System.out.println("error is in "+errorString);
		return errorString;
	}

	public void addUser(User user) throws ClassNotFoundException, SQLException {

		connection = con.getConnection();
		System.out.println("Got connection...");

		String intoLoginlist = "insert into appuser(email, password) values (?, ?)";
		PreparedStatement pstmt1 = connection.prepareStatement(intoLoginlist);
		pstmt1.setString(1, user.getEmail());
		pstmt1.setString(2, user.getPassword());
		pstmt1.executeUpdate();
		System.out.println("added in appuser table !!");

		String sql = "select * from appuser";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int last = 0;
		if (rs.absolute(-1)) {
			last = rs.getInt(1);
		}

		String intoUserList = "insert into userlist values (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(intoUserList);

		pstmt.setInt(1, last);
		System.out.println("last is " + last);
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getFullname());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getGender());
		pstmt.setString(6, user.getPassword());
		pstmt.executeUpdate();
		System.out.println("added in userlist table !!");

	}

	public boolean alreadyRegistered(User user) throws ClassNotFoundException, SQLException {

		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "select * from userlist";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			if (user.getEmail().equalsIgnoreCase(rs.getString(2)) || user.getPhone().equals(rs.getString(4))) {
				return true;
			}
		return false;
	}
}