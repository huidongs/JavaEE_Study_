package priv.huidong.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import priv.huidong.entity.Student;
import priv.huidong.util.DBUtil;

//数据访问层是原子性操作
public class StudentDaoImpl {
	
	public boolean isExist(int sno) {
		return queryStudentBySno(sno)==null?false:true;
	}
	//添加学生
	public boolean addStudent(Student stu) {
		String sql = "insert into student(sno,sname,sage) values(?,?,?)";
		Object[] obj = {stu.getSno(),stu.getSname(),stu.getSage()};
		return DBUtil.executeUpdate(sql, obj);
		
	}
	//根据学号删除学生	
	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where sno=?";
		Object[] obj = {sno};
		return DBUtil.executeUpdate(sql, obj);
			
	}
	//根据学号，修改学生
	public boolean updateStudentBySno(int sno,Student stu) {
		String sql = "update student set sname=?,sage=? where sno=?";
		Object[] obj = {stu.getSno(),stu.getSname(),stu.getSage()};
		return DBUtil.executeUpdate(sql, obj);
					
	}
	//查询全部学生
	public List<Student> queryAllStudent() {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		ResultSet rs =null;
		try {
		String sql = "select * from student";
		Object[] obj = null;
		rs=DBUtil.executeQuery(sql, obj);
		while(rs.next()){
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				student = new Student(no,name,age);
				students.add(student);
			}
			return students;
		
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.conn);
		}
	}
	
	//根据学号查询学生
	public Student queryStudentBySno(int sno) {
		Student student = null;
		ResultSet rs =null;
		try {
		String sql = "select * from student where sno=?";
		Object[] obj = {sno};
		rs=DBUtil.executeQuery(sql, obj);
		while(rs.next()){
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				student = new Student(no,name,age);
			}
			return student;
		
		} 
		 catch (SQLException e) {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(DBUtil.pstmt!=null) {
				try {
					DBUtil.pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(DBUtil.conn!=null) {
				try {
					DBUtil.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} 

	//查询数据总数
	public int getTotalCount() {
		String sql = "select count(*) from student";
		return DBUtil.getTotalCount(sql);			
	}
	//
	public List<Student> queryStudentsByPage(int currentPage,int pageSize){
		String sql = "select * from student limit ?,?";
		Object[] obj = {currentPage*pageSize,pageSize};
		ResultSet rs =DBUtil.executeQuery(sql, obj);
		List<Student> students = new ArrayList<>();
		try {
			while(rs.next()) {
				Student student = new Student(rs.getInt("sno"),rs.getString("sname"),rs.getInt("sage"));
				students.add(student);	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		
		return students;
	}

}
