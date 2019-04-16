package priv.huidong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.huidong.entity.Student;
import priv.huidong.service.StudentService;


public class QueryStudentBySnoServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		
		StudentService service = new StudentService();
		Student student = service.queryStudentBySno(sno);
		//System.out.println(student);
		System.out.println("哈哈哈");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
