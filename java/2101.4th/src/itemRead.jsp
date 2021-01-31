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
<h2>상품 정보</h2>
[상품번호] : ${ITEM.pid }<br/>
[상품이름] : ${ITEM.name }<br/>
[상품가격] : <fmt:formatNumber groupingUsed="true">${ITEM.price }</fmt:formatNumber>
<br/>
[등록일] : ${ITEM.p_date}<br/>
<table border="1">
<tr><td>${ITEM.intro }</td></tr>
</table>
</div>
</body>
</html>