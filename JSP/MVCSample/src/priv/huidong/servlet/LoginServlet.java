package priv.huidong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.huidong.dao.LoginDao;
import priv.huidong.entity.Login;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理登陆
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		
		Login login = new Login(name,pwd);//用户名密码
		//调用模型层的登录功能
		int result = LoginDao.login(login);
		
		if(result >0) {
			response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
