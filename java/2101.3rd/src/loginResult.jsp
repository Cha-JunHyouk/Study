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
<div align="center">
<c:choose>
	<c:when test="${param.R == 'OK' }">
		<h3 align="center">�α��� �Ǿ����ϴ�.</h3>
	</c:when>
	<c:when test="${param.R == 'NOPWD' }">
		<h3 align="center">��ȣ�� ��ġ���� �ʽ��ϴ�.</h3>
	</c:when>
	<c:when test="${param.R == 'NOID' }">
		<h3 align="center">������ �������� �ʽ��ϴ�.</h3>
	</c:when>
</c:choose>
</div>
</body>
</html>