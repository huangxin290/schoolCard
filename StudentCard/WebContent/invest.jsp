<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="InvestServlet" method="post">
		账户：${sessionScope.person.no } <br />
		当前余额：${sessionScope.person.balance } <br /> 
		充值金额：<input type="text" name="invest"> <br /> 
		充值地点： <select name="place">
			<option value="北一">北一</option>
			<option value="北二">北二</option>
			<option value="图书馆">图书馆</option>
			<option value="中快">中快</option>
		</select> <br />
		 <input type="submit" value="确定">
	</form>

</body>
</html>