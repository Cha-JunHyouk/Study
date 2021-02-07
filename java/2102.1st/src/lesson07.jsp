<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">자바스크립트의 Math 클래스 사용</h2>
<script type="text/javascript">
var max = Math.max(123, 456, 789, 999);
document.write("<h3>최대값:"+max+"</h3>");
var min = Math.min(123, 456, 789);
document.write("<h3>최소값:"+min+"</h3>");
document.write("<h3>원주율:"+Math.PI+"</h3>");
var value = 3.14159265;
document.write("<h3>반올림:"+Math.round(value)+"</h3>");
document.write("<h3>올림:"+Math.ceil(value)+"</h3>");
document.write("<h3>버림:"+Math.floor(value)+"</h3>");
var worth = -3.14159265;
document.write("<h3>절대값:"+Math.abs(worth)+"</h3>");
document.write("<h3>난수:"+Math.random()+"</h3>");
var rnd = parseInt((Math.random()*10)+1);
document.write("<h3>1에서 10까지 난수:"+rnd+"</h3>");
function makerandom(from,to){
	return parseInt((Math.random()*(to-from+1))+from);
}
var rand = "";
for(var i=0; i<5; i++){
	rand = rand + makerandom(0,9);
}
document.write("<h3>다섯자리 무작위 수:"+rand+"</h3>");
</script>
</body>
</html>







