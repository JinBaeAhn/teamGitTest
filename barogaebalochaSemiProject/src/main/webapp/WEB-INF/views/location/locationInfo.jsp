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
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=osh0s8np34&submodules=geocoder"></script>
<title>Insert title here</title>
<style>
	.delete-btn{
	margin-top:15px;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="page-content">
	        <div class="locationInfo-page-title">
	            <p>구장상세정보</p>
	        </div>
	        <div class="locationInfo-img-wrap">
	            <div class="locationInfo-main-img">
	                <img src="/upload/location/<%=l.getFilePath() %>">
	            </div>
	        </div>
	        <div class="locationInfo-map-icon-wrap">
	            <div class="locationInfo-map"></div>
				<!-- <div id="map" style="width:100%; height: 400px; margin: 0 auto;"></div> -->
				<input type="hidden" id="groundLat" value="<%=l.getGroundLat()%>">
				<input type="hidden" id="groundLng" value="<%=l.getGroundLng() %>">
	            <!-- </div> -->
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
	            <%if(m.getMemberLevel()==1) {%>
	            <a href="/deleteLocation.do?groundNo=<%=l.getGroundNo() %>"><button class = "delete-btn" >구장삭제</button></a>
	            <%} %>
	        </div>
	   </div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
<script>
	const groundLat = $("#groundLat").val(); //위도
	const groundLng = $("#groundLng").val(); //경도
	console.log(groundLat);
	console.log(groundLng);
	
	const map = new naver.maps.Map("map",{
		center : new naver.maps.LatLng(groundLat, groundLng),//지도의 중심지정
		zoom : 18, //지도의 배율
	        draggable: false,
	        pinchZoom: false,
	        scrollWheel: false,
	});
	//지도(지정위치)위에 마커
	const marker = new naver.maps.Marker({
		position : new naver.maps.LatLng(groundLat, groundLng),
		map : map //위에서 선언한 map에 올리라는 의미
	});
</script>
</html>