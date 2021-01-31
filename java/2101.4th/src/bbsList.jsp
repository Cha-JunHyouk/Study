<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table.bbs_main {border-collapse:collapse;}
th{border:1px solid red;}
td{border:1px solid black;}
</style>
</head>
<body>
<div align="center">
	<h2>게시글 목록</h2>
	<c:if test="${BBSLIST == null }">
		<h3>등록된 게시글이 존재하지 않습니다.</h3>
	</c:if>
	<c:if test="${BBSLIST != null }">
		<table class="bbs_main">
			<tr><th width="10%">글번호</th><th width="20%">작성자</th>
				<th width="50%">글제목</th><th width="20%">작성일</th></tr>
			<c:forEach var="bbs" items="${BBSLIST }">
			<tr><td>${bbs.seqno }</td><td>${bbs.id }</td>
				<td><a href="bbsRead?SEQNO=${bbs.seqno }">${bbs.title }</a></td>
				<td>${bbs.bbs_date }</td></tr>
			</c:forEach>
		</table>
		
		<c:forEach var="page" begin="1" end="${PAGECNT }">
			<a href="bbsList.do?PAGENO=${page }">${page }</a>
		</c:forEach>
	</c:if>
</div>
</body>
</html>




