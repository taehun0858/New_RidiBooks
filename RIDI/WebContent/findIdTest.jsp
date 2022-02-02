<%@page import="find.PwDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>

<%
	PwDto foundPw = (PwDto)request.getAttribute("memberPw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾은 비밀번호</title>
</head>
<body>
	<h1> 찾은 비밀번호 =<%= foundPw.getPw() %> </h1>
	<h1> 찾은 이메일 =<%= foundPw.getEmail() %> </h1>
	<h1> 찾은 아이디 =<%= foundPw.getId() %> </h1>
	
		<input type="password" name="Pw" class="userPw">
		<input type="submit" class="submitbtn">
	
</body>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(".submitbtn").on("click",function(){
	let $Pw = $(".userPw").val();        	
	let memberPw = "<%=foundPw.getPw()%>"
	let memberEmail = "<%=foundPw.getEmail()%>"
	let memberId = "<%=foundPw.getId()%>"
	$.ajax({        		
		url:"/ridibooks/resetPw",
		type:"POST",
		data:"usedPw="+memberPw+"&Email="+memberEmail+"&Id="+memberId+"&Pw="+$Pw,
		success: function(){
			location.href = "/ridibooks/main.html";
		},
		error:function(response){
			
		}
	});
});
</script>


</html>