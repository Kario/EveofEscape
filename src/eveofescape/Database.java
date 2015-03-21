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
				return "Database " + arr + " loaded";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return e.toString();
			}
		} else {
			return "SYNTAX ERROR. \nUSAGE: loaddb [database]";
		}
	}

}
