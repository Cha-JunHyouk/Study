<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">��Ģ ������ ���</div>
������ ��� : <%= request.getAttribute("SUM") %><br/>
������ ��� : <%= request.getAttribute("SUB") %><br/>
������ ��� : <%= request.getAttribute("MUL") %><br/>
�������� ��� : <%= request.getAttribute("DIV") %><br/>
</body>
</html>