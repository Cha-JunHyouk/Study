<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>ǥ�� �׼� �±׸� �̿��� ������ ����</h3>
��ǰ������ �ڹٺ� �����ϰ�, �ڹٺ��� ���尴ü(request)�� ������ ��,
FORWARD�� �������� ��ȯ�Ѵ�.<br/>
<jsp:useBean id="product" class="mydata.ProductInfo" scope="request"/>
<jsp:setProperty property="name" name="product" value="�ȭ"/>
<jsp:setProperty property="price" name="product" value="50000"/>
<jsp:forward page="result5.jsp"/>
</body>
</html>