<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <main>
    <h2>메인- 로맨스 페이지 보여준다.</h2>
	<!-- 금주의 신간 -->
	<%@ include file="../preprocess/newRidiWeek.jsp" %>	
	
	<!-- 사람들이 지금 많이 읽고 있는 책 -->
	<%@ include file="../preprocess/nowreading.jsp" %>

	<!-- 오늘 리디의 발견 -->
	<%@ include file="../preprocess/todayRidi.jsp" %>
	
    </main>
