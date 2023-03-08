<%@page import="semi.team.baro.blacklist.model.vo.Blacklist"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Blacklist> list = (ArrayList<Blacklist>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    int start = (int)request.getAttribute("start");
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
		<h2>신고관리</h2>
	</div>
	<table class="history-content table">
<<<<<<< HEAD
		<tr>
			<th style="width:5%">no.</th>
			<th style="width:25%">신고제목</th>
			<th style="width:10%">작성자</th>
			<th style="width:25%">작성일</th>
			<th style="width:10%">신고대상자</th>
			<th style="width:15%">신고등급변경</th>
			<th style="width:15%">신고상태</th>
			<th></th>
		</tr>
		<%for(int i=0;i<list.size();i++) {%>
			<%Blacklist b = list.get(i); %>
		<tr class="tr-1">
			<td><%=i+start %></td>
			<td>
				<a href="/blacklistView.do?blackNo=<%=b.getBlackNo() %>">
					<%=b.getBlackTitle() %>
				</a>
			<%=b.getBlackTitle() %></td>
			<td><%=b.getMemberId() %></td>
			<td><%=b.getRegDate() %></td>
			<td><%=b.getBlackMember() %></td>
			<td>
				<%if(b.getMemberLevel() == 1) {%>
				<select class="input-form">
					<option value="2"selected>정회원</option>
					<option value="3">블랙회원</option>
				</select>
				<%}else if(b.getMemberLevel() == 2) {%>
				<select class="input-form">
					<option value="2">정회원</option>
					<option value="3"selected>블랙회원</option>
				</select>
				<%} %>
			</td>
			<td>
				<%if(b.getBlackStatus() == 1) {%>
				<select class="input-form">
					<option value="1" selected>처리중</option>
					<option value="2">처리완료</option>
					<option value="3">처리취소</option>
				</select>
				<%}else if(b.getBlackStatus() == 2) {%>
				<select class="input-form">
					<option value="1">처리중</option>
					<option value="2" selected>처리완료</option>
					<option value="3">처리취소</option>
				</select>
				<%}else if(b.getBlackStatus() == 3) {%>
				<select class="input-form">
					<option value="1">처리중</option>
					<option value="2">처리완료</option>
					<option value="3" selected>처리취소</option>
				</select>
				<%} %>
			</td>
			<td>
				<button class="btn bc4 changeLevel">상태변경</button>
			</td>
		</tr>
		<%} %>
=======
			<tr>
				<th style="width:5%">no.</th>
				<th style="width:25%">신고제목</th>
				<th style="width:10%">작성자</th>
				<th style="width:25%">작성일</th>
				<th style="width:10%">신고대상자</th>
				<th style="width:20%">신고상태</th>
				<th></th>
			</tr>
			<%for(int i=0;i<list.size();i++) {%>
				<%Blacklist b = list.get(i); %>
			<tr class="tr-1" onclick="location.href='blacklistView.do?blackNo=<%=b.getBlackNo() %>'">
				<td><%=i+start %></td>
				<td>
					<a href="/blacklistView.do?blackNo=<%=b.getBlackNo() %>">
						<%=b.getBlackTitle() %>
					</a>
				<%=b.getBlackTitle() %></td>
				<td><%=b.getMemberId() %></td>
				<td><%=b.getRegDate() %></td>
				<td><%=b.getBlackMember() %></td>
				<td><%=b.getBlackStatus() %></td>
			</tr>
			<%} %>
>>>>>>> main
	</table>
	<div id="pageNavi"><%=pageNavi %></div>   
</div>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>