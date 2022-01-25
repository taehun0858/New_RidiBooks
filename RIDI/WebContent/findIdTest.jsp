<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>

<%
	String foundId = request.getParameter("findid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾은 아이디</title>
</head>
<body>
	<h1> 찾은 아이디 =<%= foundId %> </h1>  
</body>


</html>