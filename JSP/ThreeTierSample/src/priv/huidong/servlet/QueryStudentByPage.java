package priv.huidong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.huidong.entity.Page;
import priv.huidong.entity.Student;
import priv.huidong.service.impl.StudentServiceImpl;


public class QueryStudentByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//IStudentService studentService = (IStudentService) new StudentServiceImpl();
		StudentServiceImpl studentService =  new StudentServiceImpl();
	
		
		Page page = new Page();
		int count = studentService.getTotalCount();
		page.setTotalCount(count);
		String  cPage = request.getParameter("currentPage");
		if(cPage==null) {
			cPage="0";
		}
		int currentPage=Integer.parseInt(cPage);
		page.setCurrentPage(currentPage);
		int pageSize = 2;
		page.setPageSize(pageSize);
		
		List<Student> students = studentService.queryStudentsByPage(currentPage,pageSize);
		page.setStudent(students);
		System.out.println(students);
		System.out.println(count);
		
		request.setAttribute("p",page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
