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
	//设置编码
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("uname");
	int age = Integer.parseInt(request.getParameter("uage"));
	String pwd = request.getParameter("upwd");
	String[] hobbies = request.getParameterValues("uhobbies");
	
%>

	注册成功，信息如下：<br/>
	姓名：<%=name %><br/>
	年龄：<%=age %><br/>
	密码：<%=pwd %><br/>
	爱好：<br/>
	<%
	  for(String hobby : hobbies)
	  {
		  out.print(hobby+"&nbsp;");
	  }
	%>
	

</body>
</html>