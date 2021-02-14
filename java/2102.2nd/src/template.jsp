<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table {
	width:90%; height:80%; border:1px solid blue; 
	border-collapse:collapse;	margin-left:20px; margin-right:20px;
	background-color:skyblue;
}
td.main {	width:30%; border:1px solid blue;}
#login { margin-left:10px;	margin-top:10px;
		width:90%; border:1px dashed red;
		background-color:orange;}
#menu { margin-top:10px; margin-left:10px; margin-right:10px; 
		margin-bottom:10px; border:1px dashed green;
		background-color:orange;}
#content { background-color:wheat;}
</style>
</head>
<body onload="startClock()">
<script type="text/javascript">
function workingClock(){
	var days=["일","월","화","수","목","금","토"];
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	if(month < 10) month = "0"+month;
	var date = today.getDate();
	if(date < 10) date = "0"+date;
	var index = today.getDay();
	var day = days[index];
	var hour = today.getHours();
	var min = today.getMinutes();
	if(min < 10) min = "0"+min;
	var sec = today.getSeconds();
	if(sec < 10) sec = "0"+sec;
	var str=year+"-"+month+"-"+date+" "+day+" "+hour+":"+min+":"+sec;
	document.getElementById("clock").innerHTML = str;
}
function startClock(){
	setInterval(workingClock, 1000);//1초마다 workingClock함수 호출
}
</script>
<header>
	<h2 align="center"><img alt="" src="imgs/logo.gif"></h2>
</header>
<nav></nav>
<section>
	<table id="body">
		<tr>
			<td width="40%" height="300" class="main">
				<div id="login">
					<c:choose>
						<c:when test="${sessionScope.LOGIN == null }">
							<jsp:include page="login.jsp"/>
						</c:when>
						<c:otherwise>
							<jsp:include page="logout.jsp"/>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="menu">
					<a href="template.jsp?BODY=intro.jsp">소개글</a><br/>
					<a href="template.jsp?BODY=yogiyo.jsp">맛집추천</a><br/>
					<a href="template.jsp?BODY=beerSelection.jsp">맥주추천</a><br/>
					<a href="template.jsp?BODY=noticeInput.jsp">공지사항 쓰기</a><br/>
					<a href="">공지사항 목록</a><br/>
					<a href="template.jsp?BODY=bbsInput.jsp">게시글 쓰기</a><br/>
					<a href="bbsList.do">게시글 목록</a><br/>
					<a href="template.jsp?BODY=itemInput.jsp">상품 등록</a><br/>
					<a href="itemList.do">상품 목록</a><br/>
					<a href="template.jsp">장바구니 보기</a><br/>
					<a href="template.jsp">이미지 및 답글 게시판</a><br/>
				</div>
			</td>
			<td id="content">
				<jsp:include page="${param.BODY }"/>
			</td>
		</tr>
	</table>
</section>
<footer>
	<h3 align="center">CopyLeft 2021. FromAtoZucchini.
	 <span id="clock"></span></h3>
</footer>
</body>
</html>





