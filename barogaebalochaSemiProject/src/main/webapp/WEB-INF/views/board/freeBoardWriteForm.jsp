<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
	<table class="table">
		<tr>
			<th></th>
		</tr>
	</table>
	
	<form action="/noticeWrite.do" method="post" enctype="multipart/form-data">
			<table class="tbl" id="noticeWrite">
				<tr class="tr-1">
					<th class="td-3">Title</th>
					<td colspan="3">
						<input type="text" name="noticeTitle" class="input-form">
					</td>
				</tr>
				<tr class="tr-1">
					<th class="td-3">Writer</th>
					<td>
						<%=m.getMemberId() %>
						<input type="hidden" name="noticeWriter" value="<%=m.getMemberId() %>">
					</td>
					<th class="td-3">File Upload</th>
					<td><input type="file" name="upFile"></td>
				</tr>
				<tr class="tr-1">
					<td colspan="4" style="text-align:left">
						<textarea id="noticeContent" name="noticeContent" class="input-form"></textarea>
					</td>
				</tr>
			</table>
			<button type="submit" class="btn bc1 bs4">write notice</button>
	</form>
		
</div>
<%@include file="/WEB-INF/views/common/footer.jsp" %>