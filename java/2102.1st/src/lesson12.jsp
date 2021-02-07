<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function click_title(){
	alert("클릭했습니다.");
}
function init(){
	var tag = document.getElementById("title");
	tag.style.color = "#0f0";
	tag.style.background = "#550";
	tag.innerHTML = "안녕하세요";
}
</script>
<body onload="init()">
<h2 id="title" onClick="click_title()"></h2>
</body>
</html>