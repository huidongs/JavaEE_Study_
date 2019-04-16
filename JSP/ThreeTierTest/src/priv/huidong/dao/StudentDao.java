package priv.huidong.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import priv.huidong.entity.Student;

//数据访问层是原子性操作
public class StudentDao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PWD = "admin";
	
	



	//根据学号,查询
	public Student queryStudentBySno(int sno) {
		Student student = null;
		PreparedStatement pstmt=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "select * from student where sno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()){
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				student = new Student(no,name,age);
			}
			return student;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
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
}
