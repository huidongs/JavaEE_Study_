package priv.huidong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/WelcomeServlet",loadOnStartup=1,initParams={@WebInitParam(name="servletparaname30",value="servletparavalue30")})//3.0所需的注解

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WelcomeServlet() {
        // TODO Auto-generated constructor stub
    	System.out.println("无参构造...");
    }

    @Override
    public void init() throws ServletException {

    	String value = super.getInitParameter("servletParaname30");
    	System.out.println("当前Servlet的初始化参数servetparamname30的值："+value);
    	
    }
   @Override
public void destroy() {
	// TODO Auto-generated method stub
	   System.out.println("destroy...");
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
	}
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost...");
	}

}
