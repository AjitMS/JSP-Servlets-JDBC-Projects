package jdbcdemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageJdbc {
//there must be a table imagetable in database demo
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		// setting image into db. BLOB(64KB)
		// must use LONGBLOB(4GB) OR MEDIUMBLOB(64MB) for large images.

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");
		// PreparedStatement pstmt = con.prepareStatement("insert into imgtable
		// values(?,?)");
		// pstmt.setString(1, "tyrion");
		// FileInputStream fin = new
		// FileInputStream("resources/Tyrion-Lannister-Quotes-12.jpg");
		// pstmt.setBinaryStream(2, fin, fin.available());//column no.2
		// int affected = pstmt.executeUpdate();
		// System.out.println("Rows Affected " + affected);

		// getting image from db to desktop in name of robert_baratheon.jpg
		PreparedStatement ps = con.prepareStatement("select * from imgtable");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Blob b = rs.getBlob(2); // get blob from column 2
			byte barr[] = b.getBytes(1, (int) b.length());
			FileOutputStream fout = new FileOutputStream("/home/bridgelabz3/Desktop/robert_baratheon.jpg");
			fout.write(barr);
			fout.close();
		}

		System.out.println("OK !");
	}

}
