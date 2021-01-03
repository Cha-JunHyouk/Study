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
	String n1 = request.getParameter("NUM1");
	String n2 = request.getParameter("NUM2");
	int num1 = Integer.parseInt(n1);//문자열을 정수로 변환
	int num2 = Integer.parseInt(n2);
	int sum = num1 + num2; int sub = num1 - num2; int mul = num1 * num2;
	int div = num1 / num2;//사칙연산을 수행
	//Redirect로 화면을 전환(URL을 바꾼다.)
	response.sendRedirect(
		"calcResult2.jsp?SUM="+sum+"&SUB="+sub+"&MUL="+mul+"&DIV="+div);
%>
</body>
</html>















