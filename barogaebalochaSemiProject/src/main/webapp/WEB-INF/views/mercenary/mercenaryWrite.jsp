<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <hr>
            <div class="mercenary-input-wrap">
                <form action="/mercenaryInsert.do" method="post">
                    <table class="tbl" id="mercenaryWrite">
                        <tr>
                            <th>지역</th>
                            <td>
                                <select class="input-form" name="location">
                                    <option value="seoul">서울</option>
                                    <option value="incheon">인천</option>
                                    <option value="3">경기</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>경기장</th>
                            <td>
                                <select class="input-form" name="groundName">
                                    <option value="1">서울어쩌구경기장</option>
                                    <option value="2">인천어쩌구경기장</option>
                                    <option value="3">경기어쩌구경기장</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>경기날짜</th>
                            <td>
                                <input type="text" class="input-form" id="datepicker" name="gameDate">
                            </td>
                        </tr>
                        <tr>
                            <th>경기시간</th>
                            <td>
                                <select class="input-form" name="gameTime">
                                    <option value="1">24 : 00 ~ 02 : 00</option>
                                    <option value="2">02 : 00 ~ 04 : 00</option>
                                    <option value="3">04 : 00 ~ 06 : 00</option>
                                    <option value="4">06 : 00 ~ 08 : 00</option>
                                    <option value="5">08 : 00 ~ 10 : 00</option>
                                    <option value="6">10 : 00 ~ 12 : 00</option>
                                    <option value="7">12 : 00 ~ 14 : 00</option>
                                    <option value="8">14 : 00 ~ 16 : 00</option>
                                    <option value="9">16 : 00 ~ 18 : 00</option>
                                    <option value="10">18 : 00 ~ 20 : 00</option>
                                    <option value="11">20 : 00 ~ 22 : 00</option>
                                    <option value="12">22 : 00 ~ 24 : 00</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>실력</th>
                            <td>
                                <input type="radio" name="level" class="btn1" id="1" value="1">
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
                                <input type="text" class="input-form" placeholder="금액입력" name="mercenaryPay">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea class="input-form content" name="mercenaryContent"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="reset" class="btn1 bc1" value="취소">
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
                $( "#datepicker" ).datepicker();
            } );
    </script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>