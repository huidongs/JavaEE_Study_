package priv.huidong.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import priv.huidong.entity.Login;

//模型层，处理登录（查询数据）
public class LoginDao {
	private static final String URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PWD = "admin";
	public static int login(Login login) {
		PreparedStatement pstmt=null;
		Connection conn=null;
		ResultSet rs=null;	
		int count = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "select count(*) from user where username = ? and password = ?";
		    pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, login.getUname());
			pstmt.setString(2, login.getUpwd());
		    rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			if(count>0) {
				return 1;
			}else {
				return 0;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
