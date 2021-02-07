<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function sayHello(){
	alert("안녕하세요~ 자바 스크립트입니다.");
}
function sum(num1, num2){
	return num1 + num2;
}
function sayAnswer(){
	var answer = sum(30, 40);
	var element = document.getElementById("answer");
	element.innerHTML = answer;
}
function hideAnswer(){
	var element = document.getElementById("answer");
	element.innerHTML = "?";
}
function sayResult(){
	var result = sum(80, 30);
	document.getElementById("result").innerHTML = result;
}
function hideResult(){
	document.getElementById("result").innerHTML = "?";
}
function showEval(){
	var str = prompt("사칙연산을 입력하세요.(예:12+34)");
	var answer = eval(str);
	var result = str + " = " + answer;
	document.getElementById("evaluation").innerHTML = result;
}
</script>
</head>
<body onload="showEval()">
<input type="button" value="창 띄우기" onClick="sayHello()"/>
<div id="evaluation"></div><br/>
<h1>30 + 40 = <span id="answer"></span></h1>
<input type="button" value="결과 보기" onClick="sayAnswer()"/>
<input type="button" value="결과 감추기" onClick="hideAnswer()"/><br/>
<h1 onMouseOver="sayResult()" onMouseOut="hideResult()">
80 + 30 = <span id="result"></span></h1>
</body>
</html>

















