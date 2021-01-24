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
<h2>맛집 결과 목록</h2>
<ul>
	<c:forEach var="matjip" items="${RESULT }">
		<li>${matjip }</li>
	</c:forEach>
</ul>
</body>
</html>