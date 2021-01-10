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
<div align="center"><h2>도서 정보 수정 화면</h2></div>
<div align="center">
<form action="updateBookInfo.jsp" method="post">
일련번호 : <input type="text" name="SEQNO" value="<%= seqno %>" readonly/>
<br/>
제 목 : <input type="text" name="TITLE" value="<%= title %>"/><br/>
저 자 : <input type="text" name="WRITER" value="<%= writer %>"/><br/>
출판사 : <input type="text" name="COM" value="<%= company %>"/><br/>
가 격 : <input type="text" name="PRICE" value="<%= price %>"/><br/><br/>
<input type="submit" value="수정하기"/><input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>













