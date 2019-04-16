package com.db_test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest06 {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Statement  stmt = null;
		//PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取数据库连接
			String url = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "admin";
			conn = DriverManager.getConnection(url, user, password);
			//获取数据库操作对象，关闭自动提交，开启事物	
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			//定义sql语句，事物只能用于DML语句；
			String sql = "delete from user where username = 'lisi'";
		    int count = stmt.executeUpdate(sql);	
		    System.out.println(count);
		    //提交事务
		    conn.commit();
		} catch (Exception e) {

			e.printStackTrace();
		    conn.rollback();
		}finally {
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
	}

}
