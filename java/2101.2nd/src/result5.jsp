<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>��ǰ ����</h3>
<jsp:useBean id="product" class="mydata.ProductInfo" scope="request"/>
��ǰ �̸� : <jsp:getProperty property="name" name="product"/><br/>
��ǰ ���� : <jsp:getProperty property="price" name="product"/><br/>
</body>
</html>