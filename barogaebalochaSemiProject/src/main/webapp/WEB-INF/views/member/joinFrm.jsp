<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap{
		width: 1200px;
		margin: 0 auto;
	}
	.page-title{
		font-size: 20px;
	}
	.input-wrap>img{
		width: 100px;
		height: 100px;
	}
	.img-input{
		text-align: center;
	}
	.id-input{
		width: 70%;
   		padding: 0.8rem;
    	background-color: #fff;
    	outline: none;
    	border: 1px solid #ccc;
    	box-sizing: border-box;
	}
	.input-wrap{
		padding-top : 20px;
	}
    .phoneSel{
        width: 100px;
    }
    .input-form-short{
        width: 20%;
        padding: 0.8rem;
        background-color: #fff;
        outline: none;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    .input-form-short:focus {
        box-shadow: 0 0 0 0.1rem #eee;
    }
    .img-input>label{
        width: 100px;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="wrap">
        <div class="page-content">
            <div class="page-title">회원가입</div>
                <form name="checkIdFrm" action="/checkId.do" >
                    <input type="hidden" name="checkId">
                </form>
                <form action="/join.do" method="post">
                    <div class="input-wrap img-input">
                        <label for="imgFile">
                            <img src="img/profile.png" id="img-view">
                        </label>
                        <input type="file" name="imgFile" id="imgFile" onchange="loadImg(this);">
                    </div>
                    <div class="input-wrap">
                        <label for="memberId">아이디<span id="ajaxCheckId"></span></label>
                        <div class="id-wrap">
                            <input type="text" name="memberId" id="memberId" class="id-input" placeholder="아이디를 입력해주세요">
                            <button type="button" id="idChkBtn" class="btn2 bc1 bs1">중복체크</button>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberPw">비밀번호</label>
                        <div>
                            <input type="password" name="memberPw" id="memberPw" class="id-input">
                        </div>
                        <span></span>
                    </div>
                    <div class="input-wrap">
                        <label for="memberPwRe">비밀번호 확인</label>
                        <div>
                            <input type="password" name="memberPwRe" id="memberPwRe" class="id-input">
                        </div>
                        <span></span>
                    </div>
                    <div class="input-wrap">
                        <label for="memberName">이름</label>
                        <input type="text" name="memberName" id="memberName" class="input-form"placeholder="실명을 입력해주세요">
                        <span></span>
                    </div>
                    <div class="input-wrap">
                        <label for="memberPhone">전화번호</label>
                        <div>
                            <select size="1" name="memberPhone1" class="input-form-short">
                                <option>010</option>
                                <option>011</option>
                                <option>016</option>
                                <option>017</option>
                                <option>018</option>
                                <option>019</option>
                            </select>
                            <input type="text" name="memberPhone2" id="memberPhone2" class="input-form-short" placeholder="'-'없이 입력해주세요">
                            <input type="text" name="memberPhone3" id="memberPhone3" class="input-form-short"placeholder="'-'없이 입력해주세요">
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberAddr">지역</label>
                        <div>
                            <select size="1" name="memberAddr" id="memberAddr" class="input-form-short">
                                <option>지역선택</option>
                                <option>서울</option>
                                <option>인천</option>
                                <option>부산</option>
                                <option>대구</option>
                                <option>대전</option>
                                <option>광주</option>
                                <option>울산</option>
                                <option>세종</option>
                                <option>경기</option>
                                <option>강원</option>
                                <option>충북</option>
                                <option>충남</option>
                                <option>전북</option>
                                <option>전남</option>
                                <option>경북</option>
                                <option>경남</option>
                                <option>제주</option>
                            </select>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberMail">메일</label>
                        <div>
                            <input type="text" name="memberMail1" id="memberMail1" class="input-form-short" placeholder="이메일을 입력해주세요">
                            <span>@</span>
                            <input type="text" name="memberMail2" id="memberMail2" class="input-form-short">
                            <select size="1" class="input-form-short" id="mailSel">
                                <option value="">직접입력</option>
                                <option value="naver.com">네이버</option>
                                <option value="gmail.com">구글</option>
                            </select>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="mailChk">이메일 인증</label>
                        <div>
                            <input type="text" name="mailChk" id="mailChk" class="input-form-short" placeholder="인증문자를 입력해주세요.">
                            <button type="button" id="mailChkBtn" class="btn2 bc1 bs1">인증메일발송</button>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberContent">자기소개</label>
                        <textarea name="memberContent" id="memberContent" class="input-form"></textarea>
                    </div>
                    <div class="input-wrap">
                        <input type="checkbox" name="all-agree" id="all-agree"><span>전체약관선택</span>
                        <div class="agree">
                            <input type="checkbox" name="agree1" id="agree1"><span>개인정보 처리 방침에 동의합니다.</span>
                            <div class="agree1-content">
                                <p>개인정보 처리</p>
                                
                            </div>
                        </div>
                        <div class="agree">
                            <input type="checkbox" name="agree2" id="agree2"><span>서비스 이용약관에 동의합니다.</span>
                            <div class="agree2-content">
                                <p>서비스 이용약관</p>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn bc1 bs4" >회원가입</button>
                </form>
            </div>
        </div>
        <script>
            function loadImg(f){
                if(f.files.length !=0 && f.files[0] !=0){
                    const reader = new FileReader();
                    reader.readAsDataURL(f.files[0]);
                    reader.onload = function(e){
                        $("#img-view").attr("src",e.target.result);
                    }
                }else{
                    $("#img-view").attr("src","img/profile.png");
                }
            }
            $("#idChkBtn").on("click",function(){
                const memberId = $("#memberId").val();
                if(memberId == ""){
                    alert("아이디를 입력하세요");
                    return;
                }
                    
                $("[name=checkId]").val(memberId);
                window.open("","checkId","left=700px,top=300px,width=300px,height=200px,menubar=no,status=no,scrollbars=yes");
                $("[name=chackIdFrm]").attr("target","checkId");
                $("[name=checkIdFrm]").submit();
            });

            $("#memberId").on("keyup",function(){
                const memberId = $(this).val();
                $.ajax({
                    url : "/ajaxCheckId.do",
                    type : "get",
                    data : {memberId, memberId},
                    success : function(data){
                        if(data == "1"){
                            $("#ajaxCheckId").text("이미 사용중인 아이디입니다.");
                            $("#ajaxCheckId").css("color","red");
                            $("#memberId").css("border","1px solid red");
                        }else if(data == "0"){
                            $("#ajaxCheckId").text("사용가능한 아이디입니다.");
                            $("#ajaxCheckId").css("color","green");
                            $("#memberId").css("border","1px solid green");
                        }
                    }
                })
            });
            $("#mailSel").on("change",function(){
                const mail = $(this).children().val();
                    $("#memberMail2").val() = mail;
            });
        </script>
        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
	   </body>
</html>