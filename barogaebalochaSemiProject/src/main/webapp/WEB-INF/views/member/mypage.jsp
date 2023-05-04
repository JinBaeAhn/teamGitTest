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
	.mypage-wrap{
		margin: 10px;
	}
	.btn-box{
    	padding-top: 20px;
    	width: 100%;
    	text-align : center;
    	display: flex;
    	justify-content: space-between;
    	height : auto;
    	
    }
    .btn-box a{
    	line-height :center;
    }
    
    .td1{
    	border-bottom: 1px solid #ccc;
    	height: 60px;
    }
    
    .mypage-tbl{
    	width: 100%;
    	margin-top : 50px; 
    }
    /* 전체 테이블 스타일 */
	table {
  		border-collapse: collapse;
  		width: 100%;
  		
	}

/* 테이블 셀 스타일 */
	td, th {
  		border: 1px solid #ddd;
  		padding: 8px;
  		text-align: left;
	}

/* 짝수 행 배경색 */
	tr:nth-child(even) {
  		background-color: #f2f2f2;
	}

/* 이미지 부분 스타일 */
	.img-wrap {
  		position: relative;
  		width: 200px;
  		height: 200px;
  		margin: 0 auto;
  		border-radius: 50%;
  		overflow: hidden;
  		background-color: #ddd;
	}

	.img-wrap img {
  		display: block;
  		width: 250px;
  		
  		
	}

/* Introduce 셀 스타일 */
	.introduce {
  		position: relative;
	}

	.introduce textarea {
  		width: 100%;
  		height: 120px;
  		resize: none;
  		border: none;
  		background-color: transparent;
  		font-size: 16px;
  		font-family: Arial, sans-serif;
  		line-height: 1.5;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	 <div class="wrap">
        <div class="mypage-wrap">
            <div class="user-title"><h2><%=m.getMemberName()%>'s Locker Room</h2></div>
            <div class="btn-box">
                <a class="btn bc44 bs1" href="/historyMatching.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=matching">
                내가 쓴 글 조회</a>
                <a class="btn bc44 bs1" href="/updateMemberFrm.do">정보수정</a>
                <a class="btn bc44 bs1" id="charge">충전하기</a>
                <a class="btn bc44 bs1" id="deleteMember" href="/deleteMember.do">회원탈퇴</a>
            </div>
            <div class="mypage-content">
                <table class="mypage-tbl">
                    <tr class="td1">
                        <th>ID</th>
                        <td><%=m.getMemberId()%></td>
                        <td rowspan="5" >
                            <div class="img-wrap">
                                <label for="imgFile">
                                <%if(m.getFilepath() == null){ %>
                                    <img src="img/profile.png" id="img-view">
                                <%}else{ %>
                                    <img src="/upload/photo/<%=m.getFilepath() %>" id="img-view">
                                <%} %>
                                </label>
                            </div>
                        </td>
                    </tr>
                    <tr class="td1">
                        <th>PlayerName</th>
                        <td><%=m.getMemberName()%></td>
                    </tr>
                    <tr class="td1">
                        <th>Phone</th>
                        <td><%=m.getMemberPhone()%></td>
                    </tr>
                    <tr class="td1">
                        <th>Grade</th>
                        <td>
                            <%if(m.getMemberLevel() == 1) {%>
								<span>관리자</span>
							<%}else if(m.getMemberLevel() == 2){%>
								<span>정회원</span>
							<%}else if(m.getMemberLevel() == 3){%>
								<span>블랙</span>
							<%} %>
                        </td>
                    </tr>
                    <tr class="td1">
                        <th>Point</th>
                        <td><%=m.getMemberCredit()%><span>P</span></td>
                    </tr>
                    <tr class="td1">
                        <th>Range</th>
                        <td colspan="2"><%=m.getMemberAddr()%></td>
                        <td></td>
                    </tr>
                    <tr class="td1">
                        <th>JoinDate</th>
                        <td colspan="2"><%=m.getEnrollDate()%></td>
                        <td></td>
                    </tr>
                    <tr class="td1">
                        <th>Introduce</th>
                        <td class="introduce" colspan="2">
                        	<textarea name="memberContent" id="memberContent" class="input-form" readonly><%=m.getMemberContent() %></textarea>
                        </td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <div class="input-wrap">
                <div id="pay-modal" class="modal-bg">
                    <div class="modal-wrap">
                        <div class="modal-head">
                            <h2>결제하기</h2>
                            <span class="material-icons close-icon modal-close">close</span>
                        </div>
                            <div class="modal-content">
                                <div class="input-box">
                                    <span>충전포인트</span>
                                    <div class="input-box credit-box">
                                        <input type="radio" name="point" id="point1" value="10000">
                                        <label for="point1">10,000p</label>
                                        <input type="radio" name="point" id="point2" value="20000">
                                        <label for="point2">20,000p</label>
                                        <input type="radio" name="point" id="point3" value="50000">
                                        <label for="point3">50,000p</label>
                                        <input type="radio" name="point" id="point4" value="100000">
                                        <label for="point4">100,000p</label>
                                        <input type="radio" name="point" id="point5" value="200000">
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
        </div>        
			<div class="input-wrap">
				<input type="hidden" name="memberMail" id="memberMail" class="input-form" value="<%=m.getMemberMail()%>" disabled>
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
		const memberId = $("#memberId").val();
		const memberCredit = $("#memberCredit").val();
		
		const date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
		
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
				$("#newMemberCredit").val(price);
				$("#updateCredit").click();
				location.href="/updateMemberCredit.do?memberId="+memberId+"&memberCredit="+memberCredit+"&newMemberCredit="+price;
			}else{
				alert("결제실패");
			}
		});
	});
    $('#deleteMember').click(function(event) {
        event.preventDefault(); // 링크 클릭 시, 페이지 이동을 막음
        const confirmDelete = confirm('정말로 탈퇴하시겠습니까?'); // 한번 더 확인창을 띄움
        if (confirmDelete) {
          window.location.href = $(this).attr('href'); // 확인 시, 탈퇴 페이지로 이동
        }
      });
    </script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>