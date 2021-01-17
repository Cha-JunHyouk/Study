<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>상품 정보</h3>
<jsp:useBean id="product" class="mydata.ProductInfo" scope="request"/>
상품 이름 : <jsp:getProperty property="name" name="product"/><br/>
상품 가격 : <jsp:getProperty property="price" name="product"/><br/>
</body>
</html>