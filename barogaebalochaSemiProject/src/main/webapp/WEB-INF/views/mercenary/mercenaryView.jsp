<%@page import="semi.team.baro.mercenary.model.vo.MercenaryRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="semi.team.baro.mercenary.model.vo.Mercenary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Mercenary mc = (Mercenary)request.getAttribute("mc");
    	ArrayList<MercenaryRequest> list = (ArrayList<MercenaryRequest>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=tnds8i7hti&submodules=geocoder"></script>
<title>용병모집 상세보기</title>
<style>
	.read-count{
		height: 30px;
		text-align: right;
		width: 90%;
		margin: 0 auto;
		overflow:hidden;
	}
	.read-count div{
		color: #ccc;
		height: 30px;
		line-height: 30px;
		float: right;
	}
	.read-count div:last-child{
		font-size: 20px;
	}
    .tbl {
    	width: 90%;
    	margin: 0 auto;
	    border-spacing: 0px;
	    border-collapse: collapse;
    }
    .tbl th,.tbl td {
        padding: 10px;
        text-align: center;
    } 
    #mercenaryView th, #mercenaryView td{
        border: 1px solid #181818;
        font-size: 13px;
    }
    #mercenaryView th{
        background-color: #ccc;
        color: #fcfcfc;
    }
    .mercenary-content{
    	text-align: left;
    	min-height: 400px;
    	padding: 20px;
    }
    .back-link>.bs4{
    	padding: 10px;
    	font-size: 15px;
    	font-family: ns-bold;
    }
    .inputCommentBox{
		margin: 50px;
	}
	.inputCommentBox>form>ul{
		list-style-type: none;
		padding: 0;
		display: flex;
	}
	.inputCommentBox>form>ul>li:first-child{
		width: 10%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.inputCommentBox>form>ul>li:first-child>span{
		font-size: 70px;
		color: #ccc;
	}
	.inputCommentBox>form>ul>li:nth-child(2){
		width: 75%;
	}
	.inputCommentBox>form>ul>li:nth-child(2)>textarea{
		height: 95px;
		min-height: 95px;
	}
	.inputCommentBox>form>ul>li:last-child{
		width: 10%;
	}
	.back-link{
		width: 100%;
		text-align: center;
		margin-top: 30px;
	}
	.back-link>a{
		font-family: ns-bold;
		font-size: 14px;
	}
	.view-link{
		text-align: right;
		width: 90%;
		margin: 0 auto;
	}
	.view-link>a{
		padding-left: 15px;
		color: #181818;
		cursor:pointer;
	}
	.posting-info>p{
		margin: 0;
	}
	.posting-info>p:last-child{
		margin-left: 70px;
	}
	.posting-link>.btn2{
		padding: 5px 10px;
	}
	.comment-wrap{
		border-bottom: 1px solid #ccc;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
			<h2>용병모집</h2>
		</div>
		<div class="read-count">
			<div><%=mc.getReadCount() %></div>	
			<div class="material-symbols-outlined">spoof</div>  
		</div>
		<table class="tbl" id="mercenaryView">
			<tr>
				<th colspan="4"> 용병모집 </th>
			</tr>
			<tr>
				<th>지역</th>
				<td>
					 <%if(mc.getLocation().equals("seoul")) {%>
                     	서울
                     <%} else if(mc.getLocation().equals("incheon")) {%>
                     	인천
                     <%} else if(mc.getLocation().equals("Gyeonggi")) {%>
                     	경기
                     <%} %>
				</td>
				<th>구장이름</th>
				<td colspan="3"><%=mc.getGroundName() %></td>
			</tr>
			<tr>
				<th>지도</th>
				<td colspan="3">
				<div id="map" style="width:100%; height: 400px; margin: 0 auto;"></div>
				<input type="hidden" id="groundLat" value="<%=mc.getGroundLat()%>">
				<input type="hidden" id="groundLng" value="<%=mc.getGroundLng() %>">
				</td>
			<tr>
			<tr>
				<th>주소</th>
				<td colspan="3"><%=mc.getGroundLocation() %></td>
			</tr>
			<tr>
				<th>경기일</th>
				<td colspan="3"><%=mc.getGameDate() %> [ <%=mc.getGameShowTime() %> ]</td>				 
			</tr>
			<tr>
				<th>모집상태</th>
				<% if(mc.getMercenaryWhether() == 0 ) {%>
					<td colspan="3">모집중</td>
				<%}else if(mc.getMercenaryWhether() == 1) {%>
					<td colspan="3">모집완료</td>
				<%} %>				
			</tr>
			<tr>
				<th>참가비</th>
				<td><%=mc.getMercenaryPay() %> 원</td>
				<th>실력</th>
				<%if(mc.getLevel() == 1){ %>
					<td>최상</td>
				<%}else if(mc.getLevel() == 2) {%>
					<td>상</td>
				<%}else if(mc.getLevel() == 3) {%>
					<td>중</td>
				<%}else if(mc.getLevel() == 4) {%>
					<td>하</td>
				<%}else if(mc.getLevel() == 5) {%>
					<td>최하</td>
				<%} %>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=mc.getMemberId() %></td>
				<th>작성일</th>
				<td style="color:#ccc;"><%=mc.getRegDate() %></td>
			</tr>
			<tr>
				<th colspan="4">상세내용</th>
			</tr>
			<tr>
				<td colspan="4">
					<div class="mercenary-content">
						<%=mc.getMercenaryContent() %>
					</div>
				</td>
			</tr>
			<tr>
				<th colspan="4">
					<div class="no">
						
					</div>
				</th>
			</tr>	
		</table>
		<div class="view-link">
			<%if( m != null && m.getMemberNo() == mc.getMemberNo()) {%>
				<a href="/mercenaryUpdateFrm.do?mercenaryNo=<%=mc.getMercenaryNo()%>">수정</a>
				<a onclick="mercenaryDelete(<%=mc.getMercenaryNo()%>);">삭제</a>
			<%} %>
		</div>		
		<div class="back-link">
			<a href="/mercenaryList.do?reqPage=1" class="btn2 bc1">목록으로</a>
		</div>
		<!-- 댓글input박스 -->
		<div class="inputCommentBox">
			<form action="/mercenaryRequestInsert.do" method="post">
				<ul>
					<li>
						<span class="material-symbols-outlined">account_circle</span>
					</li>
					<li>
						<%if(m == null) {%>
							<textarea name="mcRequestContent" class="input-form" style="color:#ccc;" readonly>로그인한 회원만 작성할 수 있습니다.</textarea>
						<%}else {%>
							<%if(mc.getMercenaryWhether() == 1) {%>
								<textarea name="mcRequestContent" class="input-form" style="color:#ccc;" readonly>모집이 완료되었습니다.</textarea>
							<%} else{%>
								<input type="hidden" name="mcRequsetWriter" value="<%=m.getMemberNo() %>">
								<input type="hidden" name="mercenaryNo" value="<%=mc.getMercenaryNo() %>">
								<input type="hidden" name="mcRequestNo" value="0">
								<textarea name="mcRequestContent" class="input-form"></textarea>
							<%} %>
						<%} %>
						
					</li>
					<li>
						<% if( m == null || mc.getMercenaryWhether() == 1) {%>
						<button type="button" class="btn1 bc1 bs4">등록</button>
						<%}else {%>
						<button type="submit" class="btn1 bc1 bs4">등록</button>
						<%} %>
					</li>
				</ul>
			</form>
		</div>
		<!-- 댓글 -->
		<%for(MercenaryRequest mcReq : list) {%>
		<div class="comment-wrap">
            <div class="posting-comment">
                <span class="material-icons">account_box</span>
            </div>
            <div class="posting-info">
                <span style="font-size:17px;"><%=mcReq.getMemberId() %></span>
                <p><%=mcReq.getMercenaryRequestContentBr() %></p>
                <p><%=mcReq.getMercenaryRequestDate() %></p>
            </div>
            <textarea name="mercenaryRequestContent" class="input-form" style="min-height:96px;display:none;"><%=mcReq.getMercenaryRequestContent() %></textarea>
            <div class="posting-link">             
                <%if( m != null && m.getMemberNo() == mcReq.getMemberNo()) {%>
                <a href="javascript:void(0)" onclick="modifyComment(this, <%=mcReq.getMercenaryRequestNo()%>, <%=mc.getMercenaryNo()%>);">수정</a>
				<a href="javascript:void(0)" onclick="deleteComment(this, <%=mcReq.getMercenaryRequestNo()%>, <%=mc.getMercenaryNo()%>);">삭제</a>
                <%} else if(m != null && m.getMemberNo() == mc.getMemberNo()){%>
                	<%if(mcReq.getMercenaryRequestResult().equals(mcReq.getMemberId())) {%>
                	<button type="button" onclick="mercenaryCancle(<%=mcReq.getMercenaryRequestNo()%>, <%=mc.getMercenaryNo()%>, '<%=mcReq.getMemberId() %>');" style="background-color:#ccc;border:2px solid #ccc;" class="btn2 bc2">선택취소</button>
                	<%} else if(mcReq.getMercenaryRequestResult().equals("0")){%>
                	<button type="button" onclick="mercenarySel(<%=mcReq.getMercenaryRequestNo()%>, <%=mc.getMercenaryNo()%>, '<%=mcReq.getMemberId() %>');" class="btn2 bc4">선택</button>
                	<%} else if(mcReq.getMercenaryRequestResult().equals("1")){%>
					<button type="button" onclick="alert('더이상 선택할 수 없습니다.');" class="btn2 bc2" style="background-color:#ccc;border:2px solid #ccc;">선택</button>                		
                	<%} %>
                <%} %>
            </div>
        </div>  		
		<%} %>
      </div>
	<script>
	    function mercenaryDelete(mercenaryNo) {
	        Swal.fire({
	            title: '게시글 삭제',
	            text: "게시글을 삭제하시겠습니까?",
	            icon: 'question',
	            showCancelButton: true,
	            confirmButtonColor: '#AACB73',
	            cancelButtonColor: '#ccc',
	            confirmButtonText: '확인',
	            cancelButtonText: '취소'
	        }).then((result) => {
	            if (result.isConfirmed) {
	                location.href="/mercenaryDelete.do?mercenaryNo="+mercenaryNo;
	            }
	        })
	    }
	    function modifyComment(obj, mercenaryRequestNo, mercenaryNo){
			//숨겨놓은 textarea를 화면에 보여줌
			$(obj).parent().prev().show();
			//화면에 있던 댓글내용을 숨김
			$(obj).parent().prev().prev().hide();
			//수정 -> 수정완료
			$(obj).text("수정완료");
			$(obj).attr("onclick", "modifyComplete(this, "+mercenaryRequestNo+", "+mercenaryNo+")");
			//삭제 -> 수정취소
			$(obj).next().text("수정취소");
			$(obj).next().attr("onclick", "modifyCancel(this, "+mercenaryRequestNo+", "+mercenaryNo+")");
		}
		
		//수정완료 취소
		function modifyCancel(obj, mercenaryRequestNo, mercenaryNo){
			$(obj).parent().prev().hide(); //textarea숨김
			$(obj).parent().prev().prev().show(); //기존댓글 다시 보여줌
			//수정완료 -> 수정
			$(obj).prev().text("수정");
			$(obj).prev().attr("onclick", "modifyComment(this, "+mercenaryRequestNo+", "+mercenaryNo+")");
			//수정취소 -> 삭제
			$(obj).text("삭제");
			$(obj).attr("onclick", "deleteComment(this, "+mercenaryRequestNo+", "+mercenaryNo+")");
		}	
		
		function modifyComplete(obj, mercenaryRequestNo, mercenaryNo){
			//form태그를 생성해서 전송
			//댓글내용, 댓글번호, 공지사항번호
			//1. form태그 생성
			const form = $("<form style='display:none;' action='/updateMercenaryRequest.do' method='post'</form>");
			//2. input태그 2개숨김
			const mcReqInput = $("<input type='text' name='mercenaryRequestNo'>");
			mcReqInput.val(mercenaryRequestNo);
			const mercenaryNoInput = $("<input type='text' name='mercenaryNo'>");
			mercenaryNoInput.val(mercenaryNo);
			//3. textarea
			const mcReqContent = $(obj).parent().prev().clone();
			//4. form 태그에 input, textarea를 모두 포함
			form.append(mcReqInput).append(mercenaryNoInput).append(mcReqContent);
			//5. 생성된 form태그를 body태그에 추가
			$("body").append(form);
			//body의 맨마지막 현재페이지의 footer아래에 생성됨
			form.submit();
		}
		
		function deleteComment(obj, mcReqNo, mercenaryNo){
			Swal.fire({
	            title: '용병신청글 삭제',
	            text: "작성한 신청을 삭제하시겠습니까?",
	            icon: 'question',
	            showCancelButton: true,
	            confirmButtonColor: '#AACB73',
	            cancelButtonColor: '#ccc',
	            confirmButtonText: '확인',
	            cancelButtonText: '취소'
	        }).then((result) => {
	            if (result.isConfirmed) {
	            	location.href="/deleteMercenaryRequest.do?mcReqNo="+mcReqNo+"&mercenaryNo="+mercenaryNo;
	            }
	        })
		}
	    
		function mercenarySel(mercenaryRequestNo, mercenaryNo, memberId){
			Swal.fire({
	            title: '용병선택',
	            text: '[ '+memberId+' ]님을 용병으로 선택 하시겟습니까?',
	            icon: 'question',
	            showCancelButton: true,
	            confirmButtonColor: '#AACB73',
	            cancelButtonColor: '#ccc',
	            confirmButtonText: '확인',
	            cancelButtonText: '취소'
	        }).then((result) => {
	            if (result.isConfirmed) {
	            	location.href="/mercenarySel.do?mcReqNo="+mercenaryRequestNo+"&mercenaryNo="+mercenaryNo+"&mcReqWriter="+memberId;
	            }
	        })
		}
		
		function mercenaryCancle(mercenaryRequestNo, mercenaryNo, memberId){
			Swal.fire({
	            title: '용병선택취소',
	            text: '용병[ '+memberId+' ]님을 취소 하시겟습니까?',
	            icon: 'question',
	            showCancelButton: true,
	            confirmButtonColor: '#AACB73',
	            cancelButtonColor: '#ccc',
	            confirmButtonText: '확인',
	            cancelButtonText: '취소'
	        }).then((result) => {
	            if (result.isConfirmed) {
	            	location.href="/mercenaryCancle.do?mcReqNo="+mercenaryRequestNo+"&mercenaryNo="+mercenaryNo+"&mcReqWriter="+memberId;
	            }
	        })
		}	
		
		const groundLat = $("#groundLat").val(); //위도
		const groundLng = $("#groundLng").val(); //경도
		
		const map = new naver.maps.Map("map",{
			center : new naver.maps.LatLng(groundLat, groundLng),//지도의 중심지정
			zoom : 18, //지도의 배율
	            draggable: false,
	            pinchZoom: false,
	            scrollWheel: false,
		});
		//지도(지정위치)위에 마커
		const marker = new naver.maps.Marker({
			position : new naver.maps.LatLng(groundLat, groundLng),
			map : map //위에서 선언한 map에 올리라는 의미
		});
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>