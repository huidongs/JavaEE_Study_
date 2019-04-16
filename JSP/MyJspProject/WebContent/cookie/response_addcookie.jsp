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
			//服务端
			Cookie cookie1 = new Cookie("name","huidong");
			Cookie cookie2= new Cookie("pwd","123");
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			//页面跳转到客户端（转发，重定向）
			response.sendRedirect("result.jsp");
			
		
		%>
</body>
</html>