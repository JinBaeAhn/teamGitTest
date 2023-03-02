<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Mercenary> list = (ArrayList<Mercenary>)request.getAttribute("list");
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
    
    .mercenary-wrap{
        margin-top: 40px;   
    }
    .mercenary-list{
        width: 1000px;
        margin: 0 auto;
        overflow: hidden;
        padding: 20px;
        border-bottom: 1px solid #ccc;
    }
    .mercenary-list-left{
        overflow: hidden;
        display: inline;
    }
    .mercenary-list-left ul{
        float: left;
        margin-left: 20px;
    }
    .mercenary-result{
        float: right;
    }
    .mercenary-info{
        padding-top: 20px;
    }
    .mercenary-date>ul{
        font-size: 18px;
    }
    .button{
        width: 100%;
        padding-left: 550px;
        margin-top: 30px;
        box-sizing: border-box;
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
        <div class="mercenary-wrap">
        <% for(Mercenary mc : list) {%>
        <a href="/mercenaryView.do?mercenaryNo="<%=mc.getMemberNo() %>>
        	<div class="mercenary-list">
                <div class="mercenary-list-left">
                    <div class="mercenary-date">
                        <ul>
                            <li style="font-size: 15px;"><%=mc.getLocation() %></li>
                            <li><%=mc.getGameDate() %></li>
                            <li><%=mc.getGameShowTime() %></li>
                        </ul>
                    </div>
                    <div class="mercenary-info">
                        <ul>
                            <li style="font-size: 20px;">구장이름</li>
                            <li>실력 : <%=mc.getLevel() %></li>
                        </ul>
                    </div>
                </div>
                <div class="mercenary-result">
                    <a class="btn1" style="background-color: #AACB73; color:#fff">모집중</a>
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