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
	<h2>�Խñ� ���</h2>
	<c:if test="${BBSLIST == null }">
		<h3>��ϵ� �Խñ��� �������� �ʽ��ϴ�.</h3>
	</c:if>
	<c:if test="${BBSLIST != null }">
		<table class="bbs_main">
			<tr><th width="10%">�۹�ȣ</th><th width="20%">�ۼ���</th>
				<th width="50%">������</th><th width="20%">�ۼ���</th></tr>
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




