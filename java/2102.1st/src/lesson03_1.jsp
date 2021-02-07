<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
window.onload = function(){
	var tag=document.getElementById("greet");
	tag.style.color = "red";
	tag.style.backgroundColor = "lightblue";
	tag.style.fontSize = "30px";
	tag.innerHTML = "안녕~ 자바 스크립트";
	tag.onclick = function(){
		alert("클릭했습니다.");
	};
};
</script>
<h2 id="greet"></h2>
</body>
</html>


