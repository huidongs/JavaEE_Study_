package priv.huidong.dao;

import java.util.List;

import priv.huidong.entity.Student;

public interface IStudentDao {
	
		public boolean isExist(int sno) ;
		
		//根据学号，修改学生
		public boolean updateStudentBySno(int sno,Student stu);
		
		//查询全部学生
		public List<Student> queryAllStudent() ;
		
		//根据学号删除学生
		public boolean deleteStudentBySno(int sno) ;
		
		//添加学生
		public boolean addStudent(Student stu) ;
		
		//根据学号,查询
		public Student queryStudentBySno(int sno) ;
	
		//查询总数据数
		public int getTotalCount();
		//currentPage：当前页 PageSize:页面大小(每页显示的数据条数)
		public List<Student> queryStudentsByPage(int currentPage,int pageSize);
		
}
