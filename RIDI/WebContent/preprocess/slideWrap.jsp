<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="slideWrap">
		<ul class="control_slider">
			<c:forEach var="i" begin="1" end="10">
				<c:choose>
					<c:when test="${i%3==1 }">
						<li><a href="/ridibooks"><img src="images/main.jpg"></a></li>
					</c:when>
					<c:when test="${i%3==2 }">
						<li><a href="/ridibooks/signupcontent.html"><img src="images/main1.jpg"></a></li>
					</c:when>
					<c:when test="${i%3==0 }">
						<li><a href="/ridibooks/login.html"><img src="images/main2.jpg"></a></li>
					</c:when>
				</c:choose>
			</c:forEach>
		</ul>
	</div>

	<script>
// 		액티브에 맞는 사진과 링크들로 바꾸기(에이잭스)
	</script>