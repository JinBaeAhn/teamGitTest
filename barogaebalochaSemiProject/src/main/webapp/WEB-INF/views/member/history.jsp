<%@page import="semi.team.baro.mercenary.model.vo.MercenaryRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Mercenary> mcList = ( ArrayList<Mercenary>)request.getAttribute("mcList");
    ArrayList<MercenaryRequest> mcReqList = (ArrayList<MercenaryRequest>)request.getAttribute("mcReqList");
    
    String pageNavi = (String)request.getAttribute("pageNavi");
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
	.page-navi{
		margin: 50px auto;
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
				<th style="width:5%">no.</th>
				<th style="width:10%">지역</th>
				<th style="width:25%">구장이름</th>
				<th style="width:25%">경기일</th>
				<th style="width:20%">작성일</th>
				<th style="width:10%">모집상태</th>
				<th></th>
			</tr>   
			<%for(Mercenary mc : mcList) {%>
				<tr onclick="location.href='/mercenaryView.do?mercenaryNo=<%=mc.getMercenaryNo()%>'">
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
					<td><%=mc.getRegDate() %></td>
					<%if(mc.getMercenaryWhether() == 0) {%>
					<td>모집중</td>
					<%}else if(mc.getMercenaryWhether() == 1) {%>
					<td>모집완료</td>
					<%} %>
					<td></td>
				</tr>
			<%} %>
		</table>
		<div class="page-navi"><%=pageNavi %></div>
		<%}else if( categoryName.equals("mercenaryRequest") ) {%>
		<table class="history-content table">
			<tr>
				<th style="width:5%">no.</th>
				<th style="width:10%">지역</th>
				<th style="width:25%">구장이름</th>
				<th style="width:25%">경기일</th>
				<th style="width:20%">신청내용</th>
				<th style="width:10%">신청결과</th>
				<th></th>
			</tr>
			<%for(MercenaryRequest mcReq : mcReqList) {%>
			<tr onclick="location.href='/mercenaryView.do?mercenaryNo=<%=mcReq.getMercenaryNo()%>'">
				<td><%=mcReq.getMercenaryNo() %></td>
				<%if(mcReq.getGameLocation().equals("seoul")) {%>
                    <td>서울</td>
                <%} else if(mcReq.getGameLocation().equals("incheon")) {%>
                 	<td>인천</td>
                <%} else if(mcReq.getGameLocation().equals("Gyeonggi")) {%>
                	<td>경기</td>
                <%} %>
				<td><%=mcReq.getGroundName() %></td>
				<td><%=mcReq.getGameDate()%> [ <%=mcReq.getGameShowTime() %> ]</td>
				<td><%=mcReq.getMercenaryRequestContent() %></td>
				<%if(mcReq.getMercenaryRequestResult().equals(m.getMemberId())) {%>
				<td> O </td>
				<%} else if(mcReq.getMercenaryRequestResult().equals("1")){%>
				<td> X </td>
				<%} else if(mcReq.getMercenaryRequestResult().equals("0")){%>
				<td> - </td>
				<%} %>
				<td><a href="/blackListFrm.do?memberNo=<%=m.getMemberNo()%>">신고</a></td>
			</tr>
			<%} %>
		</table>
		<div class="page-navi"><%=pageNavi %></div>
		<%} %>
	<%} else{%>
		<script>
			alert("올바르지 않은 접근입니다.");
			location.href="/";
		</script>
	<%} %>
	</div>
	<script>
		$(".history-menu>li>a").on("click", function(){
			    $(".history-menu>li>a").removeClass("active-tab");
			    $(this).addClass("active-tab");
			});

	</script>

	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>