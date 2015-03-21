package eveofescape;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.jdbc.EmbeddedDriver;

public class Database {
	
	public static String loadDatabase (String arr)  {
		if (arr != null) {
			try {
				String dbURL = "jdbc:derby:data/" + arr + ";create=true";
				Connection conn = DriverManager.getConnection(dbURL);
				conn.close();
				return "Database " + arr + " loaded";
			} catch (SQLException e) {
				e.printStackTrace();
				return e.toString();
			}
		} else {
			return "SYNTAX ERROR. \nUSAGE: loaddb [database]";
		}
	}
	
	public static Connection loadConnection (String args ) {
		String dbURL = "jdbc:derby:data/" + args + ";create=true";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			conn.close();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
