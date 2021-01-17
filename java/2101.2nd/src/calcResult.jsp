<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">사칙 연산의 결과</div>
덧셈의 결과 : <%= request.getAttribute("SUM") %><br/>
뺄셈의 결과 : <%= request.getAttribute("SUB") %><br/>
곱셈의 결과 : <%= request.getAttribute("MUL") %><br/>
나눗셈의 결과 : <%= request.getAttribute("DIV") %><br/>
</body>
</html>