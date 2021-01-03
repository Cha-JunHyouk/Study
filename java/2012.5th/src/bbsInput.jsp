<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">글쓰기</div>
<form action="bbsPost.jsp" method="post">
작성자 : <input type="text" name="NAME"/><br/>
글제목 : <input type="text" name="TITLE"/><br/>
<textarea rows="5" cols="30" name="CONTENT"></textarea><br/>
<input type="submit" value="글올리기"/>
<input type="reset" value="취소"/>
<a href="bbsList.jsp"><b>게시글 목록 보기</b></a>
</form>
</body>
</html>