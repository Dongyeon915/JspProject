package com.naver.ehd9567;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MySQLConnectionTest {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void connectionTest() {
		// JDBC - DB를 펀하게 관리하자!!!!
		// MYSLQ, ORACLE, MariaDB 상관없다!!
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://3.38.54.49:58973/mytodo", "ehd9567", "");
			System.out.println(connection.toString());	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			assertNotNull(connection);
		}
	}
}
