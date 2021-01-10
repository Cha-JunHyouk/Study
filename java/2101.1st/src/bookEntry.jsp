<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>도서 정보 등록</h2></div><br/>
<div align="center">
<form action="insertBook.jsp" method="post">
	<table border="1">
		<tr><th>일련번호</th>
			<td><input type="text" name="SEQNO" size="5"/></td></tr>
		<tr><th>도서 제목</th>
			<td><input type="text" name="TITLE" size="15"/></td></tr>
		<tr><th>저 자</th>
			<td><input type="text" name="WRITER" size="15"/></td></tr>
		<tr><th>출판사</th>
			<td><input type="text" name="COMPANY" size="15"/></td></tr>
		<tr><th>가 격</th>
			<td><input type="text" name="PRICE" size="10"/></td></tr>
		<tr><td colspan="2"><div align="center">
			<input type="submit" value="도서 등록"/>
			<input type="reset" value="취 소"/></div></td></tr>
	</table>
</form>
</div>
</body>
</html>






