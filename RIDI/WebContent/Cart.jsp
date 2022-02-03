<%@page import="java.util.ArrayList"%>
<%@page import="cart.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	List<Book> booklist = (ArrayList<Book>) request.getAttribute("CartBooks");
%>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1><%=booklist.get(0).getTitle() %></h1>
</body>
<script src="js/jquery-3.6.0.min.js"></script>
<script>

	$.ajax({        		
		url:"/ridibooks/mycart",
		type:"POST",
		success: function(books){
		
		},
		error:function(response){
// 			상태코드가 401이면 isLogin에 담긴 고유번호가 없음
//  		상태코드가 400 이면 카트기능상에서 오류생김
		}
	});

</script>

</html>