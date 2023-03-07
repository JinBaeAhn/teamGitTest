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
    .modal-bg {
	  background-color: rgba(0, 0, 0, 0.3);
	  position: fixed;
	  width: 100%;
	  height: 100vh;
	  display: none;
	  align-items: center;
	  flex-direction: column;
	  top: 0;
	  left: 0;
	}
	.modal-wrap {
	  margin-top: 150px;
	  width: 600px;
	  background: #fff;
	  height: auto;
	}
	.modal-wrap div {
	  padding: 1rem;
	}
	.modal-wrap div:not(:last-child) {
	  border-bottom: 1px solid #ccc;
	}
	.modal-wrap .modal-foot {
	  text-align: right;
	}
	.modal-wrap div.modal-head {
	  position: relative;
	}
	.close-icon {
	  position: absolute;
	  top: 16px;
	  right: 16px;
	  font-size: 30px;
	}
	.close-icon:hover {
	  cursor: pointer;
	}
	.credit-box{
		display: flex;
  		justify-content: space-between;
  		align-items: center;
	}
	.bi-box>img{
		width:200px;
		
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
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
				<a class="btn bc4 bs5" id="charge">충전하기</a>
				<div id="login-modal" class="modal-bg">
      				<div class="modal-wrap">
        				<div class="modal-head">
          					<h2>결제하기</h2>
          					<span class="material-icons close-icon modal-close">close</span>
        				</div>
	        				<div class="modal-content">
	          					<div class="input-box">
	          						<span>충전포인트</span>
	          						<div class="input-box credit-box">
	          							<input type="radio" name="point" id="point1" value="100">
	          							<label for="point1">10,000p</label>
	          							<input type="radio" name="point" id="point2" value="200">
	          							<label for="point2">20,000p</label>
	          							<input type="radio" name="point" id="point3" value="500">
	          							<label for="point3">50,000p</label>
	          							<input type="radio" name="point" id="point4" value="1000">
	          							<label for="point4">100,000p</label>
	          							<input type="radio" name="point" id="point5" value="2000">
	          							<label for="point5">200,000p</label>
	          						</div>
	          						<div class="input-box bi-box">
	          							<img src="img/FUTSALDATE.png">
	          						</div>
	          					</div>
	        				</div>
	        				<div class="modal-foot">
	          					<button type="button" id="payBtn" class="btn bc11">결제하기</button>
	          					<button type="button" class="btn bc1 modal-close">취소</button>
	        				</div>
      				</div>
    			</div>
			</div>
			<div class="input-wrap">
				
				<input type="hidden" name="memberMail" id="memberMail" class="input-form" value="<%=m.getMemberMail()%>" disabled>
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
				<a class="btn1 bc4 bs5" href="/history.do?memberNo=<%=m.getMemberNo() %>&reqPage=1&categoryName='matching'">내가 쓴 글 조회</a>
				<a class="btn1 bc4 bs5" href="/updateMemberFrm.do">정보수정</a>
				<a class="btn1 bc4 bs5" href="/deleteMember.do">회원탈퇴</a>
			</div>
        </div>
    </div>
    <script>
    $(function () {
    	  $(document).on("click", "#charge", function () {
    	    $(".modal-bg").css("display", "flex");
    	  });
    	  $(document).on("click", ".modal-close", function () {
    	    $(this).closest(".modal-bg").css("display", "none");
    	  });  
    	  $(".sub-navi").prev().after("<span class='material-icons dropdown'>expand_more</span>");
    	});
    $("#payBtn").on("click",function(){
    	$(".modal-bg").css("display", "none");
		const price = $("input[name=point]:checked").val();
		const d = new Date();
		
		const memberMail = $("#memberMail").val();
		const memberName = $("#memberName").val();
		const memberPhone = $("#memberPhone").val();
		
		const date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
		console.log(price);
		IMP.init("imp35435215");
		IMP.request_pay({
			pg : "html5_inicis",
			pay_method : "card",
			merchant_uid: "상품번호_"+date,//상점에서 관리하는 주문번호
			name: "풋살데이트",//결제이름
			amount : price,
			buyer_email: memberMail,
			buyer_name: memberName,
			buyer_tel: memberPhone
		},function(rsp){
			if(rsp.success){
				alert("결제성공");
				//결제관련 정보를 DB insert하는 작업이 필요
			}else{
				alert("결제실패");
			}
		});
	});
    </script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>