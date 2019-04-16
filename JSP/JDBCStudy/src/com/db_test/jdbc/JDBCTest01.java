package com.db_test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCTest01 {

	public static void main(String[] args) {
		Connection  conn =null;
		ResultSet rs = null;
		Statement stmt =null;
		try {
			//1.注册驱动
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			//2.获取数据库连接
			String url = "jdbc:mysql://localhost:3306/db_test";
			String user = "root";
			String password = "admin";
			conn =  DriverManager.getConnection(url, user, password);
			//3.获取数据库操作对象
		    stmt = conn.createStatement();
		    //4.执行SQL语句
		    //4.1 DQL语句->第五步：处理查询结果集；
		    //4.2 DML语句   没有第五步；
		    
		    String sql = "select CNAME from course";
		    rs = stmt.executeQuery(sql);
		    
		    //5.获取查询结果集
		    while(rs.next()){
		    	String CNAME = rs.getString("CNAME");
		    	System.out.println(CNAME);;
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt !=null ) {}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
