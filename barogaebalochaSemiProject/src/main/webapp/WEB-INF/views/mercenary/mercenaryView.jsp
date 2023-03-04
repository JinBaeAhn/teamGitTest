<%@page import="semi.team.baro.mercenary.model.vo.MercenaryRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Mercenary mc = (Mercenary)request.getAttribute("mc");
    	ArrayList<MercenaryRequest> list = (ArrayList<MercenaryRequest>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<title>용병모집 상세보기</title>
<style>
	.read-count{
		height: 30px;
		text-align: right;
		width: 90%;
		margin: 0 auto;
	}
	.read-count span{
		color: #ccc;
		height: 30px;
		line-height: 30px;
	}
	.read-count span:first-child{
		font-size: 20px;
	}
    .tbl {
    	width: 90%;
    	margin: 0 auto;
	    border-spacing: 0px;
	    border-collapse: collapse;
    }
    .tbl th,.tbl td {
        padding: 10px;
        text-align: center;
    } 
    #mercenaryView th, #mercenaryView td{
        border: 1px solid #ccc;
        font-size: 13px;
    }
    #mercenaryView th{
        background-color: #181818;
        color: #fcfcfc;
    }
    .mercenary-content{
    	text-align: left;
    	min-height: 400px;
    	padding: 20px;
    }
    .back-link>.bs4{
    	padding: 10px;
    	font-size: 15px;
    	font-family: ns-bold;
    }
    .inputCommentBox{
		margin: 50px;
	}
	.inputCommentBox>form>ul{
		list-style-type: none;
		padding: 0;
		display: flex;
	}
	.inputCommentBox>form>ul>li:first-child{
		width: 10%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.inputCommentBox>form>ul>li:first-child>span{
		font-size: 70px;
		color: #ccc;
	}
	.inputCommentBox>form>ul>li:nth-child(2){
		width: 75%;
	}
	.inputCommentBox>form>ul>li:nth-child(2)>textarea{
		height: 95px;
		min-height: 95px;
	}
	.inputCommentBox>form>ul>li:last-child{
		width: 10%;
	}
	.back-link{
		width: 100%;
		text-align: center;
		margin-top: 30px;
	}
	.back-link>a{
		font-family: ns-bold;
		font-size: 14px;
	}
	.view-link{
		text-align: right;
		width: 90%;
		margin: 0 auto;
	}
	.view-link>a{
		padding-left: 15px;
		color: #181818;
		cursor:pointer;
	}
	.posting-info>p{
		margin: 0;
	}
	.posting-info>p:last-child{
		margin-left: 70px;
	}
	.posting-link>.btn2{
		padding: 5px 10px;
	}
	.posting-link>.btn2:hover{
		background-color: #AACB73; 
		border: 2px solid #AACB73;
	}
	.comment-wrap{
		border-bottom: 1px solid #ccc;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
			<h2>용병모집</h2>
		</div>
		<div class="read-count">
			<span class="material-symbols-outlined">spoof</span>  
			<span><%=mc.getReadCount() %></span>	
		</div>
		<table class="tbl" id="mercenaryView">
			<tr>
				<th colspan="4"> 용병모집 </th>
			</tr>
			<tr>
				<th>지역</th>
				<td><%=mc.getLocation() %></td>
				<th>구장이름</th>
				<td colspan="3"><%=mc.getGroundName() %></td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="3">서울시 영등포구</td>
			</tr>
			<tr>
				<th>경기일</th>
				<td colspan="3"><%=mc.getGameDate() %> [ <%=mc.getGameShowTime() %> ]</td>				 
			</tr>
			<tr>
				<th>모집상태</th>
				<% if(mc.getMercenaryWhether() == 0 ) {%>
					<td colspan="3">모집중</td>
				<%}else if(mc.getMercenaryWhether() == 1) {%>
					<td colspan="3">모집완료</td>
				<%} %>				
			</tr>
			<tr>
				<th>참가비</th>
				<td><%=mc.getMercenaryPay() %> 원</td>
				<th>실력</th>
				<%if(mc.getLevel() == 1){ %>
					<td>최상</td>
				<%}else if(mc.getLevel() == 2) {%>
					<td>상</td>
				<%}else if(mc.getLevel() == 3) {%>
					<td>중</td>
				<%}else if(mc.getLevel() == 4) {%>
					<td>하</td>
				<%}else if(mc.getLevel() == 5) {%>
					<td>최하</td>
				<%} %>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=mc.getMemberId() %></td>
				<th>작성일</th>
				<td style="color:#ccc;"><%=mc.getRegDate() %></td>
			</tr>
			<tr>
				<th colspan="4">상세내용</th>
			</tr>
			<tr>
				<td colspan="4">
					<div class="mercenary-content">
						<%=mc.getMercenaryContent() %>
					</div>
				</td>
			</tr>
			<tr>
				<th colspan="4">
					<div class="no">
						
					</div>
				</th>
			</tr>	
		</table>
		<div class="view-link">
			<%if( m != null && m.getMemberNo() == mc.getMemberNo()) {%>
				<a href="/mercenaryUpdateFrm.do?mercenaryNo=<%=mc.getMercenaryNo()%>">수정</a>
				<a onclick="mercenaryDelete(<%=mc.getMercenaryNo()%>);">삭제</a>
			<%} %>
		</div>		
		<div class="back-link">
			<a href="/mercenaryList.do?reqPage=1" class="btn2 bc1">목록으로</a>
		</div>
		<!-- 댓글input박스 -->
		<div class="inputCommentBox">
			<form action="/mercenaryRequestInsert.do" method="post">
				<ul>
					<li>
						<span class="material-symbols-outlined">account_circle</span>
					</li>
					<li>
						<%if(m == null) {%>
							<textarea name="mcRequestContent" class="input-form" style="color:#ccc;" readonly>로그인한 회원만 작성할 수 있습니다.</textarea>
						<%}else {%>
							<input type="hidden" name="mcRequsetWriter" value="<%=m.getMemberNo() %>">
							<input type="hidden" name="mercenaryNo" value="<%=mc.getMercenaryNo() %>">
							<input type="hidden" name="mcRequestNo" value="0">
							<textarea name="mcRequestContent" class="input-form"></textarea>
						<%} %>
						
					</li>
					<li>
						<% if( m == null ) {%>
						<button type="button" class="btn1 bc1 bs4">등록</button>
						<%}else {%>
						<button type="submit" class="btn1 bc1 bs4">등록</button>
						<%} %>
					</li>
				</ul>
			</form>
		</div>
		<!-- 댓글 -->
		<%for(MercenaryRequest mcReq : list) {%>
		<div class="comment-wrap">
            <div class="posting-comment">
                <span class="material-icons">account_box</span>
            </div>
            <div class="posting-info">
                <span style="font-size:17px;"><%=mcReq.getMemberId() %></span>
                <p><%=mcReq.getMercenaryRequestContent() %></p>
                <p><%=mcReq.getMercenaryRequestDate() %></p>
            </div>
            <div class="posting-link">
            	<%if( m != null && m.getMemberNo() == mc.getMemberNo()) {%>
                <button type="button" class="btn2 bc2 sel">선택</button>
                <%}else if( m != null && m.getMemberNo() == mcReq.getMemberNo()) {%>
                <a href="#">수정</a>
                <a href="#">삭제</a>
                <%} %>
            </div>
        </div>  		
		<%} %>
      </div>
	<script>
	    function mercenaryDelete(mercenaryNo) {
	        Swal.fire({
	            title: '게시글 삭제',
	            text: "게시글을 삭제하시겠습니까?",
	            icon: 'question',
	            showCancelButton: true,
	            confirmButtonColor: '#AACB73',
	            cancelButtonColor: '#ccc',
	            confirmButtonText: '확인',
	            cancelButtonText: '취소'
	        }).then((result) => {
	            if (result.isConfirmed) {
	                location.href="/mercenaryDelete.do?mercenaryNo="+mercenaryNo;
	            }
	        })
	    }
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>