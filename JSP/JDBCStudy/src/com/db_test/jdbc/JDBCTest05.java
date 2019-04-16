package com.db_test.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest05 {

	public static void main(String[] args) throws IOException, SQLException {

		//-------------从控制台获取用户输入的用户名和密码
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("欢迎登录动力节点，请输入用户名和密码！");
		System.out.println("请输入用户名：");
		String username = br.readLine();
		System.out.println("请输入密码：");
		String pwd = br.readLine();
		
		//-------------从配置文件获取信息-------
		FileReader file = new FileReader("conf/userServer.properties");
		Properties pro = new Properties();
		pro.load(file);
		file.close();
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		//-------------------连接数据库------------
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    boolean flag = false;
	    try {
	    	//注册驱动
			Class.forName(driver);
			//获取数据库连接
			conn = DriverManager.getConnection(url, user, password);
			//获取数据库操作对象
			stmt = conn.createStatement();
			//定义sql语句框架
			//String sql = "select username from user where username = ? and password = ?";
			//预编译
			//ps = conn.prepareStatement(sql);
			//对sql语句进行赋值
			//ps.setString(1, username);
			//ps.setString(2, pwd);
			//执行sql语句
			//rs=ps.executeQuery(sql);
			//if(rs.next()) {
			//	flag=true;
			//}
			//sql语句
			String sql = "select username from user where username='"+username+"'and password='"+pwd+"' ";
			rs = stmt.executeQuery(sql);
			//处理查询结果集
			if(rs.next()) {
				flag=true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
			conn.close();
			}
		}
		
	
	if(flag) {
		System.out.println("登陆成功！");
	}else {
		System.out.println("sorry,您输入的用户名或密码有误，请重新输入！");
	}
	
	}
}
