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
������ ��� : <%= request.getParameter("SUM") %><br/>
������ ��� : <%= request.getParameter("SUB") %><br/>
������ ��� : <%= request.getParameter("MUL") %><br/>
�������� ��� : <%= request.getParameter("DIV") %><br/>
</body>
</html>