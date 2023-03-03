<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member member = (Member)request.getAttribute("m");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .wrap {
        width: 800px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0px 0px 10px #ddd;
    }
	.page-title{
		font-size: 1.5rem;
        margin-top: 20px;
	}
	.page-content{
		width: 100%;
		margin: 0 auto;
	}
    .member{
        width: 100%;
        font-size: 20px;
    }
    #img-view{
        width: 200px;
        border-radius: 50%;
    }
    
    .input-wrap{
    	width: 50%;
    }
    .input-wrap>input{
    	border: none;
    }
    #memberCredit{
    	width: 500px;
    }
    .img-wrap{
    	width: 200px;
    	margin: 0 auto;
    }
    .btn-box{
    	margin-top: 20px;
    	width: 600px;
    	text-align : center;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="wrap">
        <div class="page-content">
            <div class="page-title"><%=m.getMemberName() %>의 라커룸</div>
			<div class="input-wrap">
				<div class="img-wrap">
					<label for="imgFile">
                            <%if(m.getFilepath() == null){ %>
                            <img src="img/profile.png" id="img-view">
							<%}else{ %>
							<img src="/upload/photo/<%=m.getFilepath() %>" id="img-view">
							<%} %>
                    </label>
				</div>
			</div>
			<div class="input-wrap">
				<label for="memberId">아이디</label>
				<input type="text" name="memberName" id="memberName" class="input-form" value="<%=m.getMemberId()%>" disabled>
			</div>
			<div class="input-wrap">
				<label for="memberName">회원이름</label>
				<input type="text" name="memberName" id="memberName" class="input-form" value="<%=m.getMemberName()%>" disabled>
			</div>
			<div class="input-wrap">
				<label for="memberPhone">전화번호</label>
				<input type="text" name="memberPhone" id="memberPhone" class="input-form" value="<%=m.getMemberPhone()%>"disabled>
			</div>
			<div class="input-wrap">
				<label for="memberAddr">주소</label>
				<input type="text" name="memberAddr" id="memberAddr" class="input-form" value="<%=m.getMemberAddr()%>"disabled>
			</div>
			<div class="input-wrap">
				<label for="memberCredit">포인트</label>
				<input type="text" name="memberCredit" id="memberCredit" class="input-form" value="<%=m.getMemberCredit()%>p"disabled>
				<a class="btn bc4 bs5" id="charge" href="/chargePoint.do">충전하기</a>
				
			</div>
			<div class="input-wrap">
				<label for="memberLevel">회원등급</label>
				<%if(m.getMemberLevel() == 1) {%>
				<input type="text" name="memberLevel" id="memberLevel" class="input-form" value="관리자" disabled>
				<%}else if(m.getMemberLevel() == 2){%>
				<input type="text" name="memberLevel" id="memberLevel" class="input-form" value="정회원" disabled>
				<%}else if(m.getMemberLevel() == 3){%>
				<input type="text" name="memberLevel" id="memberLevel" class="input-form" value="블랙" disabled>
				<%} %>
			</div>
			<div class="input-wrap">
				<label for="memberContent">자기소개</label>
				<textarea name="memberContent" id="memberContent" class="input-form" disabled><%=m.getMemberContent()%></textarea>
			</div>
			<div class="input-wrap">
				<label for="enrollDate">가입일</label>
				<input type="text" name="enrollDate" id="enrollDate" class="input-form" value="<%=m.getEnrollDate()%>" disabled>
			</div>
			<div class="btn-box">
				<a class="btn1 bc4 bs5" href="/updateMemberFrm.do">정보수정</a>
				<a class="btn1 bc4 bs5" href="/deleteMember.do">회원탈퇴</a>
			</div>
        </div>
    </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>