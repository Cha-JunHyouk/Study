<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">�۾���</div>
<form action="bbsPost.jsp" method="post">
�ۼ��� : <input type="text" name="NAME"/><br/>
������ : <input type="text" name="TITLE"/><br/>
<textarea rows="5" cols="30" name="CONTENT"></textarea><br/>
<input type="submit" value="�ۿø���"/>
<input type="reset" value="���"/>
<a href="bbsList.jsp"><b>�Խñ� ��� ����</b></a>
</form>
</body>
</html>