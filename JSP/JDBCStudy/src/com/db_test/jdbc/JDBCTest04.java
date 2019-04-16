package com.db_test.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest04 {

	public static void main(String[] args) throws IOException, SQLException {

		//----------从控制台获取用户输入的信息--------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("欢迎注册动力节点");
		System.out.println("请输入用户名和密码进行注册");
		System.out.println("请输入用户名");
		String username = br.readLine();
		System.out.println("请输入密码");
		String pwd = br.readLine();
		//--------------------------------------------------------
		//通过file获取配置文件
		FileReader fileReader = new FileReader("conf/userServer.properties");
		//创建属性对象
		Properties pro = new Properties();
		//通过pro对象的load方法将读取到的配置文件的信息加载到内存中生成一个map集合；
		pro.load(fileReader);
		//关闭流
		fileReader.close();
		
		
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		
	    Connection conn = null;
	    Statement stmt = null;
	    int count = 0;
	    try {
	    	//注册驱动
			Class.forName(driver);
			//获取数据库连接
			conn = DriverManager.getConnection(url, user, password);
			//获取数据库操作对象
			stmt = conn.createStatement();
			//执行SQL语句
			String sql = "insert into user(username,password) value('"+username+"','"+pwd+"')";
			count = stmt.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
				stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				};
			}
			if(conn!=null) {
				try {
				conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	    if(count==1) {
	    	System.out.println("恭喜您注册成功！");
	    }
	    else {
	    	System.out.println("sorry,注册失败！");
	    }
	}

}
