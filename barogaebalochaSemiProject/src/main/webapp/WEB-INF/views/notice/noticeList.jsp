<%@page import="semi.team.baro.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Notice> noticeList = (ArrayList<Notice>)request.getAttribute("noticeList");
    %>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<h1>공지사항</h1>
		<%//col-md-12%>
		<table class="notice-list-tbl table table-hover">
			<tr>
				<th class="col-md-1">No</th>
				<th class="col-md-1">Category</th>
				<th class="col-md-4">Title</th>
				<th class="col-md-3">Writer</th>
				<th class="col-md-2">WriteDate</th>
				<th class="col-md-1">Read</th>
			</tr>
		<%for(Notice notice : noticeList) { %>
			<tr>
				<td><%=notice.getNoticeNo() %></td>
				<td><%=notice.getNoticeCategory() %></td>
				<td class="notice-list-title"><a href="/noticeView.do?noticeNo=<%=notice.getNoticeNo()%>"><%=notice.getNoticeTitle() %></a></td>
				<td><%=notice.getMemberId() %></td>
				<td><%=notice.getRegDate() %></td>
				<td><%=notice.getReadCount() %></td>
			</tr>
		<%} %>
			
		</table>
		<div class="notice-btn-box">
			<a href="/noticeWriteForm.do" class="btn btn-outline-secondary btn-lg">공지사항 작성하기</a>
		</div>
	</div>
	<script type="text/javascript">
	
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>