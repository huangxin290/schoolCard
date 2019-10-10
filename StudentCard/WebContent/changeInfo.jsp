<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="ChangeInfoServlet" method="post">
		账户：${sessionScope.person.no } <br />
		
		修改后密码：<input type="text" name="pwd1"> <br /> 
		确认密码：： <input type="text" name="pwd2">
		<br />
		 <input type="submit" value="确定">
</form>

</body>
</html>