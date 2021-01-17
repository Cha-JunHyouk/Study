<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>표준 액션 태그를 이용한 데이터 전송</h3>
상품정보를 자바빈에 저장하고, 자바빈을 내장객체(request)에 저장한 후,
FORWARD로 페이지를 전환한다.<br/>
<jsp:useBean id="product" class="mydata.ProductInfo" scope="request"/>
<jsp:setProperty property="name" name="product" value="운동화"/>
<jsp:setProperty property="price" name="product" value="50000"/>
<jsp:forward page="result5.jsp"/>
</body>
</html>