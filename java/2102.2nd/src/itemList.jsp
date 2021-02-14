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
<div align="center">
<h2 align="center">상품 목록</h2>
<table class="main">
	<tr><th width="40">상품번호</th><th width="150">상품이름</th>
		<th width="80">가 격</th><th width="90">등록일</th><th>&nbsp;</th>
	</tr>
	<c:forEach var="item" items="${ITEMLIST }">
	<tr><td>${item.pid }</td>
		<td><a href="itemRead.do?PID=${item.pid }">${item.name }</a></td>
		<td><fmt:formatNumber 
			groupingUsed="true">${item.price }</fmt:formatNumber></td>
		<td>${item.p_date }</td>
		<td>
<a href="#"
onClick=
"window.open('addCart?CODE=${item.pid}','cart','width=400,height=350').focus()">
장바구니 담기</a></td>
	</tr>
	</c:forEach>
</table>
<c:forEach var="page" begin="1" end="${PAGECNT }">
	<a href="itemList.do?PAGENO=${page }">${page }</a>
</c:forEach>
</div>
</body>
</html>




