<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
用户：${sessionScope.person.no }
<br/>
姓名：${sessionScope.person.name }
<br/>
密码：${sessionScope.person.pwd }
<br/>
余额：${sessionScope.person.balance }
<br/>
身份：${sessionScope.person.identity }


<a href="shopping.jsp">消费</a>
<br/>
<a href="invest.jsp">充值</a>
<br/>
<a href="changeInfo.jsp">更改密码</a>
<br/>
<a href="QueryRecordByNo">查看个人消费记录</a>


</body>
</html>