<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<h2>메인페이지</h2>
		<div class="header-wrap">
            <div class="site-logo">
                <a href="/"><img src="img/FUTSALDATE.png"></a>
            </div>
            <div class="header-content">
                <div class="header-link">
                    <a href="#">JOIN</a>
                    <a href="#">LOGIN</a>
                </div>                
                <div class="nav">
                    <ul class="navi">
                        <li><a href="#">정보수정</a></li>
                        <li><a href="#">회원관리</a></li>
                        <li><a href="#">구장등록</a></li>
                        <li><a href="#">신고관리</a></li>
                        <li>
                            <a href="#" name="search">메뉴</a>
                            <ul class="menu">
                                <li><a href="#" class="searchBox">MATCHING</a></li>
                                <li><a href="#" class="searchBox">용병모집</a></li>
                                <li><a href="#" class="searchBox">구장</a></li>
                                <li><a href="#" class="searchBox">공지사항</a></li>
                                <li><a href="#" class="searchBox">게시판</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>