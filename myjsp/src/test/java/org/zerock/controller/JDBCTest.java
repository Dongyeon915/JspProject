package org.zerock.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
    static {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
@Test
    public void testConnection() {

	try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsp", "dong", "1234")) {
	    log.info(con);
	} catch (Exception e) {
	    e.printStackTrace();
	};
    }
}
