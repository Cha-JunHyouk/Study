<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="mydata.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ProductInfo product = new ProductInfo();
	product.setName("갤럭시 S21");
	product.setPrice(990000);
	request.setAttribute("ITEM", product);
	RequestDispatcher rd = request.getRequestDispatcher("result1.jsp");
	rd.forward(request, response);
%>
</body>
</html>