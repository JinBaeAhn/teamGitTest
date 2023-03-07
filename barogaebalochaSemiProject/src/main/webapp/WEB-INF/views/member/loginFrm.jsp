<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .page-title{
		font-size: 40px;
	}
    .input-wrap{
        width: 600px;
		padding : 20px;
        margin: 0 auto;
	}
    .input-form-short{
        width: 100%;
        padding: 0.8rem;
        background-color: #fff;
        outline: none;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    .input-form-short:focus {
        box-shadow: 0 0 0 0.1rem #eee;
    }
    .btn-wrap>a{
        width: 49%;
        text-align: center;
    }
    .btn-wrap{
        text-align: center;
    }
    #log-img{
        width: 100%;
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
	  margin-top: 20px;
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
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="wrap">
        <div class="page-content">
            <div class="page-title">로그인</div>
            <form action="/login.do" method="post">
                <div class="input-wrap">
                    <label for="memberId">아이디</label>
                    <div class="id-wrap">
                        <input type="text" name="memberId" id="memberId" class="input-form-short" placeholder="아이디를 입력해주세요" required>
                    </div>
                </div>
                <div class="input-wrap">
                    <label for="memberPw">비밀번호</label>
                    <div>
                        <input type="password" name="memberPw" id="memberPw" class="input-form-short" placeholder="비밀번호를 입력해주세요" required>
                    </div>
                </div>
                <div class="input-wrap">
                    <button type="submit" class="btn1 bc1 bs4">로그인</button>
                </div>
            </form>
            <div class="input-wrap btn-wrap">
                <a id="searchId" class="btn1 bc2 bs3">아이디/비밀번호 찾기</a>
                <div id="pay-modal" class="modal-bg">
      				<div class="modal-wrap">
        				<div class="modal-head">
          					<h2>아이디/비밀번호 찾기</h2>
          					<span class="material-icons close-icon modal-close">close</span>
        				</div>
	        			<div class="modal-content">
          					<div class="input-box">
	     						<form>
	          						<label for="memberName">이름</label>
                      				<input type="text" name="memberName" id="memberName" class="input-form-short" placeholder="성함을 입력해주세요" required>
                      				<label for="memberPhone">연락처</label>
                      				<input type="text" name="memberPhone" id="memberphone" class="input-form-short" placeholder="전화번호를 입력해주세요" required>
	                    			<button type="button" id="checkId" class="btn bc1">아이디 조회</button>
    	            			</form>
	                    		<span id="idResult"></span>
                    		</div>
                			<div class="input-box">
                    			<form>
                    				<label for="searchId">아이디</label>
 				                	<input type="text" name="searchId" id="searchId" class="input-form-short" placeholder="아이디를 입력해주세요" required>
                    			    <label for="searchPhone">연락처</label>
 				                	<input type="text" name="searchPhone" id="searchPhone" class="input-form-short" placeholder="전화번호를 입력해주세요" required>
 									<label for="searchMail">이메일</label>
 				                	<input type="text" name="searchMail" id="searchMail" class="input-form-short" placeholder="이메일을 입력해주세요" required>                   			
                    				<button type="button" id="passwordSendBtn" class="btn bc1">임시비밀번호 발송</button>
                    			</form>
                    			<span id="passwordResult"></span>
                			</div>
	        				<div class="modal-foot">
		          				<button type="button" class="btn bc1 modal-close">취소</button>
                			</div>
	        			</div>
      				</div>
    			</div>
                <a href="/joinFrm.do" class="btn1 bc22 bs3">회원가입</a>
            </div>
            <div class="input-wrap">
                <a href="/">
                    <img src="/img/FUTSALDATE.png" id="log-img">
                </a>
            </div>
        </div>
    </div>
    <script>
     $(function () {
    	  $(document).on("click", "#searchId", function () {
    	    $(".modal-bg").css("display", "flex");
    	  });
    	  $(document).on("click", ".modal-close", function () {
    	    $(this).closest(".modal-bg").css("display", "none");
    	  });  
    	  $(".sub-navi").prev().after("<span class='material-icons dropdown'>expand_more</span>");
    	});
     $(document).ready(function() {
     	$("#checkId").on("click", function() {
			const memberName = $("[name=memberName]").val();
			const memberPhone = $("[name=memberPhone]").val();
				$.ajax({
					url: "/checkId.do",
					type: "GET",
					data: {memberName: memberName, memberPhone: memberPhone},
					dataType: "text",
					success: function(data) {
						if(data == "0") {
							$("#idResult").text("아이디를 조회할 수 없습니다.");
						} else {
							$("#idResult").text("귀하의 아이디는 " + data + "입니다.");
						}
					},
					error: function() {
						alert("서버 오류가 발생했습니다.");
					}
				});
			});
	});
     let mailCode;
     $(document).ready(function() {
      	$("#passwordSendBtn").on("click", function() {
 			const memberId = $("[name=searchId]").val();
 			const memberPhone = $("[name=searchPhone]").val();
 			const memberMail = $("[name=searchMail]").val();
 				$.ajax({
 					url: "/passwordSend.do",
 					type: "post",
 					data: {memberId: memberId, memberPhone: memberPhone, memberMail: memberMail},
 					dataType: "text",
 					success: function(data) {
 						if(data == "0") {
 							$("#passwordResult").text("비밀번호를 발송할 수 없습니다.");
 						}else if(data == ""){
 							$("#passwordResult").text("서버 응답이 잘못되었습니다.");
 						}else {
 							mailCode = data;
 							$("#passwordResult").text("임시비밀번호를 발송했습니다. 다시 로그인해주세요");
 						}
 					},
 					error: function() {
 						alert("서버 오류가 발생했습니다.");
 					}
 				});
 			});
 	});

     </script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>