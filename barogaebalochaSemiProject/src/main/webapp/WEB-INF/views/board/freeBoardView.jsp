<%@page import="semi.team.baro.board.model.vo.BoardComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="semi.team.baro.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Board board = (Board)request.getAttribute("board");
   	 	ArrayList<BoardComment> boardCommentList = (ArrayList<BoardComment>)request.getAttribute("boardCommentList");
		ArrayList<BoardComment> boardReCommentList = (ArrayList<BoardComment>)request.getAttribute("boardReCommentList");
    %>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<style>
	.boardViewContent { min-height: 550px }
	li { list-style: none; }
	.comment-write { display: flex; }
	.free-board-comment { box-sizing:border-box; width: 1200px; height: 80px ; border-top: 1px solid #ddd;  border-bottom: 1px solid #ddd; display: flex;  justify-content: space-between; align-items: center; }
	.free-board-comment th:nth-child(1)  { display: flex; justify-content: center; }
	.free-board-comment .btn-box { width: 100px; display: flex; justify-content: center; }
	.free-board-comment [name = boardCommentContent] {}
</style>
<div class="page-content">
<h3><a href="/freeBoardList.do?boardPage=1">자유게시판</a></h3>
	<table class="table">
		<tr>
			<td class="col-md-2">작성자&nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;<%=board.getMemberId() %></td>
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
		<tr>
			<td>첨부 파일</td>
				<td>
					<%if(board.getFilename() != null) { %>
					<a href="freeBoardFileDownLoad.do?photoNo=<%=board.getPhotoNo()%>"><%=board.getFilename() %></a>
					<%} %>
				</td>
			<td colspan="2"></td>
		</tr>
	</table>
	<!-- 댓글 출력 -->
	<div class="commentBox">
			<%for(BoardComment comment : boardCommentList) { %>
			<ul class="posting-comment">
				<li><span class="material-icons">account_box</span></li>
				<li>
					<p class="comment-info">
						<span>작성자&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;<%=comment.getMemberId() %></span>
						<span><%=comment.getBoardCommentDate() %></span>
					</p>
					<p class="comment-content"><%=comment.getBoardCommentContent()%></p>
					<textarea name="ncContent" class="input-form" style="min-height:96px; display:none;"><%=comment.getBoardCommentContent() %></textarea>
					<p class="comment-link">
						<%if(m != null) { %>
						<a href="javascript:void(0)" class="recShow">답글달기</a>
							<%if(m.getMemberId().equals(comment.getMemberId())) { %>
								<a href="javascript:void(0)" onclick="modifyComment(this,<%=comment.getBoardCommentNo()%>,<%=board.getPhotoNo()%>)">수정</a>
								<a href="javascript:void(0)" onclick="deleteComment(this,<%=comment.getBoardCommentNo()%>,<%=board.getPhotoNo()%>)">삭제</a>
							<%} %>
						<%} %>
					</p>
				</li>
			</ul>
			
			<!-- 댓글답글 출력 -->
			<%for(BoardComment reComment : boardReCommentList) { %>
				<%if(reComment.getBoardCommentSelfReference() == comment.getBoardCommentNo()) { %>
					<ul class="posting-comment reply">
						<li><span class="material-icons">account_box</span><span class="material-icons">subdirectory_arrow_right</span></li>
						<li>
							<p class="comment-info">
								<span><%=reComment.getMemberId() %></span>
								<span><%=reComment.getBoardCommentDate() %></span>
							</p>
							<p class="comment-content"><%=reComment.getBoardCommentContent() %></p>
							<textarea name="ncContent" class="input-form" style="min-height:96px;display:none;"><%=reComment.getBoardCommentContent() %></textarea>
							<p class="comment-link">
								<%if(m != null && m.getMemberId().equals(reComment.getMemberId())) { %>
									<a href="javascript:void(0)" onclick="modifyComment(this,<%=reComment.getBoardCommentNo()%>,<%=board.getPhotoNo()%>)">수정</a>
									<a href="javascript:void(0)" onclick="deleteComment(this,<%=reComment.getBoardCommentNo()%>,<%=board.getPhotoNo()%>)">삭제</a>
								<%} %>
							</p>
						</li>
					</ul>
				<%} %>
			<%} %>
			<!-- 댓글답글 입력 -->
				<%if(m != null){ %>
					<form action="/freeBoardCommentWrite.do" method="post">
					<input type="hidden" name="boardCommentWriter" value="<%=m.getMemberId()%>">
					<input type="hidden" name="boardCommentReference" value="<%=board.getPhotoNo()%>">
					<input type="hidden" name="boardCommentSelfReference" value="<%=comment.getBoardCommentSelfReference()%>">
					<table>
						<tr class="free-board-comment">
							<th class="col-md-1"><span class="material-icons">account_box</span>_ <%=m.getMemberId() %></th>
							<td class="col-md-10"><textarea name="boardCommentContent" class="comment-content form-control"></textarea></td>
							<th class="btn-box col-me-1"><button type="submit" class="btn btn-outline-primary">등록</button></th>
						</tr>
					</table>
				</form>
				<%} %>
			<%}//댓글출력 for %>
		</div>
	<!-- 댓글 입력 -->
	<%if(m != null ){ %>
				<form action="/freeBoardCommentWrite.do" method="post">
					<input type="hidden" name="boardCommentWriter" value="<%=m.getMemberId()%>">
					<input type="hidden" name="boardCommentReference" value="<%=board.getPhotoNo()%>">
					<input type="hidden" name="boardCommentSelfReference" value="0">
					<table>
						<tr class="free-board-comment">
							<th class="col-md-1"><span class="material-icons">account_box</span>_ <%=m.getMemberId() %></th>
							<td class="col-md-10"><textarea name="boardCommentContent" class="comment-content form-control"></textarea></td>
							<th class="btn-box col-me-1"><button type="submit" class="btn btn-outline-primary">등록</button></th>
						</tr>
					</table>
				</form>
		<%} else {%>
			
		<%} %>
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