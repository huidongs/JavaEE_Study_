package priv.huidong.service.impl;

import java.util.List;

import priv.huidong.dao.impl.StudentDaoImpl;
import priv.huidong.entity.Student;

//业务逻辑层:逻辑性的增删该查(增=查+增)，对dao层进行的组装；
public class StudentServiceImpl {
	StudentDaoImpl studentdao = new StudentDaoImpl();
	public boolean addStudent(Student student) {
		if(!studentdao.isExist(student.getSno())) {
			studentdao.addStudent(student);
			return true;
		}else {
			System.out.print("此人已存在！");
			return false;
		}
	}
	public boolean deleteStudentBySno(int sno) {
		if(studentdao.isExist(sno)) {
			return studentdao.deleteStudentBySno(sno);
		}else {
			return false;
		}
	}
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentdao.isExist(sno)) {
			return studentdao.updateStudentBySno(sno, student);
		}else {
			return false;
		}
	}
	public Student queryStudentBySno(int sno) {
		return studentdao.queryStudentBySno(sno);
	}
	public List<Student> queryAllStudent() {
		return studentdao.queryAllStudent();
	}

	public List<Student> queryStudentsByPage(int currentPage,int pageSize){
		return studentdao.queryStudentsByPage(currentPage, pageSize);
	}
	public int getTotalCount() {
		return studentdao.getTotalCount();
	}

}
