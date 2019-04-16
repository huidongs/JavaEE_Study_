package priv.huidong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.huidong.entity.Student;
import priv.huidong.service.impl.StudentServiceImpl;


public class QueryStudentBySnoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		
	//	IStudentService service = (IStudentService) new StudentServiceImpl();
		StudentServiceImpl service =  new StudentServiceImpl();
		Student student = service.queryStudentBySno(no);
		System.out.println(student);
		//查到学生后进行页面跳转
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
