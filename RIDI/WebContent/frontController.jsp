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
	<%@ include file="header.jsp"%>

	<!-- 본문 캐러셀 -->
	<div class="slideWrap">
		<ul class="control_slider">
			<%
			for(int i=0;i<=10;i++){
				if(i%3==0){
					%>
					<li><img src="images/main.jpg"></li>
					<% 
				}else if(i%3==1){
					%>
					<li><img src="images/main1.jpg"></li>
					<%
				}else if(i%3==2){
					%>
					<li><img src="images/main2.jpg"></li>
					<%
				}
					
			}
		%>
		<c:forEach var="i" begin="1" end="9">
			    if(i%3==0){
					
					<li><img src="images/main.jpg"></li>
					
				}else if(i%3==1){
					
					<li><img src="images/main1.jpg"></li>
					
				}else if(i%3==2){
					
					<li><img src="images/main2.jpg"></li>
					
				}
		</c:forEach>
		</ul>
	</div>

	<section class="navicon">
		<div class="navi">
			<div class="naviwrapper">
				<div class="navicontent">
					<ul>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#E8CB99" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/new.png" alt="신간">
								</div> <span>신간</span>
						</a></li>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#99D1CB" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/gift.png" alt="이벤트">
								</div> <span>이벤트</span>
						</a></li>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#B9BEF1" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/best.png" alt="베스트셀러">
								</div> <span>베스트셀러</span>
						</a></li>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#99D1CB" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/borrow.png" alt="대여전">
								</div> <span>대여전</span>
						</a></li>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#F1C0A7" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/nowpopularset.png" alt="지금 인기세트">
								</div> <span>지금 인기세트</span>
						</a></li>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#ABDCBA" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/newcalendar.png" alt="신간 캘린더">
								</div> <span>신간 캘린더</span>
						</a></li>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#D5ADEB" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/generalmap.png" alt="일반 혜택지도">
								</div> <span>일반 혜택지도</span>
						</a></li>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#F0B9B9" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/weeklycoupon.png" alt="위클리 쿠폰">
								</div> <span>위클리 쿠폰</span>
						</a></li>
						<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 44 44" color="#BADBA1" class="fig-8yznbt">
									<path
										d="M.001 22s-.046 4.493.453 8.846c.428 3.727 1.402 7.614 3.244 9.456 1.842 1.842 5.729 2.816 9.457 3.244 4.352.499 8.845.453 8.845.453s4.493.046 8.846-.453c3.727-.428 7.614-1.402 9.456-3.244 1.842-1.842 2.816-5.729 3.244-9.456.499-4.353.453-8.846.453-8.846s.046-4.493-.453-8.845c-.428-3.728-1.402-7.615-3.244-9.457C38.46 1.856 34.573.882 30.846.454 26.493-.045 22 .001 22 .001s-4.493-.046-8.845.453C9.427.882 5.54 1.856 3.698 3.698 1.856 5.54.882 9.427.454 13.155-.045 17.507.001 22 .001 22"
										fill="currentColor"></path></svg>
								<div class="navilogo">
									<img src="images/ridipaper.png" alt="리디페이퍼">
								</div> <span>리디페이퍼</span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<!-- 방금 나온 신간 -->
	<section class="newridibooks">
		<h2>집 앞 서점에 방금 나온 신간</h2>
		<div class="newridicontent">
			<div class="newrapper">
				<ul class="newcontent">
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
					<li><img src="images/books.jpg">
						<div class="booktitle">
							<h3>다정소감</h3>
							<p>김혼비</p>
						</div></li>
				</ul>
			</div>
		</div>
	</section>

	<!-- 사람들이 지금 많이 읽고 있는 책 -->
	<section class="nowreading">
		<h2 class="nowtitle">
			<div class="time">
				<svg width="12" height="12" viewBox="0 0 12 12"
					xmlns="http://www.w3.org/2000/svg">
					<path
						d="M8.467 9L5 6.913V3h1v3.391l3 1.761L8.467 9zM6 0C2.7 0 0 2.7 0 6s2.7 6 6 6 6-2.7 6-6-2.7-6-6-6z"
						fill="#FFF" stroke="none" stroke-width="1" fill-rule="evenodd"></path></svg>
				<span>01시 06분</span>
			</div>
			사람들이 지금 많이 읽고 있는 책
		</h2>
		<div class="popularcontent">
			<div class="popularwrapper">
				<div class="flex"></div>
				<div class="popular">
					<ul>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent">
								<h3>1</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent">
								<h3>2</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent" style="border: 0;">
								<h3>3</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent">
								<h3>4</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent">
								<h3>5</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent" style="border: 0;">
								<h3>6</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent">
								<h3>7</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent">
								<h3>8</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="popularbook">
									<img src="images/popular.jpg" alt="달러구트 꿈 백화점">
								</div>
							</div>
							<div class="bookcontent" style="border: 0;">
								<h3>9</h3>
								<div class="booklogo">
									<h3 class="bookname">달러구트 꿈 백화점</h3>
									<p>이미예</p>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="flex"></div>
			</div>
		</div>
	</section>

	<!-- 오늘 리디의 발견 -->
	<section class="todayridi">
		<h2>오늘, 리디의 발견</h2>
		<div class="todaycontent">
			<div class="todaywrapper">
				<ul class="todayridicontent">
					<li><img src="images/todaybook.JPG">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
					<li><img src="images/todaybook.jpg">
						<div class="booktitle">
							<h3>
								미래세대에 보내는 <br> 빛을 향한 메세지
							</h3>
						</div></li>
				</ul>
			</div>
		</div>
	</section>


	<!-- 베스트 셀러 -->
	<section class="bestseller">
		<h2 class="besttitle">
			베스트셀러&nbsp;<i class="fas fa-chevron-right" style="font-size: 14px;"></i>
		</h2>
		<div class="popularcontent">
			<div class="bestwrapper">
				<div class="flex"></div>
				<div class="bestselling">
					<ul>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.JPG" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent">
								<h3>1</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.jpg" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent">
								<h3>2</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.jpg" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent" style="border: 0;">
								<h3>3</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.jpg" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent">
								<h3>4</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.jpg" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent">
								<h3>5</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.jpg" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent" style="border: 0;">
								<h3>6</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.jpg" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent">
								<h3>7</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.jpg" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent">
								<h3>8</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="book">
								<div class="bestbook">
									<img src="images/bestseller.jpg" alt="거꾸로 읽는 세계사">
								</div>
							</div>
							<div class="bestcontent" style="border: 0;">
								<h3>9</h3>
								<div class="bestlogo">
									<h3 class="bookname">거꾸로 읽는 세계사</h3>
									<p class="author">유시민</p>
									<p class="stars">
										<span class="starwrapper"> <svg viewBox="0 0 50 10"
												xmlns="http://www.w3.org/2000/svg" fill="currentColor"
												preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
												<path
													d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
										</span> <span class="number">88</span>
									</p>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="flex"></div>
			</div>
		</div>
	</section>

	<!-- 금주의 신간 -->
	<section class="newridiweek">
		<h2>금주의 신간</h2>
		<div class="weekcontent">
			<div class="weekwrapper">
				<ul class="weekridicontent">
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
					<li><img src="images/newridi.JPG">
						<div class="booktitle">
							<h3>삶이라는 우주를 건너는 너에게</h3>
						</div>
						<p>김민형</p></li>
				</ul>
			</div>
		</div>
	</section>
	<main>
		<!-- 리디북스토어 인스타그램 추천도서 -->
		<section class="instabook">
			<h2>
				리디북스토어 인스타그램 추천도서&nbsp;<i class="fas fa-chevron-right"
					style="font-size: 14px;"></i>
			</h2>
			<div class="instacontent">
				<div class="instawrapper">
					<ul class="instaridicontent">
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
						<li><img src="images/instabook.JPG">
							<div class="booktitle">
								<h3>타인을 읽는 말</h3>
							</div>
							<p>로런트 앨리슨,에밀리 ...</p>
							<p class="stars">
								<span class="starwrapper"> <svg viewBox="0 0 50 10"
										xmlns="http://www.w3.org/2000/svg" fill="currentColor"
										preserveAspectRatio="xMinYMid slice" class="fig-fdtj4m">
										<path
											d="M8.089 9.755L5 8.308 1.91 9.755l.423-3.387L0 3.876l3.352-.645L5 .245l1.647 2.987L10 3.876 7.666 6.368l.423 3.387zm20.001 0L25 8.308l-3.09 1.447.423-3.387L20 3.876l3.352-.645L25 .245l1.647 2.987L30 3.876l-2.334 2.492.424 3.387zm-10 0L15 8.308l-3.09 1.447.423-3.387L10 3.876l3.352-.645L15 .245l1.647 2.987L20 3.876l-2.334 2.492.424 3.387zm20 0L35 8.308l-3.09 1.447.422-3.387L30 3.876l3.352-.645L35 .245l1.647 2.987L40 3.876l-2.334 2.492.424 3.387zm10 0L45 8.308l-3.09 1.447.422-3.387L40 3.876l3.352-.645L45 .245l1.647 2.987L50 3.876l-2.334 2.492.424 3.387z"></path></svg>
								</span> <span class="number">25</span>
							</p></li>
					</ul>
				</div>
			</div>
		</section>

	</main>

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