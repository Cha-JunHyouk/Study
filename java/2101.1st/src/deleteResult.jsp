<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>���� ���� ���� ���</h2>
<%
	String result = request.getParameter("R");
	if(result.equals("OK")){
		out.print("<h3>���� ������ �����Ǿ����ϴ�.</h3>");
	}else {
		out.print("<h3>���� ���� ������ ������ �߻��߽��ϴ�.</h3>");
		out.print("<h3>�����ڿ��� ������ �ּ���.</h3>");
	}
%>
<a href="template.jsp">�� �������� ���ư���</a>
<a href="matjipList.jsp">�� ���� ������� ����</a>
</div>
</body>
</html>