package com.db_test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCTest02 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		//DriverManager 
		try {
	         //注册驱动
			/*Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);*/
			//通过java的反射机制注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//获取数据库来连接
			String url = "jdbc:mysql://localhost:3306/db_test?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "admin";
			conn =DriverManager.getConnection(url, user, password);
			
			//获取数据库操作对象
			stmt = conn.createStatement();
			//sql语句
			String sql = "select CNAME from course";
			 rs = stmt.executeQuery(sql);
			
		   //获取数据集
			while(rs.next()) {
				String CNAME = rs.getString("CNAME");
				System.out.println(CNAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{    //关闭资源
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
}
	


class RegisterDriver{
		
	static{
		Driver driver;
		try {
			driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}


