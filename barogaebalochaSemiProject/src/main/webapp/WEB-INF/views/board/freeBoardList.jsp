<%@page import="semi.team.baro.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	    ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
		String pageNavigation = (String)request.getAttribute("pageNavigation");
		int start = (int)request.getAttribute("start");
    %>
    
<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
	<h1>자유게시판</h1>
	
	<table class="table">
		<tr>
			<th class="col-md-1">글번호</th>
			<th class="col-md-5">제목</th>
			<th class="col-md-3">작성자</th>
			<th class="col-md-2">작성일</th>
			<th class="col-md-1">조회수</th>
		</tr>
		<%for(int i=0;i<boardList.size();i++) { %>
			<%Board board = boardList.get(i); %>
			<tr>
				<td><%=start+i%></td>
				<td><%=board.getPhotoTitle() %></td>
				<td><%=board.getMemberId() %></td>
				<td><%=board.getRegDate() %></td>
				<td><%=board.getReadCount() %></td>
			</tr>
		<%} %>
	</table>
	<div class="free-board-btnbox">
		<a href="javascript:void(0)" id="boardWriteBtn" onclick="writeOk('<%=m%>')" class="btn btn-outline-secondary btn-lg">글쓰기</a>
	</div>
	<%=pageNavigation %>
</div>
<script type="text/javascript">
	function writeOk(member) {
		if(member == 'null') {
			alert("로그인 후 작성 가능합니다")
		} else {
			console.log("test");
			location.href = "/freeBoardWriteForm.do";
		}
	}
</script>
<%@include file="/WEB-INF/views/common/footer.jsp" %>