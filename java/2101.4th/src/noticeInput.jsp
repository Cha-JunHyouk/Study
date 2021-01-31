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
<h2>공지사항 쓰기</h2>
<form action="noticePost.do" method="post">
제 목 : <input type="text" name="TITLE"/><br/>
내 용 : <br/>
<textarea rows="5" cols="80" name="CONTENT"></textarea><br/>
<input type="submit" value="게시글 올리기"/>&nbsp;
<input type="reset" value=" 취 소 "/>
</form>
</div>
</body>
</html>