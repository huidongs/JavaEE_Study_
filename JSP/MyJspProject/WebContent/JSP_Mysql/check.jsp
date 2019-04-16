<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="priv.dao.loginDao"%>
<%@ page import="priv.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <%
        			String name = request.getParameter("uname");
                	String pwd = request.getParameter("upwd");
                	Login login = new Login(name,pwd);
                	priv.dao.loginDao dao = new priv.dao.loginDao();
                	int result = dao.login(login);
                	if(result>0){
                		out.print("登录成功！");
                	}else if(result==0){
                		out.print("用户名或密码错误！");
                	}else{
                		out.print("程序异常!");
                	}
        %>
</body>
</html>