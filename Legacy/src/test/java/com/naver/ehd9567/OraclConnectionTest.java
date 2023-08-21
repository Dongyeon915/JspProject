package com.naver.ehd9567;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class OraclConnectionTest {

    static {
	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
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
	    connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
	    System.out.println(connection.toString());
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    assertNotNull(connection);
	}
    }
}
