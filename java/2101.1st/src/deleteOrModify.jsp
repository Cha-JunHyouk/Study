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
	request.setCharacterEncoding("euc-kr");//�ѱ�ó��
	String btn = request.getParameter("BTN");//BTN �Ķ���͸� ����
	String seqno = request.getParameter("SEQNO");//SEQNO �Ķ���͸� ����
	String title = request.getParameter("TITLE");
	String writer = request.getParameter("WRITER");
	String company = request.getParameter("COMPANY");
	String price = request.getParameter("PRICE");
	if(btn.equals("�����ϱ�")){
		response.sendRedirect("deleteBook.jsp?SEQNO="+seqno);
	}else if(btn.equals("�����ϱ�")){
		//�Ϸù�ȣ(�⺻Ű)�� ������ ����,����,���ǻ�,���� �׸� �����ϴ�.
// 		response.sendRedirect("updateBook.jsp?SEQNO="+seqno+"&T="+title+
// 			"&W="+writer+"&C="+company+"&P="+price);
		//Forward�� ������ ��ȯ
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










