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
	var tag = document.getElementById("title");
	tag.style.color = "#0f0";
	tag.style.background = "#550";
	tag.innerHTML = "�ȳ��ϼ���";
	tag.onclick = function(){
		alert("Ŭ���߽��ϴ�.");
	};
};
</script>
<h2 id="title"></h2>
</body>
</html>