<%@page import="java.util.ArrayList"%>
<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@page import="semi.team.baro.history.model.vo.HistoryPageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Mercenary> mcList = ( ArrayList<Mercenary>)request.getAttribute("mcList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 	.history-menu{
 		overflow: hidden;
 	}
	.history-menu>li{
		float: left;
		list-style-type: none;
		margin-right: 30px;
		margin-bottom: 20px;
		cursor: pointer;
	}
	.active-tab{
		color: #AACB73;
	}
	.history-content th, .history-content td{
		text-align: center;
	}
	.history-content tr:not(tr:first-child):hover{
		background-color: #fcfcfc;
	}
	.history-content td{
		cursor:pointer;
	}
	.history-content td>a:hover{
		color: red;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
			<h2>HISTORY</h2>
		</div>
		<ul class="history-menu">
			<!-- historyMatching.do?memberNo=<%=m.getMemberNo()%>&reqPage=1 -->
			<li><a href="#">MATCHING</a></li>
			<li><a href="history.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=Mercenary">용병모집</a></li>
			<li><a href="#">용병신청</a></li>
			<li><a href="#">게시판</a></li>
			<li><a href="#">신고내역</a></li>
		</ul>	
		<table class="history-content table">
			<tr>
				<th class="col-md-1">no.</th>
				<th class="com-mi-1">지역</th>
				<th class="col-md-3">구장이름</th>
				<th class="col-md=3">경기일</th>
				<th class="col-md-2">모집상태</th>
				<th class="col-md-2">작성일</th>
				<th class="com-md-1"></th>
			</tr>
			<%for(Mercenary mc : mcList) {%>
				<tr>
				<td><%=mc.getMercenaryNo() %></td>
				<td><%=mc.getLocation() %></td>
				<td><%=mc.getGroundName() %></td>
				<td><%=mc.getGameDate() %></td>
				<td><%=mc.getMercenaryWhether() %></td>
				<td><%=mc.getRegDate() %></td>
				<td>신고</td>
			</tr>
			<%} %>
		</table>
	</div>
	<script>

	</script>

	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>