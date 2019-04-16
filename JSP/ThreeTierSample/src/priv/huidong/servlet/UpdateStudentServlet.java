package priv.huidong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.huidong.entity.Student;
import priv.huidong.service.impl.StudentServiceImpl;


public class UpdateStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(  request.getParameter("sno"));
		
		String name = request.getParameter("sname");
		int  age =Integer.parseInt( request.getParameter("sage"));
	
		Student student = new Student(name,age);
		
		//IStudentService service = (IStudentService) new StudentServiceImpl();
		StudentServiceImpl service =  new StudentServiceImpl();

		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		boolean result = service.updateStudentBySno(sno, student);
		if(result) {
			//response.getWriter().println("修改成功！");
			response.sendRedirect("QueryStudentByPage");
		}else {
			response.getWriter().println("修改失败！");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
