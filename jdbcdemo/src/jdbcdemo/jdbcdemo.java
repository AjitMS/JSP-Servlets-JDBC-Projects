package jdbcdemo;

import java.sql.*;

public class jdbcdemo {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String sql = "Select * from employees";
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		DatabaseMetaData dbmd = con.getMetaData();

		// database metadata example
		String table[] = { "TABLE" };
		rs = dbmd.getTables(null, null, null, table);
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}

		// resultSet metadata example
		System.out.println("Total Columns: " + rsmd.getColumnCount() + " Table Name: " + rsmd.getTableName(1));
		System.out.println("Entries are \n ");
		System.out.println("UserName: " + dbmd.getUserName());

		// retrieval
		while (rs.next())
			System.out.println("Id: " + rs.getInt("id") + " firstName: " + rs.getString("first_name") + " lastName: "
					+ rs.getString("last_name"));
		
		
		
	}

}
