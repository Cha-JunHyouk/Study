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
		<h3 align="center">�Խñ��� ��ϵǾ����ϴ�.</h3>
	</c:when>
	<c:otherwise>
		<h3 align="center">�Խñ��� ��Ͽ� ������ �߻��߽��ϴ�.</h3>
		<h3 align="center">�����ڿ��� �������ּ���.</h3>
	</c:otherwise>
</c:choose>
</body>
</html>