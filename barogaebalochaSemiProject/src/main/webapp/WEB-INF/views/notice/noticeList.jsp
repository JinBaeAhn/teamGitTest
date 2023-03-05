<%@page import="semi.team.baro.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Notice> noticeList = (ArrayList<Notice>)request.getAttribute("noticeList");
    	String pageNavigation = (String)request.getAttribute("pageNavigation");
    	int start = (int)request.getAttribute("start");
    	
    %>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<h1>공지사항</h1>
		<%//col-md-12%>
		<table class="notice-list-tbl table table-hover">
			<tr>
				<th class="col-md-1">번호</th>
				<th class="col-md-1">카테고리</th>
				<th class="col-md-4">제목</th>
				<th class="col-md-3">작성자</th>
				<th class="col-md-2">작성일</th>
				<th class="col-md-1">조회수</th>
			</tr>
		<%for(int i=0;i<noticeList.size();i++) { %>
			<tr>
			<%Notice notice = noticeList.get(i); %>
				<td><%=start+i %></td>
				<td><%=notice.getNoticeCategory() %></td>
				<td class="notice-list-title"><a href="/noticeView.do?noticeNo=<%=notice.getNoticeNo()%>"><%=notice.getNoticeTitle() %></a></td>
				<td><%=notice.getMemberId() %></td>
				<td><%=notice.getRegDate() %></td>
				<td><%=notice.getReadCount() %></td>
			</tr>
		<%} %>
		</table>
		<%if(m != null && m.getMemberLevel() < 2) { %>
			<div class="notice-btn-box">
				<a href="/noticeWriteForm.do" class="btn btn-outline-secondary btn-lg">공지사항 작성하기</a>
			</div>
		<%} %>
		<%=pageNavigation %>
	</div>
	<script type="text/javascript">
	
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>