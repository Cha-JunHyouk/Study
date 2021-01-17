<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>자바빈을 다루는 액션태그들</h3>
<jsp:useBean id="item" class="mydata.ProductInfo"/>
<jsp:setProperty property="name" name="item" value="사무용 노트북"/>
<jsp:setProperty property="price" name="item" value="5000000"/>
상품 이름 : <jsp:getProperty property="name" name="item"/><br/>
상품 가격 : <jsp:getProperty property="price" name="item"/><br/>
</body>
</html>