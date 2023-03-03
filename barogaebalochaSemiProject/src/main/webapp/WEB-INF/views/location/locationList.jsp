<%@page import="semi.team.baro.location.model.vo.Location"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	ArrayList<Location> list = (ArrayList<Location>)request.getAttribute("list");
	String pageNavi = (String)request.getAttribute("pageNavi");
	int start = (int)request.getAttribute("start");
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.loactionList-info, .locationList-location-name{
margin-bottom: 0;
}

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<link rel="stylesheet" href="/css/locationList.css">
	<div class="page-content">
        <div class="loactionList-content-wrap">
            <div class="loactionList-content-header">
                <div>
                <input type="text" class="loactionList-search">
                <img src="/testImage/magnifying-glass.png">
                </div>
                <div>
                    <p>구장리스트</p>
                </div>
            </div>
            <div class="locationList-contents-wrap">
 			<%for(int i=0;i<list.size();i++) {%>
 				<%Location l = list.get(i); %>
                <div class="loactionList-content">
                    <div class="loactionList-main-img">
                        <img class="loactionList-pic" src="/testImage/79e7330368d49cceeaabdcf7ef7513eb (1).jpg">
                    </div>
                    <div class="loactionList-text-wrap">
                        <p class="locationList-location-name">
                           <%=l.getGroundName() %>
                        </p>
                        <p class="loactionList-info">
                           <%=l.getGroundContentBr() %>
                        </p>
                    </div>
                    <div class="locationList-footer-wrap">
                        <a href="/locationInfo.do?groundNo=<%=l.getGroundNo() %>">
                        	<button class="locationList-Info-btn">상세보기</button>
                        </a>
                        <div class="loactionList-sub-img">
                            <img src="/testImage/soccer-shoe.png">
                            <img src="/testImage/football-uniform.png">
                            <img src="/testImage/shower.png">
                            <img src="/testImage/soccer-shoe.png">
                            <img src="/testImage/football-uniform.png">
                            <img src="/testImage/shower.png">
                        </div>
                     </div>
                </div>
                <%} %>
            </div>
            
            <div class="locationList-btn-wrap">
            <div id="pageNavi"><%=pageNavi %></div>
                <a href="/"><button>홈으로</button></a>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>