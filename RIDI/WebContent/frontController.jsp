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



<script src="js/jquery.bxslider.js"></script>
<script>
	$(".home a").on("click", function() {
		$(".home a").toggleClass("underline");
	});
	$(".alarm a").on("click", function() {
		$(".alarm a").toggleClass("underline");
	});
	$(".cart a").on("click", function() {
		$(".cart a").toggleClass("underline");
	});
	$(".myridi a").on("click", function() {
		$(".myridi a").toggleClass("underline");
	});
</script>

<!-- 상단 캐러셀 -->
<script>
	$(document).ready(function() {
		$(".control_slider").bxSlider({
			mode : 'horizontal',// 가로 방향 수평 슬라이드
			speed : 1500, // 이동 속도를 설정
			pager : true, // 현재 위치 페이징 표시 여부 설정
			moveSlides : 1, // 슬라이드 이동시 개수
			slideWidth : 414.95, // 슬라이드 너비
			minSlides : 1, // 최소 노출 개수
			maxSlides : 3, // 최대 노출 개수
			slideMargin : 10, // 슬라이드간의 간격
			auto : true, // 자동 실행 여부
			autoHover : true, // 마우스 호버시 정지 여부
			controls : true, // 이전 다음 버튼 노출 여부
			nextText : '<i class="fas fa-chevron-right"></i>',
			prevText : '<i class="fas fa-chevron-left"></i>'

		});

	});
</script>

<!-- 집 앞 서점에 방금 나온 신간 -->
<script>
	$(document).ready(function() {
		$(".newcontent").bxSlider({
			mode : 'horizontal',// 가로 방향 수평 슬라이드
			speed : 200, // 이동 속도를 설정
			pager : false, // 현재 위치 페이징 표시 여부 설정
			moveSlides : 1, // 슬라이드 이동시 개수
			slideWidth : 140, // 슬라이드 너비
			minSlides : 1, // 최소 노출 개수
			maxSlides : 6, // 최대 노출 개수
			slideMargin : 20, // 슬라이드간의 간격
			auto : false, // 자동 실행 여부
			autoHover : true, // 마우스 호버시 정지 여부
			controls : true, // 이전 다음 버튼 노출 여부
			nextText : '<i class="fas fa-chevron-right"></i>',
			prevText : '<i class="fas fa-chevron-left"></i>'

		});

	});
</script>

<!--오늘, 리디의 발견 -->
<script>
	$(document).ready(function() {
		$(".weekridicontent").bxSlider({
			mode : 'horizontal',// 가로 방향 수평 슬라이드
			speed : 300, // 이동 속도를 설정
			pager : false, // 현재 위치 페이징 표시 여부 설정
			moveSlides : 6, // 슬라이드 이동시 개수
			slideWidth : 140, // 슬라이드 너비
			minSlides : 1, // 최소 노출 개수
			maxSlides : 6, // 최대 노출 개수
			slideMargin : 20, // 슬라이드간의 간격
			auto : false, // 자동 실행 여부
			autoHover : true, // 마우스 호버시 정지 여부
			controls : true, // 이전 다음 버튼 노출 여부
			nextText : '<i class="fas fa-chevron-right"></i>',
			prevText : '<i class="fas fa-chevron-left"></i>'
		});
	});
</script>

<!-- 금주의 신간 -->
<script>
	$(document).ready(function() {
		$(".todayridicontent").bxSlider({
			mode : 'horizontal',// 가로 방향 수평 슬라이드
			speed : 300, // 이동 속도를 설정
			pager : false, // 현재 위치 페이징 표시 여부 설정
			moveSlides : 6, // 슬라이드 이동시 개수
			slideWidth : 140, // 슬라이드 너비
			minSlides : 1, // 최소 노출 개수
			maxSlides : 6, // 최대 노출 개수
			slideMargin : 20, // 슬라이드간의 간격
			auto : false, // 자동 실행 여부
			autoHover : true, // 마우스 호버시 정지 여부
			controls : true, // 이전 다음 버튼 노출 여부
			nextText : '<i class="fas fa-chevron-right"></i>',
			prevText : '<i class="fas fa-chevron-left"></i>'
		});
	});
</script>
<!-- 리디북스토어 인스타그램 추천도서 -->
<script>
	$(document).ready(function() {
		$(".instaridicontent").bxSlider({
			mode : 'horizontal',// 가로 방향 수평 슬라이드
			speed : 100, // 이동 속도를 설정
			pager : false, // 현재 위치 페이징 표시 여부 설정
			moveSlides : 6, // 슬라이드 이동시 개수
			slideWidth : 140, // 슬라이드 너비
			minSlides : 1, // 최소 노출 개수
			maxSlides : 6, // 최대 노출 개수
			slideMargin : 20, // 슬라이드간의 간격
			auto : false, // 자동 실행 여부
			autoHover : true, // 마우스 호버시 정지 여부
			controls : true, // 이전 다음 버튼 노출 여부
			nextText : '<i class="fas fa-chevron-right"></i>',
			prevText : '<i class="fas fa-chevron-left"></i>'
		});
	});
</script>
</body>
</html>