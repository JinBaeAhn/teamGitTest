<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<script src="/summernote/summernote-lite.js"></script>
	<script src="/summernote/lang/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="/summernote/summernote-lite.css">
	<div class="page-content">
		<h1>공지사항 작성</h1>
		<form action="/noticeWrite.do" method="post" class="row g-3">
		
		
		<!-- 수정필요부분 1 -->
			<input type="hidden" name="memberNo" value="0">
			
			
  			<div class="col-md-8">
				<input type="text" name="noticeTitle" class="form-control" placeholder="제목을 입력해주세요." required>
			</div>
			<div class="col-md-4">
				<select class="form-select" name="noticeCategory" aria-label="Default select example">
					<option value="notice" selected>공지사항</option>
					<option value="event">이벤트</option>
					<option value="Test">TEST</option>
				</select>
			</div>
			<div class="form-group"><textarea class="form-control" name="noticeContent" id="noticeContent" rows="20"placeholder="내용을 입력해주세요" required></textarea></div>
			<button type="submit" class="btn btn-secondary mb-3">제출하기</button>
		</form>
	</div>
	<script type="text/javascript">
		$("#noticeContent").summernote({
			height : 400,
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