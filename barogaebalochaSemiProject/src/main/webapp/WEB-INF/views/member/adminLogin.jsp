<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@font-face {
    font-family: ns-thin;
    src: url(../font/NotoSansKR-Thin.otf);
}
@font-face {
    font-family: ns-light;
    src: url(../font/NotoSansKR-Light.otf);
}
@font-face {
    font-family: ns-m;
    src: url(../font/NotoSansKR-Medium.otf);
}
@font-face {
    font-family: ns-bold;
    src: url(../font/NotoSansKR-Bold.otf);
}
@font-face {
    font-family: ns-black;
    src: url(../font/NotoSansKR-Black.otf);
}
* {
    margin: 0;
    padding: 0;
    font-family: ns-m;
    color: #181818;
}
body{
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}
a {
    text-decoration: none;
}

header{
    border-bottom: 1px solid #ccc;
}

.header-wrap{
    width: 1200px;
    overflow: hidden;
    padding: 20px;
    margin: 0 auto;
    box-sizing: border-box;
}
.site-logo{
    float: left;
}
.site-logo>a>img{
    width: 300px;
    height: 70px;
}
.header-content{
    float: right;
}
.header-link{
    overflow: hidden;
    padding-top: 18px;
}
.header-link>a{
    float: right;
    padding-left: 10px;
    font-size: 13px;
}
.header-link>a:hover{
    color: #AACB73;
    transition-duration: 0.5s;
}
.header-content>.nav>.navi{
    list-style-type: none;
    margin-top: 10px;
}
.header-content>.nav>.navi>li{
    float: left;
    padding-left: 25px;
}
.header-content>.nav>.navi>li>a{
    font-size: 20px;
    font-family: ns-bold;
    border-radius: 5px;
}
/*REF*/
.page-content{
    width: 1200px;
    margin: 30px auto;
    margin-bottom: 10px;
    flex-grow: 1;
}
.menu{
    position: absolute;
    display: none;
    list-style: none;
    background-color: #c7e793;
    padding: 15px;
    border-radius: 5px;
}
a {
    text-decoration: none;
}
footer {
    background-color: #181818;
    padding: 30px;
    border-top: 1px solid #252a34;
}
footer > .footer-content {
    width: 1200px;
    margin: 0 auto;
    padding: 0px 10px;
}
footer > .footer-content * {
    font-size: 14px;
}
footer > .footer-content > ul {
    list-style-type: none;
    overflow: hidden;
    margin-bottom: 20px;
}
footer > .footer-content > ul > li {
    float: left;
}
footer > .footer-content > ul > li > a {
    padding-right: 20px;
    font-size: 15px;
    color: #fcfcfc;
}

footer > .footer-content>p{
    color: #fcfcfc;
}
	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
		 <div class="header-wrap">
	            <div class="site-logo">
	                <a href="/"><img src="img/FUTSALDATE.png"></a>
	            </div>
	            <div class="header-content">
	                <div class="header-link">
	                    <a href="#">JOIN</a>
	                    <a href="#">LOGIN</a>
	                </div>                
	                <div class="nav">
	                    <ul class="navi">
	                        <li><a href="#">정보수정</a></li>
	                        <li><a href="#">회원관리</a></li>
	                        <li><a href="#">구장등록</a></li>
	                        <li><a href="#">신고관리</a></li>
	                        <li>
	                            <a href="#" name="search">메뉴</a>
	                            <ul class="menu">
	                                <li><a href="#" class="searchBox">MATCHING</a></li>
	                                <li><a href="#" class="searchBox">용병모집</a></li>
	                                <li><a href="#" class="searchBox">구장</a></li>
	                                <li><a href="#" class="searchBox">공지사항</a></li>
	                                <li><a href="#" class="searchBox">게시판</a></li>
	                            </ul>
	                        </li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	    <script>
			$(".menu").prev().append("<span class='more'></span>");
			$(".more").on("click",function(event){
			    $(this).parent().next().slideToggle();
			    $(this).toggleClass("active");
			    event.stopPropagation();
			});
			$(".more").parent().on("click",function(){
			    $(this).children().last().click();
			});
		</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>