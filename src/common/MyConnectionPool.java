package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnectionPool {

	public static Connection getConnection() {// 드라이브 안에 있음, connection객체를 리턴함
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "edu", "1234");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public static boolean isConnection(Connection conn) {
		boolean valid = true;
		try {
			if (conn == null || conn.isClosed()) {
				valid = false;
				// 닫혔는가? 그럼 또 닫을 필요 없기 때문에 false
			}
		} catch (SQLException e) {
			valid = true;
		}
		return valid;
	}

	public static void close(Connection conn) {
		if (isConnection(conn)) { // true 라면
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void close(ResultSet rs) {
		try {

			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {

		}

	}

	public static void close(Statement stmt) {
		try {

			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {

		}

	}
	public static void commit (Connection conn) {
		if(isConnection(conn)) {
			try {
				conn.commit();
			}catch(SQLException e) {
				
			}
		}
	} // end of commit
	

	public static void rollback (Connection conn) {
		if(isConnection(conn)) {
			try {
				conn.rollback();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	} // end of rollback

	
	
}
