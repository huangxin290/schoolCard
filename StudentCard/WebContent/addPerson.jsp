<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="AddPersonServlet" method="post">
		账户名：<input type="text" name="no"> <br /> 
		姓名：<input type="text" name="name"> <br /> 
		密码：<input type="text" name="pwd"> <br /> 
		余额：<input type="text" name="balance"><br /> 
		身份：<select name="identity">
			<option value="student">student</option>
			<option value="administrator">administrator</option>
</select>
<input type="submit" value="确定" >
	</form>

</body>
</html>