package priv.huidong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.huidong.entity.Student;
import priv.huidong.service.impl.StudentServiceImpl;


public class QueryAllStudentServlet extends HttpServlet {
	
	
	 
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//IStudentService service =  (IStudentService) new StudentServiceImpl();
		StudentServiceImpl service =  new StudentServiceImpl();
	//	List<Student> students = service.queryAllStudent();
		//System.out.println(students);
		
		//request.setAttribute("students", students);
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
