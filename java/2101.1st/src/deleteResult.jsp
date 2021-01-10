<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>맛집 정보 삭제 결과</h2>
<%
	String result = request.getParameter("R");
	if(result.equals("OK")){
		out.print("<h3>맛집 정보가 삭제되었습니다.</h3>");
	}else {
		out.print("<h3>맛집 정보 삭제에 문제가 발생했습니다.</h3>");
		out.print("<h3>관리자에게 문의해 주세요.</h3>");
	}
%>
<a href="template.jsp">■ 메인으로 돌아가기</a>
<a href="matjipList.jsp">■ 맛집 목록으로 가기</a>
</div>
</body>
</html>