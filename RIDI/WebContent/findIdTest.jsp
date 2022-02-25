<%@page import="find.PwDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>

<%
	Integer Id_Num = Integer.parseInt(request.getParameter("Id_Num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾은 비밀번호</title>
</head>
<body>
	<h1> 찾은 아이디 고유 번호 = <%= Id_Num %></h1>
	
		<input type="password" name="Pw" class="userPw">
		<input type="submit" class="submitbtn">
	
</body>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(".submitbtn").on("click",function(){
	let $Pw = $(".userPw").val();        	
	$.ajax({        		
		url:"/ridibooks/resetPw",
		type:"POST",
		data:"Pw="+$Pw+"&Id_Num="+<%=Id_Num%>,
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