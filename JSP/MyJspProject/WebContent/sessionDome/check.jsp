<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("uname");
	String pwd = request.getParameter("upwd");
	if(name.equals("huidong")&&pwd.equals("123")){
		//登陆成功
		session.setAttribute("uname", name);
		session.setAttribute("upwd",pwd);
		session.setMaxInactiveInterval(10);
		request.getRequestDispatcher("welcome.jsp").forward(request,response);
	}else{
		//登录失败
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>