package com.bridgeit.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryDBService {

	DBConnection con = new DBConnection();
	Connection connection;
	
	public boolean authenticateUser(String email, String password) throws ClassNotFoundException, SQLException {
		
		connection = con.getConnection();
		System.out.println("Got connection...");
		String sql = "select * from users";
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

}
