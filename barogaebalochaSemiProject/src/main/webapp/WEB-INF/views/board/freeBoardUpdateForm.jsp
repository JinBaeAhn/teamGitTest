<%@page import="semi.team.baro.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Board board = (Board)request.getAttribute("board");
    %>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/summernote/summernote-lite.css">
<style type="text/css">
	#free-board td, #free-board th {
		border: 1px solid #ddd;
		text-align: center;
	}
	#free-board .l1 { height: 30px; line-height: 50px; }
	#free-board .l1 .input-form { height: 50px; line-height: 50px; }
	#free-board .l2 { height: 30px; line-height: 30px; }
	#free-board .l3 td { text-align: left; }
	.free-board-btn { display: flex; justify-content: end; margin: 20px 0 40px; }
</style>
<div class="page-content">
	<form action="/freeBoardUpdate.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="photoNo" value="<%=board.getPhotoNo()%>">
			<input type="hidden" name="status" value="stay">
			<table class="table" id="free-board">
				<tr class="l1">
					<th>Title</th>
					<td colspan="3"><input type="text" name="photoTitle" class="input-form" value="<%=board.getPhotoTitle()%>"></td>
				</tr>
				<tr class="l2">
					<th>Writer</th>
					<td><%=m.getMemberId() %><input type="hidden" name="memberNo" value="<%=m.getMemberNo()%>"></td>
					<th>File Upload</th>
					<td>
					<%if(board.getFilepath() == null) { %>
						<input type="file" name="upFile">
						<%} else {%>
							<span class="delFile"><%=board.getFilename()%> </span> 
							<button type="button" class="btn btn-outline-secondary delFile">remove</button>
							<input type="file" name="upFile" style="display:none">
							<input type="hidden" name="oldFilename" value="<%=board.getFilename()%>">
							<input type="hidden" name="oldFilepath" value="<%=board.getFilepath()%>">
						<%} %>
					</td>
				</tr>
				<tr class ="l3">
					<td colspan="4"><textarea placeholder="내용을 입력하세요" id="boardContent" rows="20" name="photoContent" class="form-control"><%=board.getPhotoContent() %></textarea></td>
				</tr>
			</table>
			<div class="free-board-btn">
				<a href="/freeBoardList.do?boardPage=1" class="btn btn-outline-secondary">취소</a>
				<button type="submit" class="btn btn-outline-secondary">수정하기</button>
			</div>
	</form>
</div>
<script type="text/javascript">
	$("button.delFile").on("click",function() {
		$(".delFile").hide();
		$(this).next().show();
		$("[name=status]").val("delete");
	});
	$("#boardContent").summernote({
		height : 550,
		lang : "ko-KR",
		callbacks : {
			onImageUpload : function(files) {
				uploadImage(files[0],this)
			}
		}
	});
	function uploadImage(file, editor) {
		//ajax를 통해서 서버에 이미지를 업로드
		//업로드 된 이미지의 경로를 받아오는 역할
		//받아온 이후 -> editor에 이미지 경로를 전달해서 화면에 표현
	
		//form태그 역할
		const form = new FormData();
		form.append("file", file);
		$.ajax({
			url : "/uploadImage.do",
			type : "POST",
			data : form,
			processData : false, // processData : false     데이터가 문자열로 전송하는게 ajax 기본값, 기본값을 제거하는 속성
			contentType : false, // contentType : false     파일 전송을 위해 enctype 기본값을 제거하는 속성
			success : function(data) {
				console.log(data);
				$(editor).summernote("insertImage",data);
			}
		});
	}
</script>
<%@include file="/WEB-INF/views/common/footer.jsp" %> 
