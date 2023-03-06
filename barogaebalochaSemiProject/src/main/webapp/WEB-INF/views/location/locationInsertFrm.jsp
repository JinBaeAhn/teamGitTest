<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=lfdl00llsq&submodules=geocoder"></script>
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
.naverMap{
	display: none;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="page-content">
		<div class="page-title">구장 등록</div>
		<form action="/locationInsertWrite.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="groundLat" id="groundLat" value="">
		<input type="hidden" name="groundLng" id="groundLng" value="">
        <div class="address-wrap">
            <input type="text" name="postcod" id="postcode"
            class="input-form" readonly style="width:90%; display:inline-block;" placeholder="구장찾기">
            <button  type="button" class="btn11 bc33" onclick="searchAddr();">주소찾기</button>
            <div class=naverMap id="map" style="width:100%; height:500px;"></div>
            <input type="text" name="address" id="address"
			class="input-form" readonly>
			<input type="text" name="detailAddress" id="detailAddress"
			class="input-form">
        </div>
			<table class="tbl" id="locationInsertWrite">
				<tr class="tr-1">
					<th class="td-1">구장이름</th>
					<td colspan="3">
						<input type="text" name="groundName" class="input-form">
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
	const map = new naver.maps.Map("map",{
		center : new naver.maps.LatLng(37.533837,126.896836),
		zoom : 17,
		zoomControl : true,
		zoomControlOptions : {
			position : naver.maps.Position.TOP_RIGHT,
			style : naver.maps.ZoomControlStyle.SMALL
		}
	});

	const marker = new naver.maps.Marker({
		position : new naver.maps.LatLng(37.533837,126.896836),
		map : map
	});
	let contentString = [

	].join("");
	let infoWindow = new naver.maps.InfoWindow();
	
	//marker에 클릭이벤트 추가
	naver.maps.Event.addListener(marker,"click",function(e){
		infoWindow = new naver.maps.InfoWindow({
			content : contentString
		});
		//생성된 infoWindow를 map의 marker위치에 생성
		infoWindow.open(map,marker);
	});
	//map에 클릭이벤트 추가
	naver.maps.Event.addListener(map,"click",function(e){
		marker.setPosition(e.coord);//클릭한 위치로 마커 이동
		map.setCenter(e.coord);//클릭한 위치로 지도 중심 이동
		if(infoWindow.getMap()){//정보창이 지도위에 올라가 있으면 사라짐
			infoWindow.close();
		}
		//위경도를 통해서 해당 위치의 주소를 알아내기(reverseGecode)
		naver.maps.Service.reverseGeocode({
			location : new naver.maps.LatLng(e.coord.lat(),e.coord.lng())
		},function(status,response){
			if(status != naver.maps.Service.Status.OK){
				return alert("주소를 찾을 수 없습니다.");
			}
			console.log(response);
			const address = response.result.items[1].address;
			contentString = [
				"<div class='iw_inner'>",
				"    <p>"+address+"</p>",
				"</div>"
			].join("");
		});
	});

	function loadMap(){
		const addr = $("#address").val();
		naver.maps.Service.geocode({
			address : addr
		},function(status, response){
			if(status === naver.maps.Service.Status.ERROR){//자바스크립트 타입비교 ===
				return alert("조회 에러");
			}
			console.log(response);
			const lng = response.result.items[1].point.x;//경도
			const lat = response.result.items[1].point.y;//위도
			//위경도 객체
			const latlng = new naver.maps.LatLng(lat,lng);
			map.setCenter(latlng);
			marker.setPosition(latlng);
		});
	}
	function searchAddr(){
		 new daum.Postcode({
		        oncomplete: function(data) {
		        	console.log(data);
		        	$("#postcode").val(data.zonecode);
		        	$("#address").val(data.address);
		        	const addr = data.address;
		        	$("#detailAddress").focus();
		        	naver.maps.Service.geocode({
		    			address : addr
		    		},function(status, response){
		    			if(status === naver.maps.Service.Status.ERROR){//자바스크립트 타입비교 ===
		    				return alert("조회 에러");
		    			}
		    			console.log(response);
		    			const lng = response.result.items[1].point.x;//경도
		    			const lat = response.result.items[1].point.y;//위도
		    			//위경도 객체
		    			const latlng = new naver.maps.LatLng(lat,lng);
		    			map.setCenter(latlng);
		    			marker.setPosition(latlng);
		    			$("#groundLat").val(lat);
		    			$("#groundLng").val(lng);
		    		});
		        }
		    }).open();
		 
	}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>