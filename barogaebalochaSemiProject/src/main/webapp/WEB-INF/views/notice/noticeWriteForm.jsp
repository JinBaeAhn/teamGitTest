<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>

<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<h1>Notice Write  Form</h1>
		<form action="/noticeWrite.do" method="post" class="row g-3">
			<input type="hidden" name="noticeNo" value="공지사항번호">
			<input type="hidden" name="memberNo" value="로그인회원번호">
			<input type="hidden" name="" value="">
			<input type="hidden" value="">
  			<div class="col-md-8">
				<input type="text" name="noticeTitle" class="form-control" placeholder="제목을 입력해주세요." required>
			</div>
			<div class="col-md-4">
				<select class="form-select" name="noticeCategory" aria-label="Default select example">
					<option value="notice" selected>공지사항</option>
					<option value="event">이벤트</option>
				</select>
			</div>
			<div class="form-group"><textarea class="form-control" name="noticeContent" rows="20"placeholder="내용을 입력해주세요" required></textarea></div>
			<button type="submit" class="btn btn-secondary mb-3">제출하기</button>
		</form>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>