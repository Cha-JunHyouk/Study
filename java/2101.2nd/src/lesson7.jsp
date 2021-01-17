<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>커스텀 액션 태그를 사용합니다.</h2>
<h3>코어 기능</h3>
■ 반복기능<br/>
<%
	String[] arr = {"대한민국","중국","일본","몽골","베트남","대만"};
	request.setAttribute("ASIAN", arr);
%>
<jsp:forward page="result7.jsp"/>
</body>
</html>