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
while(true){
	var score = prompt("점수를 입력하세요.");
	var isString = isNaN(score);
	if( ! isString ){
		switch(parseInt(score/10)){
		case 10:
		case 9: document.write("<h2 align='center'>A학점</h2>");break;
		case 8: document.write("<h2 align='center'>B학점</h2>");break;
		case 7: document.write("<h2 align='center'>C학점</h2>");break;
		case 6: document.write("<h2 align='center'>D학점</h2>");break;
		default :document.write("<h2 align='center'>F학점</h2>");break;
		}
		break;//반복 종료
	}else{
		alert("숫자를 입력해야 합니다.");
	}
}
hello1();
function hello1(){
	document.write("<h2 align='center'>자바 스크립트 입니다.</h2>");
}
function hello2(str){
	document.write("<h2 align='center'>"+str+"을 받았습니다.</h2>");
}
function calculate(str){
	if(isNaN(str)){
		document.write("문자열 "+str+"을 받았습니다.<br/>");
		document.write("하지만 숫자모양의 문자열은 계산을 할 수 있습니다.");
		document.write("<br/>계산 결과는 "+eval(str)+"입니다.");
	}
}
hello2("자바 스크립트");
calculate("3+5");
</script>
</body>
</html>






