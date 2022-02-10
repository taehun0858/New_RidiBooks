<%@page import="java.util.ArrayList"%>
<%@page import="search.SearchDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String searchWord = request.getParameter("searchword");
	List<SearchDto> results = (ArrayList<SearchDto>)request.getAttribute("searchResults");
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
<%-- 		<p> <%= results.get(0).getTitle() %></p> --%>
	</div>
</body>
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

$.ajax({        		
	url:"/ridibooks/search",
	type:"GET",
	data:"active=show&searchword=test",
	success: function(){
		
	},
	error:function(response){
		
	}
});
</script>
</html>