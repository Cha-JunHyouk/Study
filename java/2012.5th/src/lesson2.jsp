<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	int x = 5;
	int y = 10;
	int z = x + y;
	out.println("z�� ���� "+z);
	out.print("z�� ���� "+z);
	//out��ü�� print�� println�޼���� ������ ����̴�.
%>
</body>
</html>