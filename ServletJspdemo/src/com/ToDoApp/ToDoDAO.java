package com.ToDoApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author Ajit Shikalgar
 *
 */
public class ToDoDAO {
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

	/**
	 * @param task
	 * @return
	 */
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

	public static boolean isDuplicate(Task task) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");
		String sql = "select * from ToDoDB";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			if (task.getName().equalsIgnoreCase(rs.getString(1)))
				return true;
		}
		con.close();
		return false;
	}

	public boolean saveListDB(Task task) throws ClassNotFoundException, SQLException {

		if (!(isDuplicate(task))) {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root",
					"root");

			PreparedStatement pstmt = con.prepareStatement("insert into ToDoDB values(?,?,?)");
			pstmt.setString(1, task.getName());
			pstmt.setString(2, task.getPriority());
			pstmt.setString(3, task.getDate());
			int upd = pstmt.executeUpdate();
			System.out.println("Successfully updated " + upd + " entries !");
			con.close();

			return true;
		}
		return false;
	}

	public List<Task> loadListDB() throws ClassNotFoundException, SQLException {
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
		con.close();
		return taskList;
	}

	public void update(Task task, String taskName) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root",
				"root");
		System.out.println("Connection Opened !!!");
		PreparedStatement pstmt = con.prepareStatement("update ToDoDB set name=?, date=?, priority=? where name=?");
		pstmt.setString(1, task.getName());
		System.out.println("updated name: "+task.getName());
		pstmt.setString(2, task.getDate());
		System.out.println("updated date: "+task.getDate());
		pstmt.setString(3, task.getPriority());
		System.out.println();
		pstmt.setString(4, taskName);
		pstmt.executeUpdate();
		con.close();
	}

	public void delete(String taskName) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("delete from ToDoDB where name=?");
		pstmt.setString(1, taskName);
		pstmt.executeUpdate();
		con.close();
	}

	public Task getTask(String taskName) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("select * from ToDoDB where name=?");
		pstmt.setString(1, taskName);
		System.out.println("Found task: "+taskName);
		ResultSet rs = pstmt.executeQuery();
		Task task = null;
		while (rs.next()) {
			if (taskName.equals(rs.getString(1))) {
				String name = rs.getString(1);
				String date = rs.getString(2);
				String priority = rs.getString(3);
				
				task = new Task(name, date, priority);
				break;
			}
		}con.close();
		return task;
	}

}