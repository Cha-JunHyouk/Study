<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">자바스크립트에서 문자열 처리</h2>
<script type="text/javascript">
var strr = new String("자바스크립트");
var str = "http://java.sun.com/INDEX.jsp";
document.write("문자열 : "+strr+"<br/>");
var length = str.length;
document.write("문자열 길이 : "+length+"<br/>");
var strat5 = str.charAt(5);
document.write("여섯번째 문자 : "+strat5+"<br/>");
var index = str.indexOf("/");
document.write("문자열에서 /의 위치 : "+index+"<br/>");
var afterIndex = str.indexOf("/", index+1);
document.write("두번째 /의 위치 : "+afterIndex+"<br/>");
var lastSlash = str.lastIndexOf("/");
document.write("뒤에서 부터 /의 위치 : "+lastSlash+"<br/>");
var str04 = str.substring(0,4);
document.write("첫번째 문자부터 네번째 문자까지 : "+str04+"<br/>");
var str711 = str.substring(7,11);
document.write("여덟번째 문자부터 열한번재 문자까지 :"+str711+"<br/>");
var strfile = str.substring(20);
document.write("21번째 문자부터 끝까지 : "+strfile+"<br/>");
var upper = strfile.toUpperCase();
document.write("파일이름을 대문자로 : "+upper+"<br/>");
var lower = strfile.toLowerCase();
document.write("파일이름을 소문자로 : "+lower+"<br/>");
var start = str.indexOf("://");
var end = str.indexOf("/", start+3);
var domain = str.substring(start+3, end);
document.write("도메인 이름 : "+domain+"<br/>");
var filefrom = str.lastIndexOf("/");
var fileto = str.lastIndexOf(".");
var filename = str.substring(filefrom+1, fileto);
document.write("파일이름 : "+filename+"<br/>");
var ext = str.substring(fileto + 1);
document.write("확장자 : "+ext+"<br/>");
</script>
</body>
</html>










