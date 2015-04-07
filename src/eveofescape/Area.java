package eveofescape;

import java.awt.List;
import java.sql.*;

public class Area {
	private int id;
	private String name, n_range;

	public static String areaCmd(String command) {
		
		String cmd, vars = null;
		if (command.indexOf(' ') > -1) { // Check if there is more than one word.
		  int i = command.indexOf(' ');
		  cmd = command.substring(0, i); // Extract first word.
		  vars = command.substring(i); 
	    } else {
	      cmd = command.toString(); // Text is the first word itself.
	    }
		
		System.out.println("Got command " + cmd + " from vars: " + vars);
		
		switch (cmd) {
		case "list": return listAreas();
		case "create": return createArea(vars);
		
		}

		return null;
	}

	private static String createArea(String vars) {
		Connection conn = loadConnection();
		String result;
		String[] arr = vars.trim().split(" ");
		System.out.println("create Area Initiated with vars: " + vars);
		
		int i = 0;
		while ( i < arr.length){
			System.out.println(i + ": "+ arr[i].toString());
			i++;
		}
		System.out.println(arr);
		
		if (arr.length == 3) {
			try {
				Statement sta = conn.createStatement();
				int res = sta.executeUpdate("INSERT into area (name, range_start, range_end) VALUES ('"+ arr[0] + "'," + arr[1] + "," + arr[2] + ")");
				return "Area " + arr[0] + " created.";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return e.toString();
			}
		} else {
			
			return "SYNTAX ERROR. Usage: area create [name] [start_id] [end_id]";
		}
	}

	private static String listAreas() {
		Connection conn = loadConnection();
		String result;
		try {
			//Get the lkist of current areas
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("SELECT * FROM area");
			result = "Current Areas: \nID\t|\tName\t\t|\tRange \n";
			while (res.next()) {
				result += res.getInt("ID") + "\t\t" + res.getString("name") + "\t\t" + res.getString("range_start") + " - " + res.getString("range_end");	
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}
		return result;
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

	
	public static Connection loadConnection ( ) {
		String dbURL = "jdbc:derby:data/";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
