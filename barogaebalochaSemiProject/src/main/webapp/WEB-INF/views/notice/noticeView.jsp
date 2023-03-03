<%@page import="semi.team.baro.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Notice notice = (Notice)request.getAttribute("notice");
    %>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
<h3><a href="/noticeList.do">공지사항</a></h3>
	<table class="notice-view table" id="noticeView">
		<tr>
			<th class="col-md-2"><%=notice.getNoticeCategory() %></th>
			<td class="col-md-7"><%=notice.getNoticeTitle() %></td>
			<th class="col-md-1">조회수</th>
			<td class="col-md-2"><%=notice.getReadCount() %></td>
		</tr>
		<tr>
			<td colspan="2"></td>
			<th class="">작성일</th>
			<td class=""><%=notice.getRegDate() %></td>
		</tr>
		<tr>
			<td colspan="4"><div class="noticeViewContent"><%=notice.getNoticeContent() %></div></td>
		</tr>
	</table>
	<div class="notice-view-btnbox">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		<a class="btn bc44" href="/noticeUpdateForm.do?noticeNo=<%=notice.getNoticeNo()%>">Update</a>
		<button class="btn bc44" onclick="noticeRemove(<%=notice.getNoticeNo()%>)">remove</button>
	</div>
</div>
<script type="text/javascript">
	function noticeRemove(noticeNo) {
		if(confirm("게시글을 삭제 할까요?")) {
			location.href="/removeNotice.do?noticeNo="+noticeNo;
		}
	}
</script>
<%@include file="/WEB-INF/views/common/footer.jsp" %>