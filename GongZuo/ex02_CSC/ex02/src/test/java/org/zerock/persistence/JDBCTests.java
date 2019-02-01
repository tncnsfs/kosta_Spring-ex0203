package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	// Class 와 JDBC 가 정상적으로 연결 가능 여부를 테스트 하기 
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	@Test
	public void testConnection() {
		
		try {
			DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", 
					"kosta192", 
					"1234");
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
