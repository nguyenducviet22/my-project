package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/fashion_website";
			String username = "root";
			String password = "";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//test connection with database
	public static void main(String[] args) {
		try {
			System.out.println(new JDBCUtil().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
