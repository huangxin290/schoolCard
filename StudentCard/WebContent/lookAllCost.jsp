<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="org.StudentCard.entity.Record" %>
    <%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

消费记录：<br/>
<table border="1px">
<tr>
<th>时间</th>
<th>地点</th>
<th>金额</th>
<th>余额</th>
</tr>
<%
List<Record> records=(List<Record>)request.getAttribute("records");
if(records!=null){
	
for(Record record:records){
%>
	<tr><td><%=record.getTime() %></td>
	<td><%=record.getPlace() %></td>
	<td><%=record.getCost() %></td>
	<td><%=record.getBalance() %></td></tr>
	<%
    }
}
%>

</table>

</body>
</html>