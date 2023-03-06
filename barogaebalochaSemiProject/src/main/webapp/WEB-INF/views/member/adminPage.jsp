<%@page import="semi.team.baro.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


.tbl {
    width: 100%;
    border-spacing: 0px;
    border-collapse: collapse;
}
.tbl tr{
    background-color: #fefefe;
    color: #181818;
}
.tbl tr>th{
    text-align: center;
}
.tbl td {
    padding: 1rem;
    text-align: center;
    font-size: 0.5em;
}
.menu li{
    list-style-type: none;
}
.menu {
    display: none;
}
.bs5 {
	margin-top : 15px;
    width: 250px;
    padding: 2rem;
    font-size: 1.2em;
}

.btn6 {
    border: none;
    padding: 3px;
    margin-left: 12px;
    display: inline-block;
    box-sizing: border-box;
    transition-duration: 0.5s;
    font-size: 12px;
    font-family: ns-light;
    border-radius: 3px;
    width : 35px;
    text-align: center;
    
}
.searchIdinput{
	
	line-height: 30px;
	margin-bottom : 20px;
	text-align: right;
	margin-right: 20px;
}
.bc21 {
    background-color: #fff;
    color: rgba(57, 62, 70, 0.9);
    border: 1px solid rgba(57, 62, 70, 0.9);
    height: 33px;
   
}
.searchId{
	border: 1px solid rgba(57, 62, 70, 0.9);
	height: 33px;
	text-align: center;
}



</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">회원관리</div>
		<div class="searchIdinput">
		<input type="text" class="searchId"><a class="btn6 bc21" href="#">검색</a>
		</div>
		<table class="tbl tbl-hover">
			<tr class="tr-3">
				<th>선택</th>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>메일주소</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>회원등급</th>
				<th>가입일</th>
				<th>회원포인트</th>
				<th colspan="2">등급변경</th>
			</tr>
			<%for(Member member : list) {%>
			<tr class="tr-1">
				<td><input type="checkbox" class="chk"></td>
				<td><%=member.getMemberNo() %></td>
				<td><%=member.getMemberId() %></td>
				<td><%=member.getMemberPw() %></td>
				<td><%=member.getMemberName() %></td>
				<td><%=member.getMemberMail() %></td>
				<td><%=member.getMemberPhone() %></td>
				<td><%=member.getMemberAddr() %></td>
				<td><%=member.getMemberLevel() %></td>
				<td><%=member.getEnrollDate() %></td>
				<td><%=member.getMemberCredit() %></td>
				<td>
					<%if(member.getMemberLevel() == 1) {%>
					<select class="input-form">
						<option value="1" selected>관리자</option>
						<option value="2">정회원</option>
						<option value="3">블랙회원</option>
					</select>
					<%}else if(member.getMemberLevel() == 2) {%>
					<select class="input-form">
						<option value="1">관리자</option>
						<option value="2" selected>정회원</option>
						<option value="3">블랙회원</option>
					</select>
					<%}else if(member.getMemberLevel() == 3) {%>
					<select class="input-form">
						<option value="1">관리자</option>
						<option value="2">정회원</option>
						<option value="3" selected>블랙회원</option>
					</select>
					<%} %>
				</td>
				<td>
					<button class="btn bc4 changeLevel">등급변경</button>
				</td>
			</tr>
			<%} %>
			<tr>
				<th colspan="13">
					<button class="btn bc4 bs5 checkedChangeLevel">선택회원등급변경</button>
				</th>
			</tr>
		</table>
	</div>
	<script>
		$(".changeLevel").on("click",function(){
			const memberNo = $(this).parent().parent().children().eq(1).text();
			const memberLevel = $(this).parent().prev().children().val();
			location.href="/changeLevel.do?memberNo="+memberNo+"&memberLevel="+memberLevel;
		});
		$(".checkedChangeLevel").on("click",function(){
			const check = $(".chk:checked");
			if(check.length == 0){
				alert("선택된 회원이 없습니다.");
				return;
			}
			const no = new Array();
			const level = new Array();
			check.each(function(index,item){
				const memberNo = $(item).parent().next().text();
				no.push(memberNo);
				const memberLevel = $(item).parent().parent().find("select").val();
				level.push(memberLevel);
			});
			location.href="/checkedChangeLevel.do?no="+no.join("/")+"&level="+level.join("/");
		});
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>