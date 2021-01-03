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
	//연산의 결과를 request 내장객체에 저장한다.
	request.setAttribute("SUM", sum);
	request.setAttribute("SUB", sub);
	request.setAttribute("MUL", mul);
	request.setAttribute("DIV", div);
	//Forward방식으로 페이지를 calcResult.jsp로 전환
	RequestDispatcher rd = request.getRequestDispatcher("calcResult.jsp");
	rd.forward(request, response);
	//Forward로 화면을 전환하는 경우, 두 가지 내장객체(request,response)가
	//따라 간다. 따라서, 전송할 데이터가 있으면 내장객체(request)에 데이터를
	//저장한다.
%>
</body>
</html>












