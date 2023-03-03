<%@page import="semi.team.baro.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Notice> noticeList = (ArrayList<Notice>)request.getAttribute("noticeList");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<h1>Notice List</h1>
		<table class="notice-tbl col-md-12 table">
			<tr>
				<th class="col-md-1">No</th>
				<th class="col-md-5">Title</th>
				<th class="col-md-3">Writer</th>
				<th class="col-md-2">WriteDate</th>
				<th class="col-md-1">Read</th>
			</tr>
			
		<a href="/noticeWriteForm.do">공지사항</a>
		<%for(Notice notice : noticeList) { %>
			<tr>
				<td><%=notice.getNoticeNo() %></td>
				<td><%=notice.getNoticeTitle() %></td>
				<td><%=notice.getMemberId() %></td>
				<td><%=notice.getRegDate() %></td>
				<td><%=notice.getReadCount() %></td>
			</tr>
		<%} %>
			
		</table>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>