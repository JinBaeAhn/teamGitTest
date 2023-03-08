<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.main-img{
		margin-top: 50px;
		margin-bottom: 30px;
	}
	.sub-img{
		width: 1200px;
		margin: 20px auto;
		text-align: center;
		margin-bottom: 20px;		
	}
	.sub-img>img{
		width: 200px;
		height: 130px;
		margin-left: 20px;
		margin-right: 20px;
		border-radius: 5px;
		transition-duration: 0.2s;
		opacity: 85%;
	}
	.sub-img>img:hover{
		transform: scale(1.02, 1.02);
		opacity: 100%;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
			<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval=3000>
	  			<div class="carousel-inner main-img">
	    			<div class="carousel-item active">
	      				<img src="/img/mainPageImage.jfif" class="d-block w-100" alt="...">
	    			</div>
	    			<div class="carousel-item">
	      				<img src="/img/mainPageImage1.jfif" class="d-block w-100" alt="...">
	    			</div>
	    			<div class="carousel-item">
	      				<img src="/img/mainPageImage2.jfif" class="d-block w-100" alt="...">
	    			</div>
	  			</div>
	  			<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
	    		<span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    		<span class="visually-hidden">Previous</span>
	  			</button>
	  			<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
	    		<span class="carousel-control-next-icon" aria-hidden="true"></span>
	    		<span class="visually-hidden">Next</span>
	  			</button>
			</div>
			<div class="sub-img">
				<img src="/img/subImage1.png">
				<img src="/img/subImage2.png">
				<img src="/img/subImage3.png">
				<img src="/img/subImage4.jpg">
			</div>
		<div class="content-list">		
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>