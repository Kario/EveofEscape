package eveofescape;

import java.awt.List;
import java.sql.*;

public class Area {
	private int id;
	private String name, n_range;

	public static List loadAreaList() throws SQLException {
		// Start the connection to the DB and set up the statement
		Connection con = Database.loadConnection("area");
		Statement stmt = (Statement) con.createStatement();
		
		//Get the data
		ResultSet res = stmt.executeQuery("SELECT * FROM areas");
		System.out.println("List of areas: "); 
	      while (res.next()) {
	         System.out.println(res.getString("Name"));
	      }
	      res.close();
	      stmt.close();
	      con.close();
		
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getN_range() {
		return n_range;
	}

	public void setN_range(String n_range) {
		this.n_range = n_range;
	}

	public int getId() {
		return id;
	}

}
