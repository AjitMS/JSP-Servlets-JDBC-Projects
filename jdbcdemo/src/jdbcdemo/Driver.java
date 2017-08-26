package jdbcdemo;

import java.sql.*;

public class Driver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		// 1. Get connection to database
		try (Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root",
				"root")) {

			// 2. Create Statement
			Statement myStmt = myConn.createStatement();

			// 3. Execute Query
			ResultSet myRs = myStmt.executeQuery("select * from employees");

			// 4. Process result Set
			while (myRs.next()) {
				System.out.println(myRs.getString("first_name") + ", " + myRs.getString("last_name") + ", "
						+ myRs.getString("email"));

			}

		}

	}

}
