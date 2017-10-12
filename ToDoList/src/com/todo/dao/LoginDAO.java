package com.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todo.model.Task;


public class LoginDAO {

	public boolean isProper(Task task) {
		if (task.getName().isEmpty() || task.getDate().isEmpty() || task.getPriority().isEmpty())
			return false;
		return true;
	}

	public boolean authenticateUser(String email, String password) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");
		String sql = "select * from ToDoLoginPairs";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			if (email.equalsIgnoreCase(rs.getString(1)))
				if (password.equalsIgnoreCase(rs.getString(2)))
					return true;
		}
		con.close();
		return false;
	}
}
