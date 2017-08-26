package jdbcdemo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//there must be table filetable in database demo
public class FileJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");

		// insert file into db
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root");
		// PreparedStatement ps = con.prepareStatement("insert into filetable values
		// (?,?)");
		// File f = new File("resources/sender.txt");
		// FileReader fr = new FileReader(f);
		// ps.setInt(1, 101);
		// ps.setCharacterStream(2, fr, (int) f.length());
		// int result = ps.executeUpdate();
		// System.out.println("Updated total "+result+" entries");

		// retrieve file from db and save on desktop
		PreparedStatement pstmt = con.prepareStatement("Select * from filetable");
		ResultSet rs = pstmt.executeQuery();
		rs.next();// now on 1st row
		Clob c = rs.getClob(2);
		Reader r = c.getCharacterStream();
		FileWriter fw = new FileWriter("resources/receiver.json");
		int i;
		while ((i = r.read()) != -1) {
			fw.write((char) i);
		}
		fw.close();
		con.close();
		System.out.println("OK !");

	}

}
