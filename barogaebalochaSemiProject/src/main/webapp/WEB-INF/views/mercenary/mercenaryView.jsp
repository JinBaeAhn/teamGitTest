<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Mercenary mc = (Mercenary)request.getAttribute("mc");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>용병모집 상세보기</title>
<style>
    .tbl {
    	margin: 50px auto;
	    width: 100%;
	    border-spacing: 0px;
	    border-collapse: collapse;
    }
    .tbl th,.tbl td {
        padding: 10px;
        text-align: center;
    } 
    #mercenaryView th, #mercenaryView td{
        border: 1px solid #ccc;
    }
    #mercenaryView th{
        background-color: #181818;
        color: #fcfcfc;
    }
    .mercenary-content{
    	text-align: left;
    	min-height: 300px;
    }
    .back-link>.bs4{
    	padding: 10px;
    }
    .inputCommentBox li{
    	list-style-type: none;
    }
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
			<h2>용병모집</h2>
			<hr>
		</div>
		<table class="tbl" id="mercenaryView">
			<tr>
				<th>구장이름</th>
				<td colspan="2"><%=mc.getGroundName() %></td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="2">서울시 영등포구</td>
			</tr>
			<tr>
				<th>경기일</th>
				<td><%=mc.getGameDate() %></td>
				<td><%=mc.getGameShowTime() %></td> 
			</tr>
			<tr>
				<th>작성자</th>
				<th>참가비</th>
				<th>실력</th>
			</tr>
			<tr>
				<td><%=mc.getMemberId() %></td>
				<td><%=mc.getMercenaryPay() %> 원</td>
				<%if(mc.getLevel() == 1){ %>
					<td>최상</td>
				<%}else if(mc.getLevel() == 2) {%>
					<td>상</td>
				<%}else if(mc.getLevel() == 3) {%>
					<td>중</td>
				<%}else if(mc.getLevel() == 4) {%>
					<td>하</td>
				<%}else if(mc.getLevel() == 5) {%>
					<td>최하</td>
				<%} %>
				
			</tr>
			<tr>
				<th colspan="3">상세내용</th>
			</tr>
			<tr>
				<td colspan="3">
					<div class="mercenary-content">
						<%=mc.getMercenaryContent() %>
					</div>
				</td>
			</tr>
			<tr>
				<th colspan="3">
					<div class="back-link">
						<a href="/mercenaryList.do" class="btn1 bs4 bc1">목록으로</a>
					</div>
				</th>
			</tr>	
		</table>

		<div class="inputCommentBox">
			<form action="/insertNoticeComment.do" method="post">
				<ul>
					<li>
						<span class="material-icons">account_box</span>
					</li>
					<li>
						<input type="hidden" name="mercenaryRef" value="<%=mc.getMercenaryNo() %>">
						<input type="hidden" name="ncRef" value="0">
						<textarea name="ncContent" class="input-form"></textarea>
					</li>
					<li>
						<button type="submit" class="btn1 bc1 bs4">등록</button>
					</li>
				</ul>
			</form>
		</div>	
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>