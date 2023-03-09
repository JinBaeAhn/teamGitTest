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
    	margin-bottom: 15px;
    	margin-left: 120px;
    }
    .matchingList-info>ul>li{
    	width: 350px;
    }
    .matchingList-date>ul{
    	width: 150px;
        font-size: 15px;
        margin-top: 40px;
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
   .apply-cancel-wrap{
   		width: 250px;
   		padding-left: 40px
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
            <h2>매치신청을 보내온 회원님들입니다</h2>
            <hr>
        	</div>
        <div class="matchingList-wrap">
        <% for(Matching mc : list) {%>
        
        <!-- <a href="/matchingView.do?matchingNo=<%=mc.getMemberNo() %>"> -->
        	<div class="matchingList-list">
                <div class="matchingList-list-left">
                    <div class="matchingList-date">
                        <ul>
                            <li style="font-size: 18px;">회원번호 : <%=mc.getMemberNo()%></li>
                        </ul>
                    </div>
                    <div class="matchingList-info">
                        <ul>
                            <li style="font-size: 20px; margin-bottom: 10px;">회원이름 : <%=mc.getMemberName()%></li>
                            	<%if(mc.getMatchingRequestStatus() == 2) {%>
								<li style="font-size: 15px;">전화번호 : <%=mc.getMemberPhone() %> </li>
								<li style="font-size: 15px;">이메일: <%=mc.getMemberMail() %></li>
								<%}else{ %>
								<li style="font-size: 15px;">전화번호 : 신청수락한 회원 정보만 볼 수 있습니다 </li>
								<li style="font-size: 15px;">이메일: 신청수락한 회원 정보만 볼 수 있습니다 </li>
								<%} %>
                        </ul>
                    </div>
                    
                </div>
                <div class="matchingList-result">
                	<%if(mc.getMatchingRequestStatus() == 1) {%>
	                    <div class="btn1 okay-btn" style="background-color: #AACB73; margin-right: 8px;"><a style="color:#fff;" href="/applyInsert.do?memberNo=<%=mc.getMemberNo()%>&matchingBoardNo=<%=mc.getMatchingBoardNo()%>">신청수락</a></div>
	                    <%}else if(mc.getMatchingRequestStatus() == 2) { %>
	                    <div class="apply-cancel-wrap">
	                    <div class="btn1" style="background-color: #ff4040;"><a style="color:#fff; font-family: ns-light; " href="/applyCancel.do?memberNo=<%=mc.getMemberNo()%>&matchingBoardNo=<%=mc.getMatchingBoardNo()%>">수락취소</a></div>
	                    <div class="btn1 need-login" style="background-color: #AACB73; color:#fff;" onclick="alert('이미 수락하셨습니다')">수락완료</div> 
	                    </div>
                	<%} %>
                </div>
            </div>	
          <!--  </a> -->	
        <%} %>                     
        </div>
        <%if(m != null) {%>
        	<div class="button"><a href="/matchingList.do?requestPage=1" class="btn1 bc2 bs2 frm-btn">목록으로</a></div>
        <%} %>
        <div id="pageNavi"><%=pageNavi %></div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
<script>
	$(".okay-btn").on("click",function(){
		$(".okay-btn").children().$("a").removeAttr("href");
		alert("신청 수락은 한명만 가능합니다.")
	})
</script>
</html>