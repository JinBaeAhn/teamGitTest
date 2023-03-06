<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 	.history-menu{
 		overflow: hidden;
 	}
	.history-menu>li{
		float: left;
		list-style-type: none;
		margin-right: 30px;
		margin-bottom: 20px;
		cursor: pointer;
	}
	.active-tab{
		color: #AACB73;
	}
	.history-content th, .history-content td{
		text-align: center;
	}
	.history-content tr:not(tr:first-child):hover{
		background-color: #fcfcfc;
	}
	.history-content td{
		cursor:pointer;
	}
	.history-content td>a:hover{
		color: red;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
			<h2>HISTORY</h2>
		</div>
		<ul class="history-menu">
			<li>MATCHING</li>
			<li>용병모집</li>
			<li>용병신청</li>
			<li>게시판</li>
			<li>신고내역</li>
		</ul>
		<table class="history-content table">
			<tr>
				<th class="col-md-1">no.</th>
				<th class="com-mi-1">지역</th>
				<th class="col-md-3">구장이름</th>
				<th class="col-md=3">경기일</th>
				<th class="col-md-2">모집상태</th>
				<th class="col-md-2">작성일</th>
				<th class="com-md-1"></th>
			</tr>
			<tr>
				<td>1</td>
				<td>서울</td>
				<td>서울어쩌고구장</td>
				<td>2023/03/22</td>
				<td>모집완료</td>
				<td>2023/03/03</td>
				<td>
					<a href="blackListFrm.do?memberNo=<%=m.getMemberNo()%>">신고</a>
				</td>
			</tr>
		</table>
		<table class="history-content table">
			<tr>
				<th class="col-md-1">no.</th>
				<th class="com-mi-1">지역</th>
				<th class="col-md-3">구장이름</th>
				<th class="col-md=3">경기일</th>
				<th class="col-md-2">신청내용</th>
				<th class="col-md-2">모집결과</th>
				<th class="com-md-1"></th>
			</tr>
			<tr>
				<td>1</td>
				<td>서울</td>
				<td>서울어쩌고구장</td>
				<td>2023/03/22</td>
				<td>모집완료</td>
				<td>수락완료</td>
				<td>
					<a href="blackListFrm.do?memberNo=<%=m.getMemberNo()%>">신고</a>
				</td>
			</tr>
			<tr>
				<td>1</td>
				<td>서울</td>
				<td>서울어쩌고구장</td>
				<td>2023/03/22</td>
				<td>모집완료</td>
				<td>-</td>
				<td>신고</td>
			</tr>
		</table>
	</div>
	<script>
		$(".history-menu>li").on("click", function(){
		    $(".history-menu>li").removeClass("active-tab");
		    $(this).addClass("active-tab");
		    const contents = $(".history-content");
		    contents.hide();
		    const index = $(".history-menu>li").index(this);
		    contents.eq(index).show(); 
		});
		$(".history-menu>li").eq(0).click();
	</script>

	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>