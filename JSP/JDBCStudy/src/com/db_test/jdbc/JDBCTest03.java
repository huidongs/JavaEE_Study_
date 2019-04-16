package com.db_test.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest03 {

	public static void main(String[] args) throws IOException, SQLException {

		//通过FileReader读取配置文件
		FileReader fileReader = new FileReader("conf/server.properties");
		//创建属性对象
		Properties pro = new Properties();
		//通过属性对象的load方法将配置文件的信息加载到内存中生成一个map集合
		pro.load(fileReader);
		//关闭流
		fileReader.close();
		
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		
		//------链接数据库--------
		Connection conn  = null;
		Statement stmt = null;
		ResultSet rs = null;
		//int count = 0;
	    try {
	    	//注册驱动
			Class.forName(driver);
			//链接数据库
			conn = DriverManager.getConnection(url, user, password);
			//获取数据库操作对象
			stmt = conn.createStatement();
			//DML,sql
			String sql = "select CNAME from course";
			//count= stmt.executeUpdate(sql_ins);
			rs = stmt.executeQuery(sql);
			//System.out.println(rs);
			while(rs.next()) {
				String CNAME  = rs.getString("CNAME");
				System.out.println(CNAME);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null)
			{
				conn.close();
			}
		}
		
	}

}
