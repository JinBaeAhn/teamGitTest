<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        margin-top: 0;
	}
    .wrap ul {
        list-style: none;
        padding-left: 0;
        max-width: 800px;
        
    }
    .wrap li {
        margin-bottom: 10px;
        padding: 10px;
    }
    .member{
        width: 100%;
        font-size: 20px;
    }
    .img{
        text-align: center;
    }
    .input-wrap{
        text-align: center;
    }
    #charge{
        float: right;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="wrap">
        <div class="page-content">
            <div class="page-title">내정보보기</div>
            <ul>
                <li class="img">사진</li>
                <li>아이디</li>
                <li>이름</li>
                <li>전화번호</li>
                <li>메일</li>
                <li>지역</li>
                <li>포인트<a href="#" class="btn1 bc1 bs1" id="charge">충전하기</a></li>
                <li>자기소개</li>
                <li>자기소개 상세</li>
                <div class="input-wrap">
                    <a href="#" class="btn1 bc1 bs1">정보수정</a>
                    <a href="#" class="btn1 bc1 bs1">회원탈퇴</a>
                </div>
            </ul>
        </div>
    </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>