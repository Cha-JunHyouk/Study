<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>도서 등록 결과</h2></div>
<div align="right"><a href="booksList.jsp">도서 목록 보기</a></div>
<div align="center">
<%
	String result = request.getParameter("R");
	if(result.equals("OK")){
		out.print("도서 정보가 등록되었습니다.!!!");
	}else{
		out.print("도서 정보 등록 중 문제가 발생했습니다.<br/>");
		out.print("관리자에게 문의해 주세요.");
	}
%>
</div>
</body>
</html>