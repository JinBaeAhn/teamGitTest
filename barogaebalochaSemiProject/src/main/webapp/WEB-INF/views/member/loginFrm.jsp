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
                <a href="/searchPw.do" class="btn1 bc2 bs3">비밀번호 찾기</a>
                <a href="/joinFrm.do" class="btn1 bc22 bs3">회원가입</a>
            </div>
            <div class="input-wrap">
                <a href="/">
                    <img src="/img/FUTSALDATE.png" id="log-img">
                </a>
            </div>
        </div>
    </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>