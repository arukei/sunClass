package kr.co.mybatis.DbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class DbConnection {
	
	public Connection DbConnect() throws ClassNotFoundException, SQLException {
		
	
	String id = "root";
	String password = "";//localhost:3306/test?
	String url = "jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true& useUnicode=true&characterEncoding=utf-8";
	
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection(url, id, password);
	
	return conn;
	}

}
