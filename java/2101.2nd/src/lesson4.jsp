<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�ڹٺ��� �ٷ�� �׼��±׵�</h3>
<jsp:useBean id="item" class="mydata.ProductInfo"/>
<jsp:setProperty property="name" name="item" value="�繫�� ��Ʈ��"/>
<jsp:setProperty property="price" name="item" value="5000000"/>
��ǰ �̸� : <jsp:getProperty property="name" name="item"/><br/>
��ǰ ���� : <jsp:getProperty property="price" name="item"/><br/>
</body>
</html>