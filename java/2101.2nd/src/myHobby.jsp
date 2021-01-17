<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<fmt:setBundle basename="myhobby"/>
<fmt:message var="title" key="TITLE"/>
<fmt:message var="body" key="BODY">
	<fmt:param>${param.NAME }</fmt:param>
	<fmt:param>${param.HOBBY }</fmt:param>
</fmt:message>
<fmt:message var="message" key="MSG"/>
<h2><font color="red">${title }</font></h2>
<font color="blue">${body }</font><br/>
<h2><font color="orange">${message }</font></h2>
</body>
</html>





