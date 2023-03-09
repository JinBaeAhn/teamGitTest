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
	.update-remove-btnbox { margin: 30px 50px; }
	.inputReCommentBox {
		margin: 0px 0px 30px;
		display: none;
	}
	.comment-link { text-align: right; }
	.free-board-Recomment { border-top: none; }
	.comment-view { border-top: 1px solid #ddd; }
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
	<div class="commentBox" id="commentBox">
			<%for(BoardComment comment : boardCommentList) { %>
			<input type="hidden" name="updateBoardCommentWriter" value="<%=comment.getBoardCommentWriter()%>">
			<input type="hidden" name="updateBoardCommentSelfReference" value="0">
			<input type="hidden" name="modifyMyNo" value="<%=comment.getBoardCommentNo()%>">
			<table class="table comment-view">
				<tr>
					<td class="comment-info col-md-2">
						<span class="material-icons">account_box</span><br>
						<span>작성자&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;<%=comment.getMemberId() %></span>
					</td>
					<td class="comment-content col-md-8">
						<input type="hidden" value="<%=comment.getBoardCommentWriter()%>">
						<p><%=comment.getBoardCommentContent()%></p>
						<textarea name="boardCommentContent" class="input-form" style="min-height:50px; display:none;"><%=comment.getBoardCommentContent() %></textarea>
					</td>
					<td class="comment-link">
						<span><%=comment.getBoardCommentDate()%></span><br>
						<a href="javascript:void(0)" class="recShow">답글달기</a>
						<%if(m != null) { %>
							<%if(m.getMemberId().equals(comment.getMemberId())) { %>
							<a href="javascript:void(0)" onclick="modifyComment(this,<%=comment.getBoardCommentNo()%>)">수정</a>
							<a href="javascript:void(0)" onclick="deleteComment(this,<%=comment.getBoardCommentNo()%>)">삭제</a>
							<%} %>
						<%} %>
					</td>
				</tr>
			</table>
			<!-- 댓글답글 출력 -->
			<%for(BoardComment reComment : boardReCommentList) { %>
			<input type="hidden" name="updateBoardCommentWriter" value="<%=reComment.getBoardCommentWriter()%>">
			<input type="hidden" name="updateBoardCommentSelfReference" value="<%=reComment.getBoardCommentNo()%>">
			<input type="hidden" name="modifyMyNo" value="<%=comment.getBoardCommentNo()%>">
				<%if(reComment.getBoardCommentSelfReference() == comment.getBoardCommentNo()) { %>
					<table class="table comment-view posting-comment reply">
						<tr>
						<td></td>
							<td class="comment-info col-md-2">
								<span class="material-icons">subdirectory_arrow_right</span><br>
								<span>작성자&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;<%=reComment.getMemberId()%></span>
							</td>
							<td class="comment-content col-md-7">
								<p><%=reComment.getBoardCommentContent()%></p>
								<textarea name="ncContent" class="input-form" style="min-height:50px;display:none;"><%=reComment.getBoardCommentContent() %></textarea>
							</td>
							<td class="comment-link">
								<span><%=reComment.getBoardCommentDate()%></span><br>
								<%if( m != null && m.getMemberId().equals(reComment.getMemberId())) { %>
								<a href="javascript:void(0)" onclick="modifyComment(this,<%=reComment.getBoardCommentNo()%>)">수정</a>
								<a href="javascript:void(0)" onclick="deleteComment(this,<%=reComment.getBoardCommentNo()%>)">삭제</a>
								<%} %>
							</td>
						</tr>
					</table>
				<%} %>
			<%} %>
			<!-- 댓글답글 입력 -->
			<%if(m != null){ %>
			<div class="inputReCommentBox inputCommentBox">
				<form action="#" method="post">
					<input type="hidden" name="boardCommentWriter" value="<%=m.getMemberNo()%>">
					<input type="hidden" name="boardCommentReference" value="<%=board.getPhotoNo()%>">
					<table>
						<tr class="free-board-comment free-board-Recomment">
							<th class="col-md-1"><span class="material-icons">account_box</span>_ <%=m.getMemberId() %></th>
							<td class="col-md-10"><textarea name="boardCommentContent" class="comment-content form-control"></textarea></td>
							<th class="btn-box col-me-1"><input type="hidden" name="boardCommentSelfReference" value="<%=comment.getBoardCommentNo()%>"><button type="button" onclick="freeBoardCommentWrite(this)" class="btn btn-outline-primary">등록</button></th>
						</tr>
					</table>
				</form>
			</div>
			<%} else { %>
			<div class="inputReCommentBox inputCommentBox">
				<form action="#" method="post">
					<input type="hidden" name="boardCommentWriter" value="-1000">
					<input type="hidden" name="boardCommentReference" value="<%=board.getPhotoNo()%>">
					<table>
						<tr class="free-board-comment free-board-Recomment">
							<th class="col-md-1"><span class="material-icons">account_box</span>_ 익명</th>
							<td class="col-md-10"><textarea name="boardCommentContent" class="comment-content form-control"></textarea></td>
							<th class="btn-box col-me-1"><input type="hidden" name="boardCommentSelfReference" value="<%=comment.getBoardCommentNo()%>"><button type="button" onclick="freeBoardCommentWrite(this)" class="btn btn-outline-primary">등록</button></th>
						</tr>
					</table>
				</form>
			</div>
			<% } %>
			<%}//댓글출력 for %>
	</div>
	<!-- 댓글 입력 -->
	<%if(m != null ){ %>
		<form action="/freeBoardCommentWrite.do" method="post">
			<input type="hidden" name="boardCommentWriter" value="<%=m.getMemberNo()%>">
			<input type="hidden" name="boardCommentReference" value="<%=board.getPhotoNo()%>">
			<table>
				<tr class="free-board-comment">
					<th class="col-md-1"><span class="material-icons">account_box</span>_ <%=m.getMemberId() %></th>
					<td class="col-md-10"><textarea id="boardCommentContent" name="boardCommentContent" class="comment-content form-control"></textarea></td>
					<th class="btn-box col-me-1"><input type="hidden" name="boardCommentSelfReference" value="0"><button type="button" onclick="freeBoardCommentWrite(this)" class="btn btn-outline-primary">등록</button></th>
				</tr>
			</table>
		</form>
		<%} else {%>
		<form action="/freeBoardCommentWrite.do" method="post">
			<input type="hidden" name="boardCommentWriter" value="-10">
			<input type="hidden" name="boardCommentReference" value="<%=board.getPhotoNo()%>">
			<table>
				<tr class="free-board-comment">
					<th class="col-md-1"><span class="material-icons">account_box</span>_ 익명</th>
					<td class="col-md-10"><textarea id="boardCommentContent" name="boardCommentContent" class="comment-content form-control"></textarea></td>
					<th class="btn-box col-me-1"><input type="hidden" name="boardCommentSelfReference" value="0"><button type="button" onclick="freeBoardCommentWrite(this)" class="btn btn-outline-primary">등록</button></th>
				</tr>
			</table>
		</form>
		<%} %>
	<%if(m != null && (m.getMemberNo() ==  board.getMemberNo() || m.getMemberLevel() == 1 )) { %>
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
	function freeBoardCommentWrite(button) {
		const commentBox = $(button).parent().prev().children("[name=boardCommentContent]");
		const boardCommentContent = commentBox.val();
		const boardCommentReference = <%=board.getPhotoNo()%>;
		let boardCommentWriter = -1000;
		<%if (m != null) {%>
		boardCommentWriter = <%=m.getMemberNo()%>;
		<% } %>
		const boardCommentSelfReference = $(button).prev().val();
		$.ajax({
			url : "/freeBoardCommentWrite.do",
			type : "POST",
			data : { boardCommentContent : boardCommentContent, boardCommentReference : boardCommentReference, boardCommentWriter : boardCommentWriter, boardCommentSelfReference : boardCommentSelfReference },
			dataType : "JSON",
			success : function(json) {
				console.log("데이터 전송 성공" + json + " : " + boardCommentSelfReference)
				commentBox.val("");
				reflashCommentBox();
			},
			error: function() {
				alert("서버오류 : 댓글 입력 실패")
			},
			complete() {
				console.log("서버 순회완료")
			}
		})
	}
	$(".recShow").on("click",function() {
		const index = $(".recShow").index(this);
		if($(this).text() == "답글달기"){
			$(this).text("취소");
		} else {
			$(this).text("답글달기");
		}
		$(".inputReCommentBox").eq(index).toggle();
		$(".inputReCommentBox").eq(index).find("textarea").focus();
	});
	function modifyComment(obj, boardCommentNo){
		//화면에 있던 댓글(p태그) 숨기기
		$(obj).parent().prev().children("p").hide();
		//숨긴 textarea 꺼내기
		$(obj).parent().prev().children("textarea").show();
		//수정 -> 수정완료 , 삭제 -> 수정취소
		$(obj).text("수정완료");
		$(obj).attr("onclick","modifyComplete(this,"+boardCommentNo+")");
		$(obj).next().text("수정취소");
		$(obj).next().attr("onclick","modifyCancel(this,"+boardCommentNo+")");
		//답글달기 삭제
		$(obj).prev().hide();
	}
	function modifyCancel(obj, boardCommentNo) {
		$(obj).parent().prev().children("textarea").hide();
		$(obj).parent().prev().children("p").show();
		$(obj).prev().text("수정");
		$(obj).prev().attr("onclick","modifyComment(this,"+boardCommentNo+")");
		$(obj).text("삭제");
		$(obj).attr("onclick","deleteComment(this,"+boardCommentNo+")");
		$(obj).prev().prev().show();
	}
	function modifyComplete(obj, boardCommentNo) {
		const modifyCommentContent = $(obj).parent().prev().children("textarea").val();
		const updateBoardCommentReference = <%=board.getPhotoNo()%>;
		const updateBoardCommentWriter = $(obj).parents().prevAll("[name=updateBoardCommentWriter]").val();
		const updateBoardCommentSelfReference = $(obj).parents().prevAll("[name=updateBoardCommentSelfReference]").val();
		const modifyMyNo = $(obj).parents().prevAll("[name=modifyMyNo]").val();
		
		alert(updateBoardCommentSelfReference);
		
		$.ajax({
			url : "/freeBoardCommentUpdate.do",
			type : "POST",
			data : { modifyCommentContent : modifyCommentContent, updateBoardCommentReference : updateBoardCommentReference, updateBoardCommentWriter : updateBoardCommentWriter, updateBoardCommentSelfReference : updateBoardCommentSelfReference, modifyMyNo : modifyMyNo },
			dataType : "JSON",
			success : function(json) {
				reflashCommentBox();
			},
			error: function() {
				alert("서버오류 : 댓글 수정 실패")
			},
			complete() {
				console.log("댓글수정 서버 순회완료")
			}
		})
	}
	function deleteComment(obj, boardCommentNo) {
		if(confirm("댓글을 삭제하시겠습니까?")) {
			$.ajax({
				url : "/removeFreeBoardComment.do",
				type : "POST",
				data : { boardCommentNo : boardCommentNo },
				dataType : "JSON",
				success : function(json) {
					console.log("데이터 전송 성공 : " + json)
					reflashCommentBox();
				},
				error : function() {
					alert("서버오류 : 댓글 삭제 실패")
				},
				complete() {
					console.log("서버 순회완료")
				}
			})
			/* location.href = "removeFreeBoardComment.do?boardCommentNo="+boardCommentNo+"&boardCommentReference="+boardCommentReference; */
		}
	}
	function reflashCommentBox() {
		/* let commentBox = $("#commentBox").empty(); */
		location.reload();
	}
</script>
<%@include file="/WEB-INF/views/common/footer.jsp" %>