<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Mercenary mc = (Mercenary)request.getAttribute("mc");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>용병모집 상세보기</title>
<style>
    .tbl {
	    width: 100%;
	    border-spacing: 0px;
	    border-collapse: collapse;
    }
    .tbl th,.tbl td {
        padding: 10px;
        text-align: center;
    } 
    #mercenaryView th, #mercenaryView td{
        border: 1px solid #ccc;
    }
    #mercenaryView th{
        background-color: #181818;
        color: #fcfcfc;
    }
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
			<h2>용병모집</h2>
			<hr>
		</div>
		<table class="tbl" id="mercenaryView">
			<tr>
				<td><%=mc.getGroundName() %></td>
			</tr>
		</table>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>