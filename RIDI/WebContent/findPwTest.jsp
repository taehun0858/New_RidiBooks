<%@page import="find.PwDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	PwDto foundPw = (PwDto) request.getAttribute("PwDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾은 아이디</title>
</head>
<body>
	<h1> 찾은 비밀번호 =<%= foundPw.getPw() %> </h1>
		<input type="text" name="Pw" class="Pw">
</body>

<script src="js/jquery-3.6.0.min.js"></script>
    <script>
    
    $(".findbtn").on("click", function() {
    	let $userPw = $(".Pw").val();
    	$.ajax({
            url: "/ridibooks/find",
            type: "POST",
            data: "Pw="+userPw,
            success: function(data) {
                location.href = "foundPw.jsp";
            },
            error: function(response) {
                
            }
        });

    });
    
    </script>


</html>