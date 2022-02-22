<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:choose>
	<c:when test="${empty param.active or param.active eq 'main' }">
		<!-- 	페이지의 active파라미터가 main이거나 비어있을 때  -->
		<title>일반도서 - 리디북스</title>
		<!-- 		title을 일반도서 - 리디북스로 하겠다.  -->
	</c:when>

	<c:when test="${param.active eq 'romance' }">
		<title>로맨스 웹 소설 - 리디북스</title>
	</c:when>
	<c:when test="${param.active eq 'fantasy' }">
		<title>판타지 웹 소설 - 리디북스</title>
	</c:when>
	<c:when test="${param.active eq 'comic' }">
		<title>웹툰 만화 - 리디북스</title>
	</c:when>
	<c:when test="${param.active eq 'BL' }">
		<title>BL 웹 소설 - 리디북스</title>
	</c:when>
</c:choose>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<link href="css/jquery.bxslider.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<link rel="shortcut icon"
	href="https://static.ridicdn.net/_next/static/images/favicon-29c82025983fa410b3369f441b102764.ico">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">

</head>
<body>
	<!-- 헤더 -->
	<%@ include file="header.jsp"%>
	
	<!-- 메인 -->
	<c:choose>
		<c:when test="${empty param.active or param.active eq 'main' }">
			<%@ include file="view/main_general.jsp"%>
		</c:when>
		<c:when test="${param.active eq 'romance'}">
			<%@ include file="view/main_romance.jsp"%>
		</c:when>
		<c:when test="${param.active eq 'BL' }">
			<%@ include file="view/main_BL.jsp"%>
		</c:when>
		<c:when test="${param.active eq 'comic' }">
			<%@ include file="view/main_comic.jsp"%>
		</c:when>
		<c:when test="${param.active eq 'fantasy' }">
			<%@ include file="view/main_fantasy.jsp"%>
		</c:when>
	</c:choose>

	<!-- 푸터  -->
	<%@ include file="footer.jsp"%>




</body>
</html>