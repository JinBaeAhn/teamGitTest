<%@page import="semi.team.baro.matching.model.vo.Matching"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Matching mc = (Matching)request.getAttribute("mc");
    int memberCheck = (int)request.getAttribute("check");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<style>
	.locationSearch{
	width: 142.5px;
	}
    .tbl {
    width: 100%;
    border-spacing: 0px;
    border-collapse: collapse;
    }
    .tbl th,.tbl td {
        padding: 10px;
        text-align: center;
        overflow: hidden;
    }   
    .mercenary-input-wrap{
        padding: 20px;
    }
    .input-form{
        padding: 5px;
    }
    .location-select-form{
	    width: 930px;
	    padding: 0.8rem;
	    background-color: #fff;
	    outline: none;
	    border: 1px solid #ccc;
	    box-sizing: border-box;
	    float: left;
    }
    input.locationSearch{
    	height: 51.15px;
    	padding: 0px;
    	float: left;
    }
    #matchinglistWriteFrm th, #matchinglistWriteFrm td{
        border: 1px solid #ccc;
    }
    #matchinglistWrite th{
        color: #181818;
    }
    .btn1{
        padding: 8px;
        margin-left: 20px;
        cursor: pointer;
    }
    .mercenary-input-wrap input[type=radio]{
        display: none;
    }
    .mercenary-input-wrap input[type=radio]+label{
        width: 20%;
        text-align: center;
        padding: 10px;
        border: 1px solid #181818;
        color: #181818;
        font-family: nn_b;
        cursor: pointer;
        display: block;
        float: left;
        box-sizing: border-box;
    }
    .mercenary-input-wrap input[type=radio]:checked+label{
        color:#fcfcfc;
        background-color: #181818;
    }
    .playTime{
    	height: 51.59px;
    	text-align: left;
    }
    
    <!--모달랩 css-->
    body{
    margin: 0;
	}
	.modal-wrap{
	    width: 100vw;
	    height: 100vh;
	    background-color: rgba(0,0,0,0.5);
	    position: absolute;
	    top: 0;
	    left: 0;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    display: none;
	}
	.login-modal{
	    background-color: #fff;
	    width: 40vw;
	    min-width: 300px;
	    max-width: 500px;
	    height: 40vh;
	    min-height: 350px;
	    max-height: 450px;
	
	}
	.modal-top>h2{
	    text-align: center;
	    margin-top : 20px;
	}
	.modal-content input{
	    display: block;
	    outline: none;
	    margin: 20px auto;
	    width: 80%;
	    height: 30px;
	    border: 1px solid #ccc;
	}
	 input.modal-btn{
    	height: 51.15px;
    	padding: 0px;
    }
    input.modal-location{
    	width: 400px;
    	height: 51.15px;
	    padding: 0.8rem;
	    background-color: #fff;
	    outline: none;
	    border: 1px solid #ccc;
	    box-sizing: border-box;
	    margin-left: 50px;
    }
    .modal-select-form{
    	width: 400px;
	    padding: 0.8rem;
	    background-color: #fff;
	    outline: none;
	    border: 1px solid #ccc;
	    box-sizing: border-box;
	    margin-left: 50px;
    }
	.modal-btn-frm{
	margin-top: 50px;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
            <h2>매칭폼</h2>
            <div class="matchinglistWriteFrm-input-wrap">
                
                    <table class="tbl" id="matchinglistWriteFrm">
                    	<tr>
                            <th>매칭 제목</th>
                            <td>
                                <input type="text" class="input-form" name="matchingBoardTitle" value=<%=mc.getMatchingBoardTitle() %> readonly>
                            </td>
                        </tr>
                        <tr>
                            <th>지역</th>
                            <td>
                                <input type="text" class="input-form" name="groundLocation" value=<%=mc.getGroundLocation() %> readonly>
                             </td>
                        </tr>
                        <tr>
                            <th>경기장</th>
                            <td>
                                <input type="text" class="input-form" name="groundName" value=<%=mc.getGroundName() %> readonly>
                            </td>
                        </tr>
                        <tr>
                            <th>경기날짜</th>
                            <td>
                                <input type="text" class="input-form" id="datepicker" value=<%=mc.getReservationDate() %> readonly>
                            </td>
                        </tr>
                        <tr>
                            <th>경기시간</th>
                            <td>
                                 <div class="input-form playTime">
                                 <p><%=mc.getReservationShowTime() %></p>
                                 </div>
                            </td>
                        </tr>
                        <tr>
                            <th>대여가격</th>
                            <td>
                                <div class="input-form playTime">
                                 <p><%=mc.getGroundPrice() %></p>
                                 </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea class="input-form content" name="matchingBoardContent" readonly><%=mc.getMatchingBoardContent() %></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                            	<%if(mc.getMemberNo() != m.getMemberNo() && memberCheck == 0 && m.getMemberLevel() != 1) {%>
                            	<a href="matchingMemberListInsert.do?matchingBoardNo=<%=mc.getMatchingBoardNo() %>&memberNo=<%=m.getMemberNo() %>&reservationNo=<%=mc.getReservationNo() %>">
                            	<input type="submit" class="btn1 bc1 apply-btn apply-complete" value="신청하기">
                            	</a>
                            	<%}else if(mc.getMemberNo() != m.getMemberNo() && memberCheck == 1) { %>
                            	<a href="#">
                            	<input type="submit" class="btn1 bc1 apply-complete" onclick="alert('이미 신청한 매치입니다')" value="신청완료">
                            	</a>
                            	<%}else if(m.getMemberLevel() == 1) {%>
                            		<a href="matchingMemberList.do?matchingBoardNo=<%=mc.getMatchingBoardNo()%>&requestPage=1">
                            		<input type="submit" class="btn1 bc1 apply-btn" value="신청현황">
                            		</a>
                            	<%}else{ %>
                            	<a href="matchingMemberList.do?matchingBoardNo=<%=mc.getMatchingBoardNo()%>&requestPage=1">
                            	<input type="submit" class="btn1 bc1 apply-btn" value="신청현황">
                            	</a>
                            	<a id="cancelMatch" href="matchingCancel.do?reservationNo=<%=mc.getReservationNo() %>&matchingBoardNo=<%=mc.getMatchingBoardNo() %>&memberNo=<%=m.getMemberNo()%>&groundPrice=<%=mc.getGroundPrice() %>&memberCredit=<%=m.getMemberCredit()%>">
                            	<input type="submit" class="btn1 bc1 apply-btn" value="매치취소">
                            	</a>
                            	<%} %>
                                <a href="/matchingList.do?requestPage=1" class="btn1 bc1">목록으로</a>
                               
                            </td>
                        </tr>
                    </table>          
                
            </div>
        </div>
       	<!-- 매칭리스트 -->
     
       
        
      
	</div>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
    $('#cancelMatch').click(function(event) {
        event.preventDefault(); // 링크 클릭 시, 페이지 이동을 막음
        const confirmDelete = confirm('매치를 취소하시면 다시 조회할 수 없습니다 정말로 매치를 취소하시겠습니까?'); // 한번 더 확인창을 띄움
        if (confirmDelete) {
          window.location.href = $(this).attr('href'); // 확인 시, 탈퇴 페이지로 이동
        }
      });
    </script>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>