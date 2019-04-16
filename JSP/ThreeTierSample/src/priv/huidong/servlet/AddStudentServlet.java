package priv.huidong.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import priv.huidong.entity.Student;
import priv.huidong.service.impl.StudentServiceImpl;


public class AddStudentServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		int sno = Integer.parseInt(request.getParameter("sno"));
		String sname = request.getParameter("sname");
		int sage = Integer.parseInt(request.getParameter("sage"));
		Student student = new Student(sno,sname,sage);
		//接口x=new实现类();
		//IStudentService studentservice = (IStudentService) new StudentServiceImpl();
		StudentServiceImpl studentservice = new StudentServiceImpl();
		boolean result = studentservice.addStudent(student);
		
		/*
		 * out request response session appplication
		 * out:  PrintWriter out = response.getWriter()
		 * session:       request.getSession();
		 * application:   request.getServletContext()
		 * 
		 * */
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
	//	PrintWriter out = response.getWriter();
		
//		if(result) {	
//			out.println("增加成功！");
//		}else {
//			out.print("增加失败！");
//		}
		if(!result) {
			request.setAttribute("error","addError");
		}else {
			request.setAttribute("error", "noaddError");
		}
		request.getRequestDispatcher("QueryStudentByPage").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
