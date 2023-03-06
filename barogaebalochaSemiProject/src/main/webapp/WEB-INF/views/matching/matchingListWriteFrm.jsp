<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <h2>매칭폼 작성</h2>
            <div class="matchinglistWriteFrm-input-wrap">
                <form action="/matchingListInsert.do?memberNo=<%=m.getMemberNo() %>" method="post">
                    <table class="tbl" id="matchinglistWriteFrm">
                    	<tr>
                            <th>매칭 제목</th>
                            <td>
                                <input type="text" class="input-form" name="matchingBoardTitle" value="제목을 작성해주세요" required>
                            </td>
                        </tr>
                        <tr>
                            <th>지역</th>
                            <td>
                                <select class="location-select-form" name="groundlocation">
                                    <option value="서울">서울</option>
                                    <option value="인천">인천</option>
                                    <option value="경기">경기</option>
                                </select>
                                <input type="button" value="구장조회하기" class="locationSearch btn1 bc1">
                             </td>
                        </tr>
                        <tr>
                            <th>경기장</th>
                            <td>
                                <input type="text" class="input-form" name="groundName" value="구장 지역을 먼저 선택해주세요"readonly>
                            </td>
                        </tr>
                        <tr>
                            <th>경기날짜</th>
                            <td>
                                <input type="text" class="input-form" id="datepicker" name="reservationDate" required >
                            </td>
                        </tr>
                        <tr>
                            <th>경기시간</th>
                            <td>
                                <select class="input-form" name="reservationTime">
                                    <option value="10">10 : 00 ~ 12 : 00</option>
                                    <option value="12">12 : 00 ~ 14 : 00</option>
                                    <option value="14">14 : 00 ~ 16 : 00</option>
                                    <option value="16">16 : 00 ~ 18 : 00</option>
                                    <option value="18">18 : 00 ~ 20 : 00</option>
                                    <option value="20">20 : 00 ~ 22 : 00</option>
                                    <option value="22">22 : 00 ~ 24 : 00</option>
                                    <option value="24">24 : 00 ~ 02 : 00</option>
                                </select>
                            </td>
                        </tr>
                        <!--
                        <tr>
                            <th>실력</th>
                            <td>
                                <input type="radio" name="level" class="btn1" id="1" value="1" checked>
                                <label for="1">최상</label>
                                <input type="radio" name="level" class="btn1" id="2" value="2">
                                <label for="2">상</label>
                                <input type="radio" name="level" class="btn1" id="3" value="3">
                                <label for="3">중</label>
                                <input type="radio" name="level" class="btn1" id="4" value="4">
                                <label for="4">하</label>
                                <input type="radio" name="level" class="btn1" id="5" value="5">
                                <label for="5">최하</label>                             
                            </td>
                        </tr>
                          -->
                        <tr>
                            <th>대여가격</th>
                            <td>
                                <input type="text" class="input-form input-price" value="" name="matchingPrice" readonly> <!-- ground price 자체를 띄워주기 -->
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea class="input-form content" name="matchingBoardContent" required></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <a href="/matchingList.do?reqPage=1" class="btn1 bc1">취소</a>
                                <input type="submit" class="btn1 bc1" value="완료">
                            </td>
                        </tr>
                    </table>          
                </form>
            </div>
        </div>
        <div class="modal-wrap">
	        <div class="login-modal">
	            <div class="modal-top">
	                <h2>구장 조회</h2>
	            </div>
	            <div class="modal-content">
	               
	                    <input type="text" class="modal-location" value="" readonly>
	                    <select class="modal-select-form" name="location">
                        </select>
                    	<div class="modal-btn-frm">
		                	<input type="submit" class="btn1 bc1 modal-btn" value="구장 선택">
		                    <input type="reset" class="btn1 bc1 modal-btn" value="취소">
	                    </div>
	                
	            </div>
	        </div>
    	</div>
	</div>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
   		let locationVal;
	    $( function() {
	      $( "#datepicker" ).datepicker({
	        changeMonth: true,
	        dayNames: ['월요일','화요일','수요일','목요일','금요일','토요일','일요일'],
	        dayNamesMin: ['월','화','수','목','금','토','일'],
	        monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	        minDate: 0,
	        maxDate: "+6M"
	      });
	    });
	    $(".locationSearch").on("click",function(){
	    	  $(".modal-wrap").css("display","flex");
	    	  locationVal = $(".location-select-form").val();
	    	  $(".modal-location").val(locationVal);
	    	  //console.log(locationVal)
	    	  const result = $(".modal-select-form");
	    	  result.empty();
	    	  //ajax시작
	    	   $.ajax({
	    		url : "/locationSearchList.do",
	    		type : "get",
	    		data : {groundLocation : locationVal},
	    		dataType : "JSON",
	    		success : function(data){
	    			console.log(data);
	    			if(data.length == 0){
	    				const option = $("<option value=''></option>");
    					option.append("해당 지역에 구장이 없습니다.");
    					result.append(option);
						}else{
	    				/*$(".modal-select-form").append()*/
	    				for(let i=0;i<data.length;i++){
	    					//const price = $(".input-price").val(data[i].groundPrice+"원");
	    					const option = $("<option value=''></option>");
	    					option.val(data[i].groundName+"<<2시간 "+data[i].groundPrice+"원>>");
	    					option.append(data[i].groundName+"<<2시간 "+data[i].groundPrice+"원>>");
	    					result.append(option);
	    					//console.log(data[i].groundName);
	    				}
	    			}
	    		}
	    	  });
	    });
	    $("input[type=reset]").on("click",function(){
	        $(".modal-wrap").css("display","none");
	    })
	    $(".modal-btn-frm>input:first-child").on("click",function(){
	    	//console.log($(this).parent().prev().val());
	    	const choice = $(this).parent().prev().val();
	    	console.log(choice);
	    	if(choice == ""){
	    		var input = $(".input-form[name=groundName]");
	    		input.val("");
	    		input.val(input.val() + "해당 지역에 구장이 없습니다." );
	    	}else{
	    		$(".input-form[name=groundName]").val(choice);
	    		var str = choice;
	    		var pattern = /<<(.*?)>>/;
	    		var result = str.match(pattern)[1];
	    		$(".input-price").val(result);
		    	$(".modal-wrap").css("display","none");
	    	}
	    });
	    $(".input-form[name=matchingBoardTitle]").on("click",function(){
	    	$(this).val("");
	    })
    </script>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>