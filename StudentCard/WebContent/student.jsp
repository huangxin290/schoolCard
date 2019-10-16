<%@page import="org.StudentCard.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery.min.js">
</script>
<script>
function hideMessage() {
	$("#test").innerHTML="bbbb";
	document.getElementsByTagName("a").onclick() = "return false;";
	document.getElementsByTagName("a").href = "javascript:void(0);";
}

</script>

</head>
<body>



用户：${sessionScope.person.no }
<br/>
姓名：${sessionScope.person.name }
<br/>
余额：${sessionScope.person.balance }
<br/>
身份：${sessionScope.person.identity }
<br/>
目前状态：${sessionScope.person.isLost }
<br/>

<a href="shopping.jsp" class="u1">消费</a>
<br/>
<a href="changeInfo.jsp" class="u1">更改密码</a>
<br/>
<a href="QueryRecordByNo" class="u1">查看个人消费记录</a>
<br/>
<a href="ReportLostServlet" class="u1">挂失</a>
<br/>
<%
boolean isLost=((Person)session.getAttribute("person")).getisLost();

if(isLost){
	out.println("<script>hideMessage()</script>");
} %>
</body>
</html>