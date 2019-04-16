<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
 public String bookName;//全局变量
 public void init()
 {
	 bookName="java从入门到精通";
 }
%>

<%
	String name="huidong";
	out.print("hello.."+name);
	init();
%>

<%="Hello..."+bookName %>
</body>
</html> 	