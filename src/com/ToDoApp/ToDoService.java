package com.ToDoApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToDoService {
	static Map<String, String> pairMap;

	// public ToDoService() throws ClassNotFoundException, SQLException {
	// Class.forName("com.mysql.jdbc.Driver");
	// Connection con =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false",
	// "root", "root");
	// String sql = "select * from ToDoLoginPairs";
	// PreparedStatement pstmt = con.prepareStatement(sql);
	// ResultSet rs = pstmt.executeQuery();
	// while (rs.next()) {
	//
	// if (pairMap == null)
	// pairMap = new HashMap<>();
	// pairMap.put(rs.getString(1), rs.getString(2));
	// System.out.println("Printing: "+rs.getString(1));
	// }
	// }

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
		return false;
	}

	public void toDatabase(Task task) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("insert into ToDoDB values(?,?,?)");
		pstmt.setString(1, task.getName());
		pstmt.setString(2, task.getPriority());
		pstmt.setString(3, task.getDate());
		int upd = pstmt.executeUpdate();
		System.out.println("Successfully updated " + upd + " entries !");

	}

	public List<Task> fromDatabase() throws ClassNotFoundException, SQLException {
		List<Task> taskList = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("select * from ToDoDB");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Task task = new Task(rs.getString(1), rs.getString(2), rs.getString(3));
			if (taskList.isEmpty())
				taskList = new ArrayList<>();
			taskList.add(task);
		}
		return taskList;
	}
}