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
	out.println("z의 값은 "+z);
	out.print("z의 값은 "+z);
	//out객체의 print와 println메서드는 동일한 기능이다.
%>
</body>
</html>