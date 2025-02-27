<%@page import="semi.team.baro.matching.model.vo.Matching"%>
<%@page import="semi.team.baro.board.model.vo.Board"%>
<%@page import="semi.team.baro.blacklist.model.vo.Blacklist"%>
<%@page import="semi.team.baro.mercenary.model.vo.MercenaryRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Mercenary> mcList = ( ArrayList<Mercenary>)request.getAttribute("mcList");
    ArrayList<MercenaryRequest> mcReqList = (ArrayList<MercenaryRequest>)request.getAttribute("mcReqList");
    ArrayList<Blacklist> blaList = (ArrayList<Blacklist>)request.getAttribute("blaList");
    ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
    ArrayList<Matching> mchList = (ArrayList<Matching>)request.getAttribute("mchList");
    
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
			<li><a href="/historyBoard.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=board">게시판</a></li>
			<li><a href="/historyBlacklist.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=blacklist">신고내역</a></li>
		</ul>
		<%if( categoryName.equals("matching")) {%>
		<table class="history-content table">
			<tr>
				<th style="width:5%">no.</th>
				<th style="width:30%">제목</th>
				<th style="width:20%">작성일</th>
				<th style="width:10%">조회수</th>
				<th style="width:10%">모집상태</th>
			</tr>   
			<%for(Matching mch : mchList) {%>
				<tr onclick="location.href='/matchingView.do?reservationNo=<%=mch.getReservationNo() %>&memberNo=<%=m.getMemberNo() %>&matchingBoardNo=<%=mch.getMatchingBoardNo()%>'">
					<td><%=mch.getMatchingNo() %></td>
					<td><%=mch.getMatchingBoardTitle() %></td>
					<td style="color:#ccc"><%=mch.getRegDate() %></td>
					<td><%=mch.getReadCount() %>
					<%if(mch.getMatchingStatus() == 1) {%>
					<td>매칭중</td>
					<%}else if(mch.getMatchingStatus() == 2) {%>
					<td>매칭완료</td>
					<%}else{ %>
					<td>취소매치</td>
					<%} %>
				</tr>
			<%} %>
		</table>
		<div class="page-navi"><%=pageNavi %></div>
		<%}else if( categoryName.equals("mercenary") ){ %>			
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
					<%if(mc.getMercenaryWhether() == 1) {%>
					<td>모집중</td>
					<%}else if(mc.getMercenaryWhether() == 2) {%>
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
				<td><a href="/blackListFrm.do">신고</a></td>
			</tr>
			<%} %>
		</table>
		<div class="page-navi"><%=pageNavi %></div>
		<%} else if( categoryName.equals("board")) {%>
			<table class="history-content table">
			<tr>
				<th style="width:5%">no.</th>
				<th style="width:30%">제목</th>
				<th style="width:25%">첨부파일</th>
				<th style="width:20%">작성일</th>
				<th style="width:12%"></th>
				<th style="width:10%">조회수</th>
				<th></th>
			</tr>
			<%for(Board b : boardList) {%>
			<tr onclick="location.href='/freeBoardView.do?photoNo=<%=b.getPhotoNo()%>'">
				<td><%=b.getPhotoNo() %></td>
				<td><%=b.getPhotoTitle() %></td>
				<%if(b.getFilename() == null) {%>
				<td> - </td>
				<%} else{%>
				<td><span class="material-symbols-outlined" style="color:#AACB73">article</span></td>
				<%} %>
				<td><%=b.getRegDate() %></td>
				<td></td>
				<td><%=b.getReadCount() %></td>
			</tr>
			<%} %>
			</table>
			<div class="page-navi"><%=pageNavi %></div>
		<%} else if( categoryName.equals("blacklist")){%>
			<table class="history-content table">
			<tr>
				<th style="width:5%">no.</th>
				<th style="width:10%">신고대상</th>
				<th style="width:25%">제목</th>
				<th style="width:25%">첨부파일</th>
				<th style="width:20%">작성일</th>
				<th style="width:10%">처리상태</th>
				<th></th>
			</tr>
			<%for(Blacklist bl : blaList) {%>
			<tr onclick="location.href='/blacklistVIew.do?blackNo=<%=bl.getBlackNo()%>'">
				<td><%=bl.getBlackNo() %></td>
				<td><%=bl.getBlackMember() %></td>
				<td><%=bl.getBlackTitle() %></td>
				<%if(bl.getBlackFilepath() == null) {%>
				<td> - </td>
				<%} else{%>
				<td><span class="material-symbols-outlined" style="color:#AACB73">article</span></td>
				<%} %>
				<td><%=bl.getRegDate() %></td>
				<%if(bl.getBlackStatus() == 1){ %>
				<td>처리중</td>
				<%}else if(bl.getBlackStatus() == 2) {%>
				<td>처리완료</td>
				<%}else if(bl.getBlackStatus() == 3){ %>
				<td>처리취소</td>
				<%} %>
				<td></td>
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