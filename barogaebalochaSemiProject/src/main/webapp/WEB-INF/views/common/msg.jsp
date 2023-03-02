<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String title = (String)request.getAttribute("title");
    String msg = (String)request.getAttribute("msg");
    String icon = (String)request.getAttribute("icon");
    String loc = (String)request.getAttribute("loc");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 모달창 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	<div style="display:none;">
		<div id="title"><%=title %></div>
		<div id="msg"><%=msg %></div>
		<div id="icon"><%=icon %></div>
		<div id="loc"><%=loc %></div>
	</div>
	
	<script>
		const title = document.querySelector("#title").innerText;
		const msg = document.querySelector("#msg").innerText;
		const icon = document.querySelector("#icon").innerText;
		const loc = document.querySelector("#loc").innerText;
		
		Swal.fire({
            icon: icon,                        
            title: title,         
            text: msg,  
        }).then(function(){
			location.href = loc;			
		});
	</script>
</head>
<body>

</body>
</html>