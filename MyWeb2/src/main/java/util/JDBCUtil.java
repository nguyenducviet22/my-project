package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection cont = null;
//		com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();inserted into line #14
		try {
			// register the JDBC driver with DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//
			String url = "jdbc:mySQL://localhost:3306/mywebsite";
			String username = "root";
			String password = "";
			// create connection
			cont = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cont;
	}

	public static void closeConnection(Connection cont) {
		try {
			if (cont != null) {
				cont.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection cont) {
		try {
			if (cont != null) {
				DatabaseMetaData mtdt = cont.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	test connection with database
	public static void main(String[] args) {
		try {
			System.out.println(new JDBCUtil().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}