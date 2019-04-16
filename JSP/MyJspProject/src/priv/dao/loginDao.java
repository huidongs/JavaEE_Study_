package priv.dao;
import java.sql.*;

import priv.entity.Login;

public class loginDao {

	public int login(Login login){
		 String URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String USER = "root";
		 String PWD = "admin";
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			//与数据库建立连接
			conn = DriverManager.getConnection(URL, USER, PWD);
			//发送sql。执行增删改，查	
			String sql = "select count(*) from user where username=? and password=?";
			pstmt = conn.prepareStatement(sql);//预编译
			pstmt.setString(1,login.getName());
			pstmt.setString(2,login.getPwd());
			rs = pstmt.executeQuery();
			//是否操作成功判断
			int count = -1;		
			if(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		
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
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();    
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
