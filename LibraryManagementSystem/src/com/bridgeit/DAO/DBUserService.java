package com.bridgeit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgeit.DTO.User;

/**
 * @author Ajit Shikalgar 
 * Implmentation of DBServiceInteface
 */
public class DBUserService implements DBUserServiceInterface {

	DBConnection con = new DBConnection();
	Connection connection;

	/**
	 * @param email
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *             in order to authenticate a user, compare his.her email password
	 *             if it exists in DB if useremail and password is proper, return
	 *             true otherwise false
	 * 
	 */
	public boolean authenticateUser(String email, String password) throws ClassNotFoundException, SQLException {

		connection = con.getConnection();
		System.out.println("Got connection...");
		System.out.println("Autnehticating");
		String sql = "select * from appuser";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Executing...");
		while (rs.next()) {
			System.out.println("iterating...");
			if (rs.getString(2).equals(email))
				if (rs.getString(3).equals(password))
					return true;
		}
		return false;
	}

	public User getUserObject(String getEmail) throws SQLException, ClassNotFoundException {
		connection = con.getConnection();
		String fullname, email, phone, password, gender;
		System.out.println("Got connection...");
		String sql = "select * from userlist";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		System.out.println("Executing...");
		User user = null;
		while (rs.next()) {
			System.out.println("iterating...");
			if (getEmail.equalsIgnoreCase(rs.getString(2))) {
				email = rs.getString(2);
				fullname = rs.getString(3);
				phone = rs.getString(4);
				password = rs.getString(5);
				gender = rs.getString(6);
				user = new User(email, fullname, phone, password, gender);
			}
		}
		return user;
	}

	
	
	/**
	 * @param user
	 * @param conf_password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *             Set of validations needed to be carried out in order to validate
	 *             user credentials. if proper credentials, then register user else
	 *             notify user.
	 */
	public String basicValidation(User user, String conf_password) throws ClassNotFoundException, SQLException {
		String errorString = "Error/s: ";

		if (user.getPhone().length() != 0) {
			if (user.getPhone().length() != 10)
				errorString = errorString.concat(" invalidphone ");
		} else {
			errorString = errorString.concat(" emptyphone ");
		}

		if (!(user.getPassword().equals(conf_password)))
			errorString = errorString.concat(" passwordunmatch ");

		if (user.getFullname().length() == 0)
			errorString = errorString.concat(" fullnameempty ");

		if (user.getEmail().length() == 0)
			errorString = errorString.concat(" emailempty ");

		if (user.getGender().length() == 0)
			errorString = errorString.concat(" genderempty ");

		if (user.getPassword().length() == 0)
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

		System.out.println("error is in " + errorString);
		return errorString;
	}

	/**
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *             registers user into database only if basic validation and already
	 *             registered functions are cleared inserts user data into 2 tables
	 *             names userlist(registration table) and appuser(login table)
	 */
	public void registerUser(User user) throws ClassNotFoundException, SQLException {
		connection = con.getConnection();
		System.out.println("Got connection...");

		// adding into appuser table
		String intoLoginlist = "insert into appuser(email, password) values (?, ?)";
		PreparedStatement pstmt1 = connection.prepareStatement(intoLoginlist);
		pstmt1.setString(1, user.getEmail());
		pstmt1.setString(2, user.getPassword());
		pstmt1.executeUpdate();
		System.out.println("added in appuser table !!");

		// since appuser uid is autoincremented
		// getting last id values so as to reflect same back to userlist table
		String sql = "select * from appuser";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int last = 0;
		if (rs.absolute(-1)) {
			last = rs.getInt(1);
		}
		String intoUserList = "insert into userlist values (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(intoUserList);
		pstmt.setInt(1, last);// let the id of both table be same.
		System.out.println("last is " + last);
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getFullname());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getGender());
		pstmt.setString(6, user.getPassword());
		pstmt.executeUpdate();
		System.out.println("added in userlist table !!");
	}

	/**
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLExcepton
	 *             returns true if user already exists
	 */
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

	/**
	 * @param errorString
	 * @return to see whether the string contains concatenated errors.
	 */
	public boolean noErrorExists(String errorString) {
		if (errorString.equals("Error/s: "))
			return true;
		return false;
	}
}