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
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<link rel="stylesheet" href="/css/locationList.css">
	<div class="page-content">
        <div class="loactionList-content-wrap">
            <div class="loactionList-content-header">
                <div>
                <input type="text" class="loactionList-search">
                <img src="/magnifying-glass.png">
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
                        <img class="loactionList-pic" src="/79e7330368d49cceeaabdcf7ef7513eb (1).jpg">
                    </div>
                    <div class="loactionList-text-wrap">
                        <p class="locationList-location-name">
                           <%=l.getGroundName() %>
                        </p>
                        <p class="loactionList-info">
                           <%=l.getGroundContentBr() %>
                        </p>
                        <div class="loactionList-sub-img">
                            <img src="/soccer-shoe.png">
                            <img src="/football-uniform.png">
                            <img src="/shower.png">
                        </div>
                    </div>
                </div>
                <%} %>
            </div>
            <div id="pageNavi"><%=pageNavi %></div>
            <div class="locationList-btn-wrap">
                <button>홈으로</button>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>