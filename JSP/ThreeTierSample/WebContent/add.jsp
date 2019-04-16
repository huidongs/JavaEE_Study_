<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

	function check(){
		var sno=$("#sno").val();
		var sname=$("#sname").val();
		var sage=$("#sage").val();
		if(!(sno>0&&sno<9999)){
			alert("学号有误！");
			return false;
		}
		if(!(sname.length>1&&sname.length<10)){
			alert("姓名有误！");
			return false;
		}
		if(sage.length<1&&sage.length>100){
			alert("年龄有误！");
			return false;
		}
		return true;
	}
	$(document).ready(function(){
		$("tr:odd").css("background-color","lightgray");
	});
	</script>
<body>
	<form action="AddStudentServlet" method="post" onsubmit="return check()">
		学号：<input type="text" name="sno" id="sno"/><br/>
		姓名：<input type="text" name="sname"id="sname"/><br/>
		年龄：<input type="text" name="sage"id="sage"/><br/>
		<input type="submit" value="新增学生信息"/>
		 <a href="QueryStudentByPage">返回</a>
	</form>	
    
</body>
</html>