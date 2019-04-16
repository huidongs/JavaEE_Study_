<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="upLoadServlet"  method="post" enctype="multipart/form-data">
		学号:<input type=text name="sno"/>
		姓名:<input type=text name="sname"/>
		上传照片:<input type="file" name="spicture"/>
		<br/>
	<input type="submit" value="注册">
	<br/>
	
	<a href="downLoadServlet?filename=test.png">下载文件</a>
	</form>
</body>
</html>