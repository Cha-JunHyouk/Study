<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>��ǰ ����</h2>
[��ǰ��ȣ] : ${ITEM.pid }<br/>
[��ǰ�̸�] : ${ITEM.name }<br/>
[��ǰ����] : <fmt:formatNumber groupingUsed="true">${ITEM.price }</fmt:formatNumber>
<br/>
[�����] : ${ITEM.p_date}<br/>
<table border="1">
<tr><td>${ITEM.intro }</td></tr>
</table>
</div>
</body>
</html>