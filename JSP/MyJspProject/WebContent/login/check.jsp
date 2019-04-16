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
		//response.sendRedirect("success.jsp");//数据丢失，页面跳转导致数据丢失
		request.getRequestDispatcher("success.jsp").forward(request,response);
	}else{
		out.print("用户名或密码错误！");
	}
%>
</body>
</html>