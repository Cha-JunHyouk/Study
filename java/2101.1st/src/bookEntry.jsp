<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>���� ���� ���</h2></div><br/>
<div align="center">
<form action="insertBook.jsp" method="post">
	<table border="1">
		<tr><th>�Ϸù�ȣ</th>
			<td><input type="text" name="SEQNO" size="5"/></td></tr>
		<tr><th>���� ����</th>
			<td><input type="text" name="TITLE" size="15"/></td></tr>
		<tr><th>�� ��</th>
			<td><input type="text" name="WRITER" size="15"/></td></tr>
		<tr><th>���ǻ�</th>
			<td><input type="text" name="COMPANY" size="15"/></td></tr>
		<tr><th>�� ��</th>
			<td><input type="text" name="PRICE" size="10"/></td></tr>
		<tr><td colspan="2"><div align="center">
			<input type="submit" value="���� ���"/>
			<input type="reset" value="�� ��"/></div></td></tr>
	</table>
</form>
</div>
</body>
</html>






