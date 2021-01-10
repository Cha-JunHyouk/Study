<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");//한글처리
	String btn = request.getParameter("BTN");//BTN 파라미터를 수신
	String seqno = request.getParameter("SEQNO");//SEQNO 파라미터를 수신
	String title = request.getParameter("TITLE");
	String writer = request.getParameter("WRITER");
	String company = request.getParameter("COMPANY");
	String price = request.getParameter("PRICE");
	if(btn.equals("삭제하기")){
		response.sendRedirect("deleteBook.jsp?SEQNO="+seqno);
	}else if(btn.equals("수정하기")){
		//일련번호(기본키)를 제외한 제목,저자,출판사,가격 항목 가능하다.
// 		response.sendRedirect("updateBook.jsp?SEQNO="+seqno+"&T="+title+
// 			"&W="+writer+"&C="+company+"&P="+price);
		//Forward로 페이지 전환
		request.setAttribute("seqno", seqno);
		request.setAttribute("title", title);
		request.setAttribute("writer", writer);
		request.setAttribute("publisher", company);
		request.setAttribute("price", price);
		RequestDispatcher rd = request.getRequestDispatcher(
				"updateBook.jsp");
		rd.forward(request, response);
	}
%>
</body>
</html>










