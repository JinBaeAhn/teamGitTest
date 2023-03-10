<%@page import="semi.team.baro.blacklist.model.vo.Blacklist"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Blacklist bla = (Blacklist)request.getAttribute("bla");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .tbl {
    	width: 80%;
    	margin: 0 auto;
	    border-spacing: 0px;
	    border-collapse: collapse;
	 	
    }
    .tbl th,.tbl td {
        padding: 10px;
        text-align: center;
    } 
    #blacklistView th, #blacklistView td{
        border: 1px solid #ccc;
        font-size: 13px;
    }
    #blacklistView th{
        background-color: #ccc;
        color: #000;
        opacity: 40%;
    }
    .black-content{
    	text-align: left;
    	height: 800px;
    	overflow: scroll;
    	padding: 20px;
    }
    .btn1{
    	padding: 5px;
    }
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="page-content">
			<div class="page-title">
				<h2>신고상세</h2>
			</div>
			<table class="tbl" id="blacklistView">
				<tr>
					<th colspan="4">신고내용</th>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=bla.getMemberId() %></td>
					<th>작성일</th>
					<td style="color:#ccc;"><%=bla.getRegDate() %></td>
				</tr>
				<tr>
					<th>신고대상</th>
					<td><%=bla.getBlackMember() %>
					<th>처리상태</th>
					<%if(bla.getBlackStatus() == 1) {%>
						<td>처리중</td>
					<%}else if(bla.getBlackStatus() == 2) {%>
						<td>처리완료</td>
					<%}else if(bla.getBlackStatus() == 3) {%>
						<td>처리취소</td>
					<%} %>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><%=bla.getBlackTitle() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"><%=bla.getBlackFilepath() %></td>
				</tr>
				<tr style="min-hight:300px;">
					<th>내용</th>
					<td colspan="3">
						<div class="black-content">
							<%=bla.getBlackContentBr() %>
						</div>
					</td>
				</tr>
				<!--<tr>
					<td colspan="4"><a href="/historyBlacklist.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=blacklist" class="btn1 bc2">목록으로</a></td>  
				</tr>-->
			</table>
		</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>



