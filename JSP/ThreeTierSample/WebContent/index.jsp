<%@page import="java.util.List"%>
<%@page import="priv.huidong.entity.Student"%>
<%@page import="priv.huidong.entity.Page"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("tr:odd").css("background-color","lightgray");
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息列表</title>
</head>
<body>

	<%	
		String error = (String)request.getAttribute("error");
		if(error!=null){
			if(error.equals("addError")){
				out.print("增加失败！");
			}else if(error.equals("noaddError")){
				out.print("增加成功！");
			}
		}
	
	%>
		<table border="1px" background-color:red>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<%
				//获取request域中的数据
		    Page p= (Page)request.getAttribute("p");
			for(Student student:p.getStudent()){
			%>
			<tr>
				<td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
				<td><%=student.getSname()%></td>
				<td><%=student.getSage()%></td>
				<td><a href="DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a>></td>
			</tr>
			<%
			}
			%>
			
		</table>
		<a href="add.jsp">增加</a>
		<a href="QueryStudentByPage?currentPage=0">首页</a>
		<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
		<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
		<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()-1%>">尾页</a>
		
		
		

</body>
</html>