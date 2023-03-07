<%@page import="semi.team.baro.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Board board = (Board)request.getAttribute("board");
    %>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<style>
	.boardViewContent { min-height: 550px }
</style>
<div class="page-content">
<h3><a href="/freeBoardList.do?boardPage=1">자유게시판</a></h3>
	<table class="table" id="">
		<tr>
			<td class="col-md-2"><%=board.getMemberId() %></td>
			<td class="col-md-7"><%=board.getPhotoTitle() %></td>
			<th class="col-md-1">조회수</th>
			<td class="col-md-2"><%=board.getReadCount() %></td>
		</tr>
		<tr>
			<td colspan="2"></td>
			<th class="">작성일</th>
			<td class=""><%=board.getRegDate() %></td>
		</tr>
		<tr>
			<td colspan="4"><div class="boardViewContent"><%=board.getPhotoContent() %></div></td>
		</tr>
		<%if(board.getFilename() != null) { %>
		<tr>
			<td>첨부 파일</td>
			<td><a href="freeBoardFileDownLoad.do?photoNo=<%=board.getPhotoNo()%>"><%=board.getFilename() %></a></td>
			<td colspan="2"></td>
		</tr>
		<%} %>
	</table>
	<%if(m != null && m.getMemberNo() ==  board.getMemberNo()) { %>
	<div class="update-remove-btnbox">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		<a class="btn bc44" href="/freeBoardUpdateForm.do?photoNo=<%=board.getPhotoNo()%>">수정하기</a>
		<button class="btn bc44" onclick="freeBoardRemove(<%=board.getPhotoNo()%>)">삭제하기</button>
	</div>
 	<%} %>
</div>
<script type="text/javascript">
	function freeBoardRemove(photoNo) {
		if(confirm("게시글을 삭제 할까요?")) {
			location.href="/removeFreeBoard.do?photoNo="+photoNo;
		}
	}
</script>
<%@include file="/WEB-INF/views/common/footer.jsp" %>