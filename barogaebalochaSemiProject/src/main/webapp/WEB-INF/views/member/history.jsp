<%@page import="semi.team.baro.mercenary.model.vo.MercenaryRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Mercenary> mcList = ( ArrayList<Mercenary>)request.getAttribute("mcList");
    ArrayList<MercenaryRequest> mcReqList = (ArrayList<MercenaryRequest>)request.getAttribute("mcReqList");
    String categoryName = (String)request.getAttribute("categoryName");
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
	.history-content tr:not(tr:first-child):hover>td{
		color: #AACB73;
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
		<%if( m != null ) {%>
		<ul class="history-menu">
			<li><a href="/historyMatching.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=matching">MATCHING</a></li>
			<li><a href="/historyMercenary.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=mercenary">용병모집</a></li>
			<li><a href="/historyMercenaryRequest.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=mercenaryRequest">용병신청</a></li>
			<li><a href="#">게시판</a></li>
			<li><a href="#">신고내역</a></li>
		</ul>
		<%if( categoryName.equals("mercenary") ){ %>			
		<table class="history-content table">
			<tr>
				<th class="col-md-1">no.</th>
				<th class="com-mi-1">지역</th>
				<th class="col-md-3">구장이름</th>
				<th class="col-md=3">경기일</th>
				<th class="col-md-2">모집상태</th>
				<th class="col-md-2">작성일</th>
			</tr>   
			<%for(Mercenary mc : mcList) {%>
				<tr>
					<td><%=mc.getMercenaryNo() %></td>
					<%if(mc.getLocation().equals("seoul")) {%>
                        <td>서울</td>
                    <%} else if(mc.getLocation().equals("incheon")) {%>
                     	<td>인천</td>
                    <%} else if(mc.getLocation().equals("Gyeonggi")) {%>
                    	<td>경기</td>
                    <%} %>
					<td><%=mc.getGroundName() %></td>
					<td><%=mc.getGameDate() %> [<%=mc.getGameShowTime() %>] </td>
					<%if(mc.getMercenaryWhether() == 0) {%>
					<td>모집중</td>
					<%}else if(mc.getMercenaryWhether() == 1) {%>
					<td>모집완료</td>
					<%} %>
					<td><%=mc.getRegDate() %></td>
				</tr>
			<%} %>
		</table>
		<%}else if( categoryName.equals("mercenaryRequest")) {%>
		<table class="history-content table">
			<tr>
				<th class="col-md-1">no.</th>
				<th class="com-mi-1">지역</th>
				<th class="col-md-3">구장이름</th>
				<th class="col-md=3">경기일</th>
				<th class="col-md-2">모집상태</th>
				<th class="col-md-1">신청결과</th>
				<th class="col-md-2"></th>
			</tr>
			<%for(MercenaryRequest mcReq : mcReqList) {%>
			<tr>
				<td><%=mcReq.getMercenaryNo() %></td>
				<td><%=mcReq.getGameLocation() %>
				<td><%=mcReq.getGroundName() %></td>
				<td><%=mcReq.getGameDate()%> [ <%=mcReq.getGameShowTime() %> ]</td>
				<td><%=mcReq.getMercenaryWhether() %></td>
				<td><%=mcReq.getMercenaryRequestResult() %></td>
				<td><a href="#">신고</a></td>
			</tr>
			<%} %>
		</table>
		<%} %>
	<%} else{%>
		<script>
			alert("올바르지 않은 접근입니다.");
			location.href="/";
		</script>
	<%} %>
	</div>
	<script>
	/*
		$(".history-menu>li>a").on("click", function(){
			    $(".history-menu>li>a").removeClass("active-tab");
			    $(this).addClass("active-tab");
			});
		$(".history-menu>li>a").eq(0).click();
	*/
	</script>

	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>