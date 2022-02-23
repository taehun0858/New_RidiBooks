<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="newridiweek">
		<h2>금주의 신간</h2>
		<div class="weekcontent">
			<div class="weekwrapper">
				<ul class="weekridicontent" id="result">
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
<!-- 					<li><img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p></li> -->
					
<!-- 						<li> -->
<!-- 						<img src="images/newridi.JPG"> -->
<!-- 						<div class="booktitle"> -->
<!-- 							<h3>삶이라는 우주를 건너는 너에게</h3> -->
<!-- 						</div> -->
<!-- 						<p>김민형</p> -->
<!-- 						</li> -->
					
				</ul>
			</div>
		</div>
	</section>
	<script src="js/jquery-3.6.0.min.js"></script>
	<script>
	// 카테고리에 따른 금주 신간의 책을 받아와서 
	// 그 수만큼 넣는다.
		const element = document.getElementById("result");
		const url = new URL(window.location.href);
		const urlParams = url.searchParams;
		let active = urlParams.get('active');
		if(active=="main" || active==null){
			active="general";
		}
		// word => ?searchword=값으로 된다
		
		$.ajax({        		
			url:"/ridibooks/book",
			type:"GET",
			data:"sql=SELECT * from book WHERE b_category=\""+active+"\" AND b_event=\"newridiweek\"",
			dataType:"json",
			success: function(data){
				// 해당 카테고리의 모든 책들을 선택하고 있으나,
				// 만든 데이터베이스의 해당 카테고리 자체에 데이터 자체가 몇개 없어서 쓰는데 지장없음.
				if(data.length>=7){
					for(var i=0;i<=data.length-1;i++){
						element.innerHTML +=
							"<li><img src=\""+data[i].imageUrl+"\"></img>"
							+"<div class=\"booktitle\">"
							+"<h3>"+data[i].title+" </h3>"
							+"</div><p>"+data[i].author+"</p></li>"
					}
				}else{
					// 데이터 베이스에 충분한 양의 책을 등록을 안해놧기 때문에 임시방편으로 일단 해놓음
					for(var i=0;i<=6;i++){
						element.innerHTML +=
							"<li><img src=\""+data[i%2].imageUrl+"\"></img>"
							+"<div class=\"booktitle\">"
							+"<h3>"+data[i%2].title+" </h3>"
							+"</div><p>"+data[i%2].author+"</p></li>"
					}
				}
				
				
				
			},
			error:function(){
				
			}
		});
	</script>