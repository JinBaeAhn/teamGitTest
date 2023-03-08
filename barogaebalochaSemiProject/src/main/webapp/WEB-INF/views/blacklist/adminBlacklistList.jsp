<%@page import="semi.team.baro.blacklist.model.vo.Blacklist"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Blacklist> list = (ArrayList<Blacklist>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    int start = (int)request.getAttribute("start");
    %>
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
.history-content tr:not(tr:first-child):hover>td{
	color: #AACB73;
}
.history-content td{
	cursor:pointer;
}

.page-navi{
		margin: 50px auto;
}
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
<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
	<div class="page-title">
		<h2>신고관리</h2>
	</div>
	<table class="history-content table">
		<tr>
			<th style="width:5%">no.</th>
			<th style="width:20%">신고제목</th>
			<th style="width:10%">작성자</th>
			<th style="width:25%">작성일</th>
			<th style="width:15%">신고대상자</th>
			<th style="width:20%" colspan="2">신고상태</th>
			<th></th>
		</tr>
		<%for(int i=0;i<list.size();i++) {%>
			<%Blacklist b = list.get(i); %>
		<tr class="tr-1">
			<input type="hidden" id="blackNo" value="<%=b.getBlackNo() %>">
			<input type="hidden" id="blackStatus" value="<%=b.getBlackStatus() %>">
			<td><%=i+start %></td>
			<td>
				<a href="/blacklistView.do?blackNo=<%=b.getBlackNo() %>">
					<%=b.getBlackTitle() %>
				</a>
			</td>
			<td><%=b.getMemberId() %></td>
			<td><%=b.getRegDate() %></td>
			<td><%=b.getBlackMember() %></td>
			<td>
				<%if(b.getBlackStatus() == 1) {%>
				<select class="input-form">
					<option value="1" selected>처리중</option>
					<option value="2">처리완료</option>
					<option value="3">처리취소</option>
				</select>
				<%}else if(b.getBlackStatus() == 2) {%>
				<select class="input-form">
					<option value="1">처리중</option>
					<option value="2" selected>처리완료</option>
					<option value="3">처리취소</option>
				</select>
				<%}else if(b.getBlackStatus() == 3) {%>
				<select class="input-form">
					<option value="1">처리중</option>
					<option value="2">처리완료</option>
					<option value="3" selected>처리취소</option>
				</select>
				<%} %>
			</td>
			<td>
				<button class="btn bc4 changeStatus">상태변경</button>
			</td>
		</tr>
		<%} %>
	</table>
	<div id="pageNavi"><%=pageNavi %></div>   
</div>
<script>
		$(".changeStatus").on("click",function(){
			const blackNo =  $(this).parent().parent().children().eq(0).val();
			console.log(blackNo);
			const blackStatus =  $(this).parent().prev().children().val();
			console.log(blackStatus);
			location.href="/changeStatus.do?blackNo="+blackNo+"&blackStatus="+blackStatus;
		});
		
	</script>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>