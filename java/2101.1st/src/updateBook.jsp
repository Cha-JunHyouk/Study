<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String seqno = (String)request.getAttribute("seqno");
	String title = (String)request.getAttribute("title");
	String writer = (String)request.getAttribute("writer");
	String company = (String)request.getAttribute("publisher");
	String price = (String)request.getAttribute("price");
%>
<div align="center"><h2>���� ���� ���� ȭ��</h2></div>
<div align="center">
<form action="updateBookInfo.jsp" method="post">
�Ϸù�ȣ : <input type="text" name="SEQNO" value="<%= seqno %>" readonly/>
<br/>
�� �� : <input type="text" name="TITLE" value="<%= title %>"/><br/>
�� �� : <input type="text" name="WRITER" value="<%= writer %>"/><br/>
���ǻ� : <input type="text" name="COM" value="<%= company %>"/><br/>
�� �� : <input type="text" name="PRICE" value="<%= price %>"/><br/><br/>
<input type="submit" value="�����ϱ�"/><input type="reset" value="�� ��"/>
</form>
</div>
</body>
</html>













