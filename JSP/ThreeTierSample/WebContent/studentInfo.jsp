<%@page import="priv.huidong.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>		
			<%
				//获取request域中的数据
			Student student =(Student)request.getAttribute("student");	
			%>
			<form action="UpdateStudentServlet" method="post">
				学号：<input type="text" name="sno" value="<%=student.getSno()%>" readonly="readonly"/><br/>
				姓名：<input type="text" name="sname" value="<%=student.getSname()%>"/><br/>
				年龄：<input type="text" name="sage" value="<%=student.getSage()%>"/><br/>
						<input type="submit" value="修改">
						<a href="QueryStudentByPage">返回</a>
			</form>	
</body>
</html>