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
alert("alert창입니다.");
var is = confirm("confirm창입니다.");
if(is == true){
	alert("긍정 버튼을 눌렀습니다.");
}else {
	alert("부정 버튼을 눌렀습니다.");
}
var input = prompt("아무 값이나 입력하세요.");
alert(input+"을 입력하셨습니다.");
var isNumber = isNaN(input);
if(isNumber == true){
	alert("문자를 입력했습니다.");
}else {
	alert("숫자를 입력했습니다.");
	var num = input;
	var sum = 0;
	for(var i=1; i<= num; i++){//1에서 입력한 수 까지 반복
		sum = sum + i;
	}
	alert("1 에서 "+num+"까지의 합은 "+sum+"입니다.for를 사용함");
	sum = 0;
	var cnt = 1;
	while(cnt <= num){
		sum = sum + cnt;
		cnt++;
	}
	alert("1 에서 "+num+"까지의 합은 "+sum+"입니다.while을 사용함.");
	sum = 0;
	cnt = 1;
	do{
		sum = sum + cnt;
		cnt++;
	}while(cnt <= num);
	alert("1 에서 "+num+"까지의 합은 "+sum+"입니다.do-while을 사용함.");
}
alert("브라우저에 테이블과 구구단을 출력합니다.");
document.write("<h1 align='center'>구구단</h1><br/><br/>");
document.write("<table width='100%' border='1' text-align='center'>");
for(var dan=1; dan<=9; dan++){
		document.write("<tr>");
		for(var su=1; su<=9; su++){
			var txt = dan+" * "+su+" = "+(dan * su);
			document.write("<td>"+txt+"</td>");
		}
		document.write("</tr>");
}
document.write("</table>");
</script>
</body>
</html>















