<%@page import="java.util.ArrayList"%>
<%@page import="search.SearchDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String searchWord = request.getParameter("searchword");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과 테스트 페이지</title>
</head>
<body>
	<h1> <%= searchWord %>에 대한 검색 결과 </h1>
	<div class="searchResult">
		<span id="result"></span>
	</div>
</body>
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
const element = document.getElementById("result");
$.ajax({        		
	url:"/ridibooks/search",
	type:"GET",
	data:"active=show&searchWord=test",
	dataType:"json",
	success: function(data){
		console.log(data);
		alert(data[0].author);
		for(var i=0;i<=data.length-1;i++){
			element.innerHTML += 
				"<div>"+data[i].author+"</div>"+
				"<img src=\"/ridibooks/images/"+data[i].author+".jpg\"></img>"			
		}
		
	},
	error:function(response){
		
	}
});
</script>
</html>