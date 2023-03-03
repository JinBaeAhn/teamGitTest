<%@page import="semi.team.baro.location.model.vo.Location"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Location l = (Location)request.getAttribute("l");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="page-content">
	        <div class="locationInfo-page-title">
	            <p>구장상세정보</p>
	        </div>
	        <div class="locationInfo-img-wrap">
	            <div class="locationInfo-main-img">
	                <img src="/79e7330368d49cceeaabdcf7ef7513eb (1).jpg">
	            </div>
	        </div>
	        <div class="locationInfo-map-icon-wrap">
	            <div class="locationInfo-map">
	                <img src="/pin_drop_FILL0_wght400_GRAD0_opsz48.png">
	            </div>
	            <div class="locationInfo-icon-wrap">
	                <img src="/testImage/soccer-shoe.png" class="locationInfo-icon">
	                <img src="/testImage/soccer-ball.png" class="locationInfo-icon">
	                <img src="/testImage/football-uniform.png" class="locationInfo-icon">
	                <img src="/testImage/shower.png" class="locationInfo-icon">
	                <img src="/testImage/parking.png" class="locationInfo-icon">
	                <img src="/testImage/water.png" class="locationInfo-icon">
	            </div>
	        </div>
	        <hr>
	        <div class="locationInfo-text-content">
	            <p class=title>구장이름: <%=l.getGroundName() %></p>
	            <p class=title>대여료: <%=l.getGroundPrice() %>원</p>
	            <p class=title>구장소개</p>
	            <p>
	            <%=l.getGroundContentBr() %>
	            </p>
	        </div>
	        <div class="locationInfo-btn-wrap">
	            <a href="/locationList.do?requestPage=1"><button>목록으로</button></a>
	        </div>
	   </div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>