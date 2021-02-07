<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">자바스크립트에서 배열처리</h2>
<script type="text/javascript">
var array1 = new Array("자바1","자바스크립트1","서블릿1");
var array2 = ["자바2","자바스크립트2","서블릿2"];
document.write(array1[1]+"<br/>");
document.write(array2[1]+"<br/>");
var array3 = new Array();
var array4 = [];
array3[0]="자바3"; array3[1]="자바스크립트3"; array3[2]="서블릿3";
array4[0]="자바4"; array4[1]="자바스크립트4"; array4[2]="서블릿4";
document.write(array3[1]+" 배열의 길이:"+array3.length+"<br/>");
document.write(array4[1]+" 배열의 길이:"+array4.length+"<br/>");

var array5 = new Array(
	new Array("자바11","자바스크립트12","서블릿13"),
	new Array("자바21","자바스크립트22","서블릿23")
);
var array6 = [
	["자바1_1","자바스크립트1_2","서블릿1_3"],
	["자바2_1","자바스크립트2_2","서블릿2_3"]
];
document.write(array5[0][0]+" 행의 길이:"+array5.length+"열의 길이:"+
		array5[0].length+"<br/>");
document.write(array6[0][0]+" 행의 길이:"+array6.length+"열의 길이:"+
		array6[0].length+"<br/>");
var sentence = "우리는, 자바스크립트를, 공부하고, 있습니다.";
var words = sentence.split(",");
for(var cnt=0; cnt<words.length; cnt++){
	document.write(words[cnt]);
}
</script>
</body>
</html>











