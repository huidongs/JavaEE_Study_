
package priv.huidong.service;

import java.util.List;

import priv.huidong.entity.Student;

public interface IStudentService {
	public boolean addStudent(Student student) ;
		
	public boolean deleteStudentBySno(int sno) ;
		
	public boolean updateStudentBySno(int sno,Student student) ;
		
	public Student queryStudentBySno(int sno) ;
		
	public List<Student> queryAllStudent() ;
	
	//查询当前页数据
	public List<Student> queryStudentsByPage(int currentPage,int pageSize);
	//查询总数据
	public int getTotalCount();

}
