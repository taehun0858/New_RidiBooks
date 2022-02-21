<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main>
	<!-- 본문 캐러셀 -->
	<%@ include file="../preprocess/slideWrap.jsp" %>

	<!-- 페이지 아이콘 -->
	<%@ include file="../preprocess/navicon.jsp" %>
	<!-- 방금 나온 신간 -->
	<%@ include file="../preprocess/newbooks.jsp" %>

	<!-- 사람들이 지금 많이 읽고 있는 책 -->
	<%@ include file="../preprocess/nowreading.jsp" %>

	<!-- 오늘 리디의 발견 -->
	<%@ include file="../preprocess/todayRidi.jsp" %>


	<!-- 베스트 셀러 -->
	<%@ include file="../preprocess/bestSeller.jsp" %>	

	<!-- 금주의 신간 -->
	<%@ include file="../preprocess/newRidiWeek.jsp" %>	

	<!-- 리디북스토어 인스타그램 추천도서 -->
	<%@ include file="../preprocess/instaBook.jsp" %>	

</main>

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