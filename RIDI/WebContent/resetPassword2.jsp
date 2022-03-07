<%@page import="find.PwDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
PwDto foundPw = (PwDto)request.getAttribute("memberPw");
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 재설정 - 리디북스</title>
    <link rel="stylesheet" href="css/resetPassword2.css">
    <link rel="shortcut icon" href="https://static.ridicdn.net/_next/static/images/favicon-29c82025983fa410b3369f441b102764.ico">
</head>

<body>
    <!-- 상단 배너 -->
    <div class="header-wrapper">
        <h1 class="logo-title">
            <a href="http://www.ridibooks.com/">
                <svg viewBox="0 0 316 49" width="84" height="13" fill="#1f8ce6">
                <path d="M22.7 17.5c0 2.2-.4 3.8-1.3 4.8s-2.4 1.5-4.6 1.5h-4.1V11.2h4.1c2.2 0 3.7.5 4.6 1.5.8.9 1.3 2.5 1.3 4.8zm12.1 0c0-6.1-1.4-10.4-4.2-12.8C27.9 2.3 23.2 1 16.9 1H2.2C1.1 1 .7 1.4.7 2.5V46c0 1.1.4 1.5 1.5 1.5h9c1.1 0 1.5-.4 1.5-1.5V33.3H16l.1.3 6 12.4c.5 1 1.3 1.4 2.5 1.4h9.1c.8 0 .9-.3.9-.4.1-.3.1-.8-.2-1.3l-7.3-13.8-.3-.5.5-.2.3-.1c4.8-2.2 7.2-6.8 7.2-13.6zM53.9 46V2.5c0-1.1-.4-1.5-1.5-1.5h-9c-1.1 0-1.5.4-1.5 1.5V46c0 1.1.4 1.5 1.5 1.5h9c1.1 0 1.5-.4 1.5-1.5zm30.2-21.7c0 5-.6 8.2-1.7 10-1.2 1.9-3.3 2.8-6.2 2.8h-2.5V11.4H76c2.9 0 5 .9 6.2 2.8 1.3 1.8 1.9 5.1 1.9 10.1zm7.5 18c3.1-3.5 4.7-9.5 4.7-18s-1.6-14.6-4.7-18C88.5 2.8 83.4 1 76.5 1H63.2c-1.1 0-1.5.4-1.5 1.5V46c0 1.1.4 1.5 1.5 1.5h13.4c6.9 0 11.9-1.7 15-5.2zm23.9 3.7V2.5c0-1.1-.5-1.5-1.5-1.5h-9c-1.1 0-1.5.4-1.5 1.5V46c0 1.1.4 1.5 1.5 1.5h9c1 0 1.5-.4 1.5-1.5zm30.1-12.9c0 1.8-.4 3.1-1.2 3.9-.8.8-2.1 1.2-4.1 1.2h-5.4V28h5.3c1.8 0 3.2.4 4.1 1.2.8.8 1.3 2.1 1.3 3.9zm-1-18.3c0 1.6-.4 2.8-1.2 3.5-.8.8-2 1.1-3.7 1.1H135v-9.1h4.8c1.7 0 2.9.3 3.7 1.1.7.7 1.1 1.8 1.1 3.4zm5.8 8.2l-1.3-.4 1.2-.5.6-.3c3.5-1.6 5.3-4.7 5.3-9.2 0-4.4-1.3-7.4-3.7-9-2.6-1.7-6.8-2.6-12.4-2.6h-15.5c-1.1 0-1.5.4-1.5 1.5V46c0 1.1.4 1.5 1.5 1.5h16.6c11 0 16.3-4.4 16.3-13.6 0-2.9-.6-5.2-1.8-7-1.2-1.8-2.8-3-4.7-3.7l-.6-.2zm36.3 1.3c0 5.2-.4 8.7-1.3 10.6-.9 2-2.6 3.1-4.8 3.1-2.2 0-3.8-1.1-4.7-3.1-.8-1.9-1.2-5.4-1.2-10.6 0-5.2.4-8.7 1.2-10.6.9-2 2.5-3.1 4.7-3.1s3.9 1.1 4.8 3.1c.9 1.9 1.3 5.4 1.3 10.6zm11 11.6c.8-3.2 1.2-7.1 1.2-11.6 0-4.6-.4-8.5-1.2-11.6-.8-3.1-2-5.6-3.6-7.3-1.6-1.8-3.5-3.1-5.6-3.8-2.2-.8-4.8-1.2-7.8-1.2s-5.6.4-7.8 1.2c-2.1.8-4 2-5.6 3.8-1.6 1.8-2.8 4.2-3.6 7.3-.8 3.2-1.2 7.1-1.2 11.6 0 4.6.4 8.5 1.2 11.6.8 3.1 2 5.6 3.6 7.3 1.6 1.8 3.5 3.1 5.6 3.8 2.2.8 4.8 1.2 7.8 1.2s5.6-.4 7.8-1.2c2.1-.8 4-2.1 5.6-3.8 1.6-1.7 2.8-4.2 3.6-7.3zm30-11.6c0 5.2-.4 8.7-1.3 10.6-.9 2-2.6 3.1-4.8 3.1-2.2 0-3.9-1.1-4.7-3.1-.8-1.9-1.2-5.4-1.2-10.6 0-5.2.4-8.7 1.2-10.6.9-2 2.5-3.1 4.7-3.1s3.9 1.1 4.8 3.1c.8 1.9 1.3 5.4 1.3 10.6zm10.9 11.6c.8-3.2 1.2-7.1 1.2-11.6 0-4.6-.4-8.5-1.2-11.6-.8-3.1-2-5.6-3.6-7.3-1.6-1.8-3.5-3.1-5.6-3.8-2.2-.8-4.8-1.2-7.8-1.2s-5.6.4-7.8 1.2c-2.1.8-4 2-5.6 3.8-1.6 1.8-2.8 4.2-3.6 7.3-.8 3.2-1.2 7.1-1.2 11.6 0 4.6.4 8.5 1.2 11.6.8 3.1 2 5.6 3.6 7.3 1.6 1.8 3.5 3.1 5.6 3.8 2.2.8 4.8 1.2 7.8 1.2s5.6-.4 7.8-1.2c2.1-.8 4-2.1 5.6-3.8 1.6-1.7 2.8-4.2 3.6-7.3zm42.7 11.2c.1-.2.2-.6-.2-1.3l-11.7-23.6-.1-.3.1-.2 11-19c.4-.7.3-1 .2-1.3-.1-.1-.2-.4-.9-.4h-9.5c-1.1 0-1.9.5-2.5 1.7l-8.3 14.8-1 1.8V2.5c0-1.1-.4-1.5-1.5-1.5h-9c-1.1 0-1.5.4-1.5 1.5V46c0 1.1.4 1.5 1.5 1.5h9c1.1 0 1.5-.4 1.5-1.5V25l1 2.1 8.9 18.7c.5 1.1 1.3 1.6 2.4 1.6h9.6c.7.1.9-.1 1-.3zm34.4-12.4c0-2-.2-3.7-.7-5.2-.5-1.4-1.3-2.7-2.4-3.8-1.2-1.2-2.3-2.1-3.4-2.8-1.1-.7-2.7-1.7-4.8-2.8-4.3-2.2-6.3-4.2-6.3-6.3 0-1.6.8-2.4 1.5-2.8.8-.4 2.1-.6 3.8-.6 2.7 0 5.1.4 7.3 1.1.3.1.6.1.8.1.5 0 .9-.2 1.1-1.1l1.2-6.4c.1-.6.1-1.4-1.3-2C309.6.9 306 .3 301.7.3c-5.4 0-9.5 1-12.1 3.1-2.5 2-3.8 5.3-3.8 9.9 0 2.2.3 4.1.9 5.8.6 1.6 1.4 3 2.6 4.2 1.2 1.2 2.3 2.1 3.5 2.9 1.1.7 2.6 1.5 4.3 2.3 2.5 1.3 4.1 2.3 5 3 1 .8 1.5 1.8 1.5 2.9 0 2.5-2.3 3.7-6.9 3.7-2.8 0-5.5-.5-7.9-1.4-.4-.1-.7-.2-1-.2-.3 0-.7 0-1 1.1l-1.2 6.5c-.2.8 0 1.1 0 1.2.1.1.4.5 1.3.8 3.5 1.4 7.8 2.1 12.7 2.1 4.7 0 8.6-1.1 11.6-3.3 3-2.2 4.5-5.6 4.5-10.2z"></path>
            </svg>
            </a>
        </h1>
    </div>

    <!-- 본문 -->
    <section>
        <div class="main">
            <div class="account-form">
                <h2>이메일이 전송되었습니다!</h2>
                <h3><%=foundPw.getEmail()%>로<br>
                    비밀번호 안내 메일을 보내드렸습니다.
                </h3>
                <button type="button" class="home">홈으로</button>
            </div> 
        </div>
    </section>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script>
    $(".home").on("click" ,function () {
    	 location.href = "/ridibooks/";
    });
    </script>
</body>
</html>