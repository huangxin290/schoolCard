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
<br/><br/>

<a href="QueryAllPersonServlet">查看所有用户</a>
<br/>
<a href="addPerson.jsp">添加用户</a>
<br/>
<a href="deletePerson.jsp">注销用户</a>
<br/>
<a href="changeInfo.jsp">更改密码</a>
<br/>
<a href="QueryAllRecordServlet">查询所有消费记录</a>
<br/>
<a href="">查询所有挂失，激活记录</a>
<br/>






</body>
</html>