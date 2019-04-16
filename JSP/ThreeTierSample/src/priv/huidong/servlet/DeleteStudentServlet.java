package priv.huidong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.huidong.service.impl.StudentServiceImpl;

public class DeleteStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		
		//IStudentService service = (IStudentService) new StudentServiceImpl();
		StudentServiceImpl service =  new StudentServiceImpl();
		boolean result = service.deleteStudentBySno(sno);
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if(result) {
			//response.getWriter().println("删除成功！");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			response.getWriter().println("删除失败！");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
