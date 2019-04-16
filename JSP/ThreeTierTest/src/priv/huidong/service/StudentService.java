package priv.huidong.service;


import priv.huidong.dao.StudentDao;
import priv.huidong.entity.Student;

//业务逻辑层:逻辑性的增删该查(增=查+增)，对dao层进行的组装；
public class StudentService {
	StudentDao studentdao = new StudentDao();
	
	public Student queryStudentBySno(int sno) {
		return studentdao.queryStudentBySno(sno);
	}
	


}
