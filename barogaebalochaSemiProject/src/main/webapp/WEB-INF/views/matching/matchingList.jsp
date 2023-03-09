<%@page import="semi.team.baro.matching.model.vo.Matching"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Matching> list = (ArrayList<Matching>)request.getAttribute("list");
    	String pageNavi = (String)request.getAttribute("pageNavi");
		int start = (int)request.getAttribute("start");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    *{
        list-style-type: none;
    }
    
    .matchingList-wrap{
        margin-top: 40px;   
    }
    .matchingList-list{
        width: 1000px;
        margin: 0 auto;
        overflow: hidden;
        padding: 20px;
        border-bottom: 1px solid #ccc;
    }
    .matchingList-list-left{
        overflow: hidden;
        display: inline;
    }
    .matchingList-list-left ul{
        float: left;
        margin-left: 20px;
    }
    .matchingList-result{
        float: right;
    }
    .matchingList-info{
        padding-top: 20px;
    }
    .matchingList-info>ul{
    	margin-bottom: 5px;
    	margin-left: 50px;
    }
    .matchingList-info>ul>li{
    	width: 200px;
    }
    .matchingList-date>ul{
    	width: 150px;
        font-size: 15px;
        margin-top: 5px;
    }
    .matchingList-groundName>ul>li{
    	width: 300px;
    	margin-top: 3px;
    }
    .button{
        width: 100%;
        padding-left: 970px;
        margin-top: 30px;
        box-sizing: border-box;
    }
    #pageNavi{
   		margin-top: 50px;
   	}
   	
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		        <div class="page-title">
            <h2>매칭리스트</h2>
            <hr>
        	</div>
        <div class="matchingList-wrap">
        <% for(Matching mc : list) {%>
        
        <!-- <a href="/matchingView.do?matchingNo=<%=mc.getMatchingBoardNo() %>"> -->
        	<div class="matchingList-list">
                <div class="matchingList-list-left">
                    <div class="matchingList-date">
                        <ul>
                            <li style="font-size: 15px;"><%=mc.getGroundLocation().substring(0,2)%></li>
                            <li><%=mc.getReservationDate() %></li>
                            <li><%=mc.getReservationShowTime() %></li>
                        </ul>
                    </div>
                    <div class="matchingList-info">
                        <ul>
                            <li style="font-size: 20px;"><%=mc.getGroundName()%></li>
								<li>예약번호 : <%=mc.getReservationNo() %> </li>
                        </ul>
                    </div>
                    <div class="matchingList-groundName">
                        <ul>
                            <li style="font-size: 25px;"><%=mc.getMatchingBoardTitle() %></li>
                        </ul>
                    </div>
                </div>
                <div class="matchingList-result">
                	<%if(m != null) {%>
                		<%if(mc.getMatchingStatus() == 1){%>
	                    <div class="btn1" style="background-color: #AACB73;"><a style="color:#fff;" href="/matchingView.do?reservationNo=<%=mc.getReservationNo() %>&memberNo=<%=m.getMemberNo() %>&matchingBoardNo=<%=mc.getMatchingBoardNo()%>">상세보기</a></div>
	                    <%}else if(mc.getMatchingStatus() == 2){ %>
	                    	<%if(mc.getMemberNo() == m.getMemberNo()) {%>
	                    		<div class="btn1" style="background-color: #AACB73;"><a style="color:#fff;" href="/matchingView.do?reservationNo=<%=mc.getReservationNo() %>&memberNo=<%=m.getMemberNo() %>&matchingBoardNo=<%=mc.getMatchingBoardNo()%>">상세보기</a></div>
	                    	<%}else{ %>
	                    		<div class="btn1" style="background-color: #ccc; color:#fff" >신청마감</div> 
	                    	<%} %>
	                    <%} %> 
                	<%}else{%>
                		<div class="btn1 need-login" style="background-color: #AACB73; color:#fff;" onclick="alert('로그인이 필요합니다')">상세보기</div>
                	<%} %>
                </div>
            </div>	
          <!--  </a> -->	
        <%} %>                     
        </div>
        <%if(m != null) {%>
        	<div class="button"><a href="/matchingListWrite.do" class="btn1 bc2 bs2 frm-btn">작성하기</a></div>
        <%} %>
        <div id="pageNavi"><%=pageNavi %></div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
<script>

</script>
</body>
</html>