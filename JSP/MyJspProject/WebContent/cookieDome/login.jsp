<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	String uname;
%>

	<% 
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){	
			if(cookie.getName().equals("uname")){
				uname=cookie.getValue();
			}
		}
	%>
	<form action="check.jsp" method="post">
		用户名：<input type="text" name="uname" value=<%=(uname==null?"":uname)%>><br/>
		密码：<input type="text" name="upwd"><br/>
		<input type="submit" value="登录"><br/>
	
	</form>
	
</body>
</html>