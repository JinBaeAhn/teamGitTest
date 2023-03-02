<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
.tbl {
    width: 100%;
    border-spacing: 0px;
    border-collapse: collapse;
    margin-top: 20px;
}
.tbl th,
.tbl td {
    padding: 1rem;
    text-align: center;
    border: solid 2px #ccc;
}
.tbl .tr-1 {
    background-color: #fefefe;
}
.tbl .td-1 {
    background-color: #fefefe;
    color: rgba(37, 42, 52, 1);
    
}
.tbl.tbl-hover .tr-1:hover {
    background-color: rgba(0, 0, 0, 0.05);
}

.input-form:focus {
    box-shadow: 0 0 0 0.1rem #eee;
}

textarea.input-form {
    resize: none;
    min-height: 300px;
}
.input-form:read-only:not(select),
.input-form:disabled {
    background-color: #f7f7f9;
}

.btn11{
    border: none;
    padding: 0.8rem;
    display: inline-block;
    box-sizing: border-box;
    transition-duration: 0.5s;
    font-size: 15px;
    border-radius: 5px;
    margin: 0 auto;
}
.bc33{
    margin-left: 25px;
}
.page-title{
    margin-bottom: 20px;
}
input[name="f"]{
    margin: 10px;
}
.bc66{
    color: rgba(37, 42, 52, 1);
    background-color: #fff;
    border: 2px solid rgba(238, 238, 238, 1);
}
.bc66:hover {
    background-color: rgba(238, 238, 238, 1);
    cursor: pointer;
    color: rgba(37, 42, 52, 1);
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="page-content">
		<div class="page-title">구장 등록</div>
		<form action="/locationInsertWrite.do" method="post" enctype="multipart/form-data">
        <div class="address-wrap">
            <input type="text" name="postcod" id="postcode"
            class="input-form" readonly style="width:90%; display:inline-block;" placeholder="구장찾기">
            <button  type="button" class="btn11 bc33" onclick="searchAddr();">주소찾기</button>
            <input type="text" name="address" id="address"
			class="input-form" readonly>
			<input type="text" name="detailAddress" id="detailAddress"
			class="input-form">
        </div>
			<table class="tbl" id="locationInsertWrite">
				<tr class="tr-1">
					<th class="td-1">구장이름</th>
					<td colspan="3">
						<input type="text" name="noticeTitle" class="input-form">
					</td>
                    </tr>
                <tr>
                    <td colspan="4">
                        <input id="1" type="checkbox" name="f" value="1">
                        <label for="1">샤워실</label>
                        <input id="2" type="checkbox" name="f" value="2">
                        <label for="2">풋살화</label>
                        <input id="3" type="checkbox" name="f" value="3">
                        <label for="3">유니폼</label>
                        <input id="4" type="checkbox" name="f" value="4">
                        <label for="4">축구공</label>
                        <input id="5" type="checkbox" name="f" value="5">
                        <label for="5">주차</label>
                        <input id="6" type="checkbox" name="f" value="6">
                        <label for="6">물제공</label>
                    </td>
				</tr>
				<tr class="tr-1">
					<th class="td-1">첨부파일</th>
					<td><input type="file" name="upfile"></td>
				</tr>
				<tr class="tr-1">
					<td colspan="4" style="text-align:left;">
						<textarea id="groundContent" name="groundContent" class="input-form" placeholder="구장설명"></textarea>
					</td>
				</tr>
				<tr class="tr-1">
					<td colspan="4">
						<button type="submit" class="btn11 bc66 bs4">구장등록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script>
	function searchAddr(){
		 new daum.Postcode({
		        oncomplete: function(data) {
		        	console.log(data);
		        	$("#postcode").val(data.zonecode);
		        	$("#address").val(data.address);
		        	$("#detailAddress").focus();
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		        }
		    }).open();
	}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>