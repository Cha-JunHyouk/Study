<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>���� ���� �Է�</h2>
<form action="matjipPost.jsp" method="post">
�� ȣ : <input type="text" name="ID" size="4"/><br/>
�� �� : <input type="text" name="NAME" size="20"/><br/>
�� �� : <input type="text" name="ADDR" size="30"/><br/>
����ó : <input type="text" name="TEL" size="15"/><br/>
�޴� ���� : �ѽ�<input type="radio" name="MENU" value="K"/>,
�߽�<input type="radio" name="MENU" value="C"/>,
���<input type="radio" name="MENU" value="A"/>,
�Ͻ�<input type="radio" name="MENU" value="J"/>,
�н�<input type="radio" name="MENU" value="M"/>,
��Ÿ<input type="radio" name="MENU" value="E"/><br/>
�� �� : <br/>
<textarea rows="8" cols="40" name="INTRO"></textarea><br/>
<input type="submit" value=" ��� "/>
<input type="reset" value=" ��� "/>
</form>
</div>
</body>
</html>









