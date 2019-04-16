package priv.huidong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;

//import priv.huidong.entity.Student;

public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PWD = "admin";
	public static PreparedStatement pstmt=null;
	public static Connection conn=null;
	public static ResultSet rs=null;
	//获取连接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PWD);
	}
	//获取数据
	public static PreparedStatement getPrepareStatement(String sql,Object[] obj) throws SQLException, ClassNotFoundException {
		
		pstmt = getConnection().prepareStatement(sql);
		if(obj!=null) {
		for(int i=0;i<obj.length;i++) {
			pstmt.setObject(i+1, obj[i]);
		}
		}
		return pstmt;
	}
	//关闭连接
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
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
	//查询总数
	public static int getTotalCount(String sql) {
		int count=-1;
		try {
			pstmt = getPrepareStatement(sql,null);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs,pstmt,conn);
		}
		return count;
	}
	//通用的增删改
	public static boolean executeUpdate(String sql,Object[] obj) {	
		try {
			
			pstmt = getPrepareStatement(sql,obj);
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			closeAll(null,pstmt,conn);
		}	
	}

	//通用的查	
	public static ResultSet executeQuery(String sql,Object[] obj) {
//		List<Student> students = new ArrayList<Student>();
//		Student student = null;
		
		try {
			
			pstmt=getPrepareStatement(sql,obj);
			rs = pstmt.executeQuery();
			
			return rs;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
}}