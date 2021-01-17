<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>표준 액션 태그를 공부합니다.</h3>
<%
	int sum = 0;
	for(int i=1; i<=100; i++){
		sum = sum + i;
	}
	request.setAttribute("SUM100", sum);
%>
<jsp:forward page="result3.jsp"/>
</body>
</html>