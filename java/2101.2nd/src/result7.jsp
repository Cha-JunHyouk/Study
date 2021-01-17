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
<h2>아시아의 국가들</h2>
<ul>
	<c:forEach var="nation" items="${ASIAN}">
		<li>${nation }</li>
	</c:forEach>
</ul>
</body>
</html>