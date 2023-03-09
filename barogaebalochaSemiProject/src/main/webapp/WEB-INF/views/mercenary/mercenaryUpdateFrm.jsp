<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Mercenary mc = (Mercenary)request.getAttribute("mc");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>용병모집 글작성</title>
<!-- 캘린더  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<style>
    .tbl {
    width: 100%;
    border-spacing: 0px;
    border-collapse: collapse;
    }
    .tbl th,.tbl td {
        padding: 10px;
        text-align: center;
    }   
    .mercenary-input-wrap{
        padding: 20px;
    }
    .input-form{
        padding: 5px;
    }
    #mercenaryWrite th, #mercenaryWrite td{
        border: 1px solid #ccc;
    }
    #mercenaryWrite th{
        background-color: #181818;
        color: #fcfcfc;
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
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
            <h2>용병모집 작성</h2>
            <div class="mercenary-input-wrap">
                <form action="/mercenaryUpdate.do?mercenaryNo=<%=mc.getMercenaryNo() %>" method="post">
                    <table class="tbl" id="mercenaryWrite">
                        <tr>
                            <th>지역</th>
                            <td>
<<<<<<< HEAD
                            <input type="hidden" id="locationCode" value="<%=mc.getLocation()%>">
=======
                            	<input type="hidden" id="locationCode" value="<%=mc.getLocation()%>">
>>>>>>> 646873045dec6450ed6161cd61376e09c9a91dab
                                <select class="input-form" name="location" id="location">
                                	<option value="no">지역선택</option>
                                    <option value="seoul">서울</option>
                                    <option value="incheon">인천</option>
                                    <option value="Gyeonggi">경기</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                           <th>경기장</th>
                            <td>
                            	<input type="hidden" id="groundNoCode" value="<%=mc.getGroundNo()%>">
                                <select class="input-form" name="groundNo" id="ground"></select>
                            </td>
                        </tr>
                        <tr>
                            <th>경기날짜</th>
                            <td>
                                <input type="text" class="input-form" id="datepicker" name="gameDate" value="<%=mc.getGameDate() %>"required>
                            </td>
                        </tr>
                        <tr>
                            <th>경기시간</th>
                            <td>
                            	<input type="hidden" id="gameTimeCode" value="<%=mc.getGameTime() %>">
                                <select class="input-form" name="gameTime">
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
                        <tr>
                            <th>실력</th>
                            <td>
                            	<input type="hidden" id="levelCode" value="<%=mc.getLevel()%>">
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
                        <tr>
                            <th>참가비</th>
                            <td>
                                <input type="text" class="input-form" placeholder="금액입력" name="mercenaryPay" value="<%=mc.getMercenaryPay() %>" required>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea class="input-form content" name="mercenaryContent" required><%=mc.getMercenaryContent() %></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <a href="/mercenaryList.do?reqPage=1" class="btn1 bc1">취소</a>
                                <input type="submit" class="btn1 bc1" value="완료">
                            </td>
                        </tr>
                    </table>          
                </form>
            </div>
        </div> 
	</div>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
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
		 $(function(){
			const code = $("#locationCode").val();
			const options = $("[name=location]>option");
			options.each(function(index,item){
			   if($(item).val() == code){
				  console.log("함수실행")
			      $(item).prop("selected",true);
			      console.log(test11())
			   }
			  
			});
		});
	    $("#location").on("change" , test11);
	    function test11(){
	    	console.log("test 11 실행")
	    	const location = $("#location option:selected").text();
			const groundOption = $("#ground");
			groundOption.empty();
			$.ajax({
				url : "/searchGround.do",
				type : "post",
				data : {location : location},
				dataType : "json",
				success : function(data){
					if(data.length > 0){
						for(let i=0; i<data.length; i++){
							const option = $("<option value=''></option>");
							option.val(data[i].groundNo);
							option.append(data[i].groundName);
							groundOption.append(option);
						}	
						//groundNoCode
					}else{
						const option = $("<option value=''></option>");
						option.append("해당지역에 구장이 없습니다.");
						groundOption.append(option);
					}
				},
				error : function(){
					console.log("서버 호출 실패");
				}
			});
<<<<<<< HEAD
		}
	    
	    
=======
		});
	    
	    //지역
	    $(function(){
	       const code = $("#locationCode").val();
	       const options = $("[name=location]>option");
	       const groundOption = $("#ground");
	       options.each(function(index,item){
	          if($(item).val() == code){
	             $(item).prop("selected",true);
	             $.ajax({
	 				url : "/searchGround.do",
	 				type : "post",
	 				data : {location : code},
	 				dataType : "json",
	 				success : function(data){
	 					if(data.length > 0){
	 						console.log(data.length);
	 						for(let i=0; i<data.length; i++){
	 							const option = $("<option value=''></option>");
	 							option.val(data[i].groundNo);
	 							option.append(data[i].groundName);
	 							groundOption.append(option);
	 						}	
	 						
	 					}else{
	 						const option = $("<option value=''></option>");
	 						option.append("해당지역에 구장이 없습니다.");
	 						groundOption.append(option);
	 					}													
	 				},
	 				error : function(){
	 					console.log("서버 호출 실패");
	 				}
	 			}); 
	          }
	       });
	    });
	    
	    
	    //시간
	     $(function(){
	       const code = $("#gameTimeCode").val();
	       const options = $("[name=gameTime]>option");
	       options.each(function(index,item){
	          if($(item).val() == code){
	             $(item).prop("selected",true);
	          }
	       });
	    });
	    
	    //레벨
	    $(function(){
		       const code = $("#levelCode").val();
		       const radios = $("[name=level]");
		       radios.each(function(index,item){
		          if($(item).val() == code){
		             $(item).prop("checked",true);
		          }
		       });
		    });
	    
>>>>>>> 646873045dec6450ed6161cd61376e09c9a91dab
    </script>

	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>