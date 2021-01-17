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
<fmt:setBundle basename="intro"/>
<fmt:message var="body" key="BODY"/>
<h2><fmt:message key="TITLE"/></h2>
<font color="blue"><fmt:message key="GREETING"/></font>
<font color="red">${body }</font><br/>
<h3><fmt:message key="COMPANY"/></h3>
</body>
</html>