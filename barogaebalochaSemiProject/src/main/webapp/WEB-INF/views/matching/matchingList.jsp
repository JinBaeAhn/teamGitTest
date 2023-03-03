<%@page import="semi.team.baro.matching.model.vo.Matching"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Matching> list = (ArrayList<Matching>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		        <div class="page-title">
            <h2>용병모집</h2>
            <hr>
        </div>
        <div class="mercenary-wrap">
        <% for(Matching mc : list) {%>
        <a href="/matchingView.do?matchingNo=<%=mc.getMatchingNo() %>">
        	<div class="mercenary-list">
                <div class="mercenary-list-left">
                    <div class="mercenary-date">
                        <ul>
                            <li style="font-size: 15px;"><%=mc.getGroundLocation() %></li>
                            <li><%=mc.getReservationDate() %></li>
                            <li><%=mc.getReservationTime() %></li>
                        </ul>
                    </div>
                    <div class="mercenary-info">
                        <ul>
                            <li style="font-size: 20px;"><%=mc.getGroundName() %></li>
								<li>예약번호 : <%=mc.getReservationNo() %> </li>
                        </ul>
                    </div>
                </div>
                <div class="mercenary-result">
                	<%if(mc.getMatchingStatus() == 1) {%>
	                    <div class="btn1" style="background-color: #AACB73; color:#fff">매치신청</div>            	
                	<%}else if(mc.getMatchingStatus() == 2) {%>
                		<div class="btn1" style="background-color: #ccc; color:#fff">신청마감</div> 
                	<%} %>
                </div>
            </div>	
           </a>	
        <%} %>                     
        </div>
        <div class="button"><a href="/mercenaryWrite.do" class="btn1 bc2 bs2">작성하기</a></div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>