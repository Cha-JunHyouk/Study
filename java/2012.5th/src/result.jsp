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
	String n1 = request.getParameter("NUM1");
	String n2 = request.getParameter("NUM2");
	int num1 = Integer.parseInt(n1);//���ڿ��� ������ ��ȯ
	int num2 = Integer.parseInt(n2);
	int sum = num1 + num2; int sub = num1 - num2; int mul = num1 * num2;
	int div = num1 / num2;//��Ģ������ ����
	//������ ����� request ���尴ü�� �����Ѵ�.
	request.setAttribute("SUM", sum);
	request.setAttribute("SUB", sub);
	request.setAttribute("MUL", mul);
	request.setAttribute("DIV", div);
	//Forward������� �������� calcResult.jsp�� ��ȯ
	RequestDispatcher rd = request.getRequestDispatcher("calcResult.jsp");
	rd.forward(request, response);
	//Forward�� ȭ���� ��ȯ�ϴ� ���, �� ���� ���尴ü(request,response)��
	//���� ����. ����, ������ �����Ͱ� ������ ���尴ü(request)�� �����͸�
	//�����Ѵ�.
%>
</body>
</html>












