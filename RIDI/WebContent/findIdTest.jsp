<%@page import="find.PwDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>

<%
	String usedPw = request.getParameter("Pw");
	String Id = request.getParameter("Id");
	String Email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾은 비밀번호</title>
</head>
<body>
	<h1> 찾은 비밀번호 =<%= usedPw %> </h1>
	<h1> 찾은 이메일 =<%= Email %> </h1>
	<h1> 찾은 아이디 =<%= Id %> </h1>
	
		<input type="password" name="Pw" class="userPw">
		<input type="submit" class="submitbtn">
	
</body>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(".submitbtn").on("click",function(){
	let $Pw = $(".userPw").val();        	
	let memberPw = "<%=usedPw%>"
	let memberEmail = "<%=Email%>"
	let memberId = "<%=Id%>"
	$.ajax({        		
		url:"/ridibooks/resetPw",
		type:"POST",
		data:"usedPw="+memberPw+"&Email="+memberEmail+"&Id="+memberId+"&Pw="+$Pw,
		success: function(){
			alert("비밀번호 변경을 성공했습니다.")
			location.href = "/ridibooks/main.html";
		},
		error:function(response){
			
		}
	});
});
</script>


</html>