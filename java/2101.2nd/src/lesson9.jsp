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
<h2>커스텀 액션 태그(JSTL)</h2>
■ 브라우저에 출력<br/>
<%
	out.print("이 글이 브라우저에 출력됩니다.<br/>");
%>
<c:out value="이 글이 브라우저에 출력됩니다.<br/>"/>
<br/>
<c:out value="이 글이 브라우저에 출력됩니다.<br/>" escapeXml="false"/>
<c:out value="<font size='7'>큰 글씨</font>"/>
<br/>
<c:out value="<font size='7'>큰 글씨</font>" escapeXml="false"/>
</body>
</html>











