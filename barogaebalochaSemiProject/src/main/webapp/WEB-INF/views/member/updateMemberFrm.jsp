<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .wrap{
		width: 100%;
		margin: 0 auto;
	}
	.page-title{
		font-size: 40px;
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
    #img-view{
        width: 200px;
        height: 200px;
        border-radius: 50%;
    }
    #imgFile{
    	display : none;
    }
    .agree-content{
        width: 100%;
        height: 100px;
        overflow: scroll;
        border: 1px solid #ccc;
        font-size: 12px;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<%
		String phone = m.getMemberPhone();
		String[] phoneArr = phone.split("-");
	%>
    <div class="wrap">
        <div class="page-content">
            <div class="page-title">정보수정</div>
                <form action="/updateMember.do" method="post" enctype="multipart/form-data">
                    <div class="input-wrap img-input">
                        <label for="imgFile">
                            <%if(m.getFilepath() == null){ %>
                            <img src="img/profile.png" id="img-view">
							<%}else{ %>
							<img src="/upload/photo/<%=m.getFilepath() %>" id="img-view">
							<%} %>
							<button type="button" class="btn bc1 delFile">삭제</button>
                            <input type="file" name="imgFile" id="imgFile" accept=".jpg,.png,.jpeg" onchange="loadImg(this);">
	    					<input type="hidden" name="oldImgFile" value="<%=m.getFilepath()%>">
                        </label>
                    </div>
                    <div class="input-wrap">
                        <label for="memberId">아이디</label>
                        <div class="id-wrap">
                            <input type="text" name="memberId" id="memberId" class="input-form" value="<%=m.getMemberId()%>" readonly>
                        </div>
                    </div>
                    <div class="input-wrap">
                    	<div>
                            <input type="text" name="memberPw" id="memberPw" class="input-form" value="<%=m.getMemberPw()%>" >
                        </div>
                        <label for="memberPw">새로운 비밀번호</label>
                        <div>
                            <input type="text" name="newMemberPw" id="newMemberPw" class="input-form" placeholder="비밀번호를 입력해주세요(8~16글자)" >
                        </div>
                        <span id="msg1"></span>
                    </div>
                    <div class="input-wrap">
                        <label for="memberPwRe">비밀번호 확인</label>
                        <div>
                            <input type="text" name="memberPwRe" id="memberPwRe" class="input-form" placeholder="비밀번호를 한번 더 입력해주세요">
                        </div>
                        <span id="msg2"></span>
                    </div>
                    <div class="input-wrap">
                        <label for="memberName">이름</label>
                        <input type="text" name="memberName" id="memberName" class="input-form" value="<%=m.getMemberName() %>" readonly>
                    </div>
                    <div class="input-wrap">
                        <label for="memberPhone">전화번호</label>
                        <div>
                            <select size="1" name="memberPhone1" id="memberPhone1" class="input-form-short" value="<%=phoneArr[0]%>">
                                <option value="010">010</option>
                                <option value="011">011</option>
                                <option value="016">016</option>
                                <option value="017">017</option>
                                <option value="018">018</option>
                                <option value="019">019</option>
                            </select>
                            <input type="text" name="memberPhone2" id="memberPhone2" class="input-form-short" value="<%=phoneArr[1]%>">
                            <input type="text" name="memberPhone3" id="memberPhone3" class="input-form-short" value="<%=phoneArr[2]%>">
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberAddr">지역</label>
                        <div>
                            <select size="1" name="memberAddr" id="memberAddr" class="input-form-short" value="<%=m.getMemberAddr()%>">
                                <option value="">지역선택</option>
                                <option value="서울">서울</option>
                                <option value="인천">인천</option>
                                <option value="부산">부산</option>
                                <option value="대구">대구</option>
                                <option value="대전">대전</option>
                                <option value="광주">광주</option>
                                <option value="울산">울산</option>
                                <option value="세종">세종</option>
                                <option value="경기">경기</option>
                                <option value="강원">강원</option>
                                <option value="충북">충북</option>
                                <option value="충남">충남</option>
                                <option value="전북">전북</option>
                                <option value="전남">전남</option>
                                <option value="경북">경북</option>
                                <option value="경남">경남</option>
                                <option value="제주">제주</option>
                            </select>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberMail">메일</label>
                        <div>
                            <input type="text" name="memberMail" id="memberMail" class="input-form" value="<%=m.getMemberMail() %>" readonly>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberContent">자기소개</label>
                        <textarea name="memberContent" id="memberContent" class="input-form"><%=m.getMemberContent() %></textarea>
                    </div>
                    <button type="submit" class="btn bc1 bs4" >정보수정</button>
                </form>
            </div>
        </div>
        <script>
        const addr = $("#memberAddr").attr("value");
        $("#memberAddr>option").each(function(index,item){
        	if($(item).val() == addr){
        		$(item).prop("selected",true);
        	}
        });
        const phone1 = $("#memberPhone1").attr("value");
        $("#memberPhone1>option").each(function(index,item){
        	if($(item).val() == phone1){
        		$(item).prop("selected",true);
        	}
        });
        console.log(phone1);
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
    	
        $("#newMemberPw").on("focus",function(){
    		const inputType = $(this).attr("type");
            if(inputType === "text"){
                $(this).attr("type","password");
            }
        });
        $("#memberPwRe").on("focus",function(){
    		const inputType = $(this).attr("type");
            if(inputType === "text"){
                $(this).attr("type","password");
            }
    	});
        $("#newMemberPw").on("keyup",function(){
            const pw = $(this).val();
            const regExp = /^[a-z0-9]{8,16}$/;
            if(regExp.test(pw)){
                $("#msg1").text("비밀번호가 적합합니다.");
                $("#msg1").css("color","green");
                $(this).css("border","1px solid green");
            }else{
                $("#msg1").text("비밀번호가 적합하지 않습니다.");
                $("#msg1").css("color","red");
                $(this).css("border","1px solid red");
            }
        });
        $("#memberPwRe").on("change",function(){
            const pw = $("#newMemberPw").val();
            const pwRe = $(this).val();
            if(pw == pwRe){
                $("#msg2").text("비밀번호가 일치합니다.");
                $("#msg2").css("color","green");
                $(this).css("border","1px solid green");
            }else{
                $("#msg2").text("비밀번호가 일치하지 않습니다.");
                $("#msg2").css("color","red");
                $(this).css("border","1px solid red");
            }
        });
        $("button.delFile").on("click",function(){
			
			$("[name=oldImgFile]").val("");
		});
        
        </script>
        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
	   </body>
</html>