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
<c:choose>
	<c:when test="${param.R == 'OK' }">
		<h3 align="center">게시글이 등록되었습니다.</h3>
	</c:when>
	<c:otherwise>
		<h3 align="center">게시글이 등록에 문제가 발생했습니다.</h3>
		<h3 align="center">관리자에게 문의해주세요.</h3>
	</c:otherwise>
</c:choose>
</body>
</html>