<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.List"%>
    <%@page import="org.StudentCard.entity.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

人员记录：<br/>
<table border="1px">
<tr>
<th>学号</th>
<th>姓名</th>
<th>密码</th>
<th>余额</th>
<th>身份</th>
</tr>
<%
List<Person> persons=(List<Person>)request.getAttribute("persons");
if(persons!=null){
	
for(Person person:persons){
%>
	<tr><td><%=person.getNo() %></td>
	<td><%=person.getName() %></td>
	<td><%=person.getPwd() %></td>
	<td><%=person.getBalance() %></td>
	<td><%=person.getIdentity() %></td></tr>
	<%
    }
}
%>

</table>

</body>
</html>